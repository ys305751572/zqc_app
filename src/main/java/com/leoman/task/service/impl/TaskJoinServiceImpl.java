package com.leoman.task.service.impl;

import com.leoman.common.exception.GeneralExceptionHandler;
import com.leoman.common.service.impl.GenericManagerImpl;
import com.leoman.image.service.UploadImageService;
import com.leoman.task.dao.TaskDao;
import com.leoman.task.dao.TaskJoinDao;
import com.leoman.task.dao.TaskJoinImageDao;
import com.leoman.task.entity.Task;
import com.leoman.task.entity.TaskJoin;
import com.leoman.task.entity.TaskJoinImage;
import com.leoman.task.service.TaskJoinService;
import com.leoman.team.dao.TeamDao;
import com.leoman.team.dao.TeamUserDao;
import com.leoman.team.entity.Team;
import com.leoman.team.entity.TeamUser;
import com.leoman.user.dao.UserInfoDao;
import com.leoman.user.dao.YmRecordDao;
import com.leoman.user.entity.IntegralRecord;
import com.leoman.user.entity.UserInfo;
import com.leoman.user.entity.YmRecord;
import com.leoman.user.service.IntegralRecordService;
import com.leoman.user.service.YmRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Daisy on 2016/7/26.
 */
@Service
@Transactional(readOnly = true)
public class TaskJoinServiceImpl extends GenericManagerImpl<TaskJoin,TaskJoinDao> implements TaskJoinService {

    @Autowired
    private TaskJoinDao taskJoinDao;

    @Autowired
    private TaskDao taskDao;

    @Autowired
    private TaskJoinImageDao taskJoinImageDao;

    @Autowired
    private TeamDao teamDao;

    @Autowired
    private UploadImageService uploadImageService;

    @Autowired
    private TeamUserDao teamUserDao;

    @Autowired
    private UserInfoDao userDao;

    @Autowired
    private YmRecordService ymRecordService;

    @Autowired
    private IntegralRecordService integralRecordService;

    /**
     * 参加任务
     */
    @Override
    @Transactional
    public void create(Long taskId, Long joinId) {

        //检验用户是否已参加
        TaskJoin tj = this.findByTaskIdAndJoinId(taskId,joinId);
        if(tj != null){
            GeneralExceptionHandler.handle("task.id = "+taskId+", joinId = "+joinId+"已参加过任务");
        }

        //获取参加的任务
        Task task = taskDao.findOne(taskId);

        if(task != null){

            if((new Date()).getTime() > task.getStartDate()){
                GeneralExceptionHandler.handle("只能在任务开始之前报名参加任务");
            }

            //益起来任务
            if(task.getType().equals(1)){
                if(task.getJoinNum() >= task.getNums()){
                    GeneralExceptionHandler.handle("参加人数已满，无法参加");
                }

                //如果是团队任务，则只能队长报名
                /*if(task.getJoinType().equals(2)){
                    Team team = teamDao.findByUserId(joinId);
                    if(team == null){
                        GeneralExceptionHandler.handle("对不起，团队任务只能队长参加");
                    }else {
                        joinId = team.getId();
                    }
                }*/
            }

            //新增任务参加
            TaskJoin taskJoin = new TaskJoin();
            taskJoin.setJoinId(joinId);
            taskJoin.setTask(new Task(taskId));
            taskJoin.setStatus(0);//报名即0-进行中
            taskJoinDao.save(taskJoin);

            //修改任务的已参加人数
            task.setJoinNum(task.getJoinNum() + 1);
            taskDao.save(task);
        }
    }

    @Override
    @Transactional
    public void createTaskJoinImage(Long taskId, Long joinId, MultipartFile[] images) {

        TaskJoin tj = this.findByTaskIdAndJoinId(taskId,joinId);
        if(tj == null || !tj.getStatus().equals(0)){
            GeneralExceptionHandler.handle("未参加任务，无法上传图片");
        }

        Set<TaskJoinImage> set = new HashSet<>();
        for (MultipartFile file:images) {
            TaskJoinImage tji = new TaskJoinImage();
            String imageUrl = uploadImageService.uploadFile(file);
            tji.setTaskJoinId(tj.getId());
            tji.setImageUrl(imageUrl);
            taskJoinImageDao.save(tji);
            set.add(tji);
        }

        tj.setImages(set);
        taskJoinDao.save(tj);

    }

    @Override
    public TaskJoin findByTaskIdAndJoinId(Long taskId, Long joinId) {
        return taskJoinDao.findByTaskIdAndJoinId(taskId, joinId);
    }

    @Override
    public Page<TaskJoin> findByUserId(Long userId, Integer status, Integer currentPage, Integer pageSize) {
        TeamUser teamUser = teamUserDao.findByUserId(userId);
        Long teamId = teamUser==null?0:teamUser.getTeamId();
        Page<TaskJoin> taskJoinList = taskJoinDao.findByUserIdOrTeamId(userId, teamId, status, new PageRequest(currentPage-1, pageSize, Sort.Direction.DESC, "id"));
        return taskJoinList;
    }

    /**
     * 分配益米和积分
     * @param userId
     * @param taskJoinId
     * @param ym
     */
    @Override
    @Transactional
    public void allotYm(Long userId, Long taskJoinId, Integer ym){
        TaskJoin taskJoin = taskJoinDao.findOne(taskJoinId);
        if(taskJoin == null || taskJoin.getTask() == null){
            GeneralExceptionHandler.handle("此活动记录不存在");
        }

        if(!taskJoin.getStatus().equals(1) && !taskJoin.getIsAllot().equals(1)){
            GeneralExceptionHandler.handle("只有已完成的未分配益米的活动才能分配益米");
        }

        if(!taskJoin.getTask().getJoinType().equals(1)){
            GeneralExceptionHandler.handle("只有团队任务才能分配益米");
        }

        Team team = teamDao.findOne(taskJoin.getJoinId());
        if(team == null || !team.getUserId().equals(userId)){
            GeneralExceptionHandler.handle("只有队长才能分配益米");
        }

        //分配益米
        Task task = taskJoin.getTask();

        Integer limitPerYm = task.getRewardYm()/team.getNums();//每个人能分配的最多益米数
        if(ym > limitPerYm){
            GeneralExceptionHandler.handle("每个人最多能分配的益米数为："+limitPerYm);
        }

        //修改该活动参与的分配状态为：已分配
        taskJoin.setIsAllot(1);
        taskJoinDao.save(taskJoin);

        //给团队的每个人分配益米
        List<TeamUser> teamUserList = teamUserDao.findByTeamId(team.getId());

        for (TeamUser tu:teamUserList) {
            UserInfo user = userDao.findOne(tu.getUserId());
            if(user != null){
                //新增益米变化记录
                YmRecord ymRecord = new YmRecord();
                ymRecord.setType(0);
                ymRecord.setJoinId(user.getId());
                ymRecord.setYm(+ym);
                ymRecord.setContent("完成团队任务：["+task.getName()+"]分配个人益米");
                ymRecordService.create(ymRecord);
            }
        }

        //剩下的益米分配给该团队
        Integer restYm = task.getRewardYm() - team.getNums()*ym;
        if(restYm > 0){
            //新增益米变化记录
            YmRecord yr = new YmRecord();
            yr.setType(1);
            yr.setJoinId(team.getId());
            yr.setYm(+restYm);
            yr.setContent("完成团队任务：["+task.getName()+"]分配团队益米");
            ymRecordService.create(yr);
        }

        //该任务所有的积分分配给该团队
        IntegralRecord integralRecord = new IntegralRecord();
        integralRecord.setType(1);
        integralRecord.setJoinId(team.getId());
        integralRecord.setIntegral(+task.getRewardIntegral());
        integralRecord.setContent("完成团队任务：["+task.getName()+"]所得积分");
        integralRecordService.create(integralRecord);
    }

}
