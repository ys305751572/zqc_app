package com.leoman.task.service.impl;

import com.leoman.common.exception.GeneralExceptionHandler;
import com.leoman.common.service.impl.GenericManagerImpl;
import com.leoman.dynamic.entity.DynamicImage;
import com.leoman.image.service.UploadImageService;
import com.leoman.task.dao.TaskDao;
import com.leoman.task.dao.TaskJoinDao;
import com.leoman.task.dao.TaskJoinImageDao;
import com.leoman.task.entity.Task;
import com.leoman.task.entity.TaskJoin;
import com.leoman.task.entity.TaskJoinImage;
import com.leoman.task.service.TaskJoinService;
import com.leoman.task.service.TaskService;
import com.leoman.team.dao.TeamDao;
import com.leoman.team.dao.TeamUserDao;
import com.leoman.team.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.*;

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
            taskJoin.setCreateDate(System.currentTimeMillis());
            taskJoin.setUpdateDate(System.currentTimeMillis());
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
            tji.setCreateDate(System.currentTimeMillis());
            tji.setUpdateDate(System.currentTimeMillis());
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
}
