package com.leoman.task.api;

import com.leoman.common.controller.common.CommonController;
import com.leoman.common.core.Configue;
import com.leoman.common.entity.PageVO;
import com.leoman.enums.ErrorType;
import com.leoman.task.entity.Task;
import com.leoman.task.entity.TaskJoin;
import com.leoman.task.service.TaskJoinService;
import com.leoman.task.service.TaskService;
import com.leoman.task.service.impl.TaskServiceImpl;
import com.leoman.utils.Result;
import com.leoman.utils.WebUtil;
import com.leoman.utils.XlsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * 任务
 * Created by Daisy on 2016/7/25.
 */
@Controller
@RequestMapping("/api/task")
public class TaskApi extends CommonController{

    private static Logger logger = LoggerFactory.getLogger(TaskApi.class);

    @Autowired
    private TaskService taskService;//任务

    @Autowired
    private TaskJoinService taskJoinService;

    /**
     * @api {post} /api/task/list  01、获取任务列表
     * @apiVersion 0.0.1
     * @apiName task.list
     * @apiGroup task
     * @apiDescription 获取任务列表
     *
     * @apiParam {NUMBER} type 类型：1-益起来任务，2-脑洞开了没任务
     * @apiParam {NUMBER} joinType 活动类型 0:个人 1:团队
     * @apiParam {NUMBER} pageNum 页码
     * @apiParam {NUMBER} pageSize 每页请求数
     *
     * @apiSuccess {NUMBER}  id 任务id
     * @apiSuccess {NUMBER}  type 类型：1-益起来任务，2-脑洞开了没任务
     * @apiSuccess {String}  name 任务名称
     * @apiSuccess {String}  coverUrl 封面图片
     * @apiSuccess {NUMBER}  joinType 活动类型 0:个人 1:团队
     * @apiSuccess {NUMBER}  startDate 任务开始时间
     * @apiSuccess {String}  endDate 任务结束时间
     * @apiSuccess {String}  address 活动地点
     * @apiSuccess {String}  organizers 主办方
     * @apiSuccess {NUMBER}  nums 所需人数
     * @apiSuccess {NUMBER}  joinNum 已参加人数
     * @apiSuccess {NUMBER}  rewardYm 奖励益米
     * @apiSuccess {NUMBER}  rewardIntegral 奖励积分
     * @apiSuccess {String}  detail 详情
     *
     */
    @RequestMapping("list")
    public void list(HttpServletRequest request,
                     HttpServletResponse response,
                     Task task,
                     @RequestParam(required=true) Integer pageNum,
                     @RequestParam(required=true) Integer pageSize) throws Exception {
        if(task.getType() == null){
            WebUtil.printJson(response,new Result(ErrorType.ERROR_CODE_1001));//type必须传
            return ;
        }
        Page<Task> page = taskService.findAll(task, pageNum, pageSize);
        for (Task tk:page.getContent()) {
            if(!StringUtils.isEmpty(tk.getCoverUrl())){
                tk.setCoverUrl(Configue.getUploadUrl()+tk.getCoverUrl());
            }
        }
        WebUtil.printJson(response,new Result().success(new PageVO(page)));
    }


    /**
     * @api {post} /api/task/detail  02、获取任务详情
     * @apiVersion 0.0.1
     * @apiName task.detail
     * @apiGroup task
     * @apiDescription 获取任务详情
     *
     * @apiParam {NUMBER} type 类型：1-益起来任务，2-脑洞开了没任务
     * @apiParam {NUMBER} joinType 活动类型 0:个人 1:团队
     * @apiParam {NUMBER} pageNum 页码
     * @apiParam {NUMBER} pageSize 每页请求数
     *
     * @apiSuccess {NUMBER}  id 任务id
     * @apiSuccess {NUMBER}  type 类型：1-益起来任务，2-脑洞开了没任务
     * @apiSuccess {String}  name 任务名称
     * @apiSuccess {String}  coverUrl 封面图片
     * @apiSuccess {NUMBER}  joinType 活动类型 0:个人 1:团队
     * @apiSuccess {NUMBER}  startDate 任务开始时间
     * @apiSuccess {String}  endDate 任务结束时间
     * @apiSuccess {String}  address 活动地点
     * @apiSuccess {String}  organizers 主办方
     * @apiSuccess {NUMBER}  nums 所需人数
     * @apiSuccess {NUMBER}  joinNum 已参加人数
     * @apiSuccess {NUMBER}  rewardYm 奖励益米
     * @apiSuccess {NUMBER}  rewardIntegral 奖励积分
     * @apiSuccess {String}  detail 详情
     * @apiSuccess {NUMBER}  joinStatus 参加状态：null-未报名，0-进行中，1-已完成，2-未完成
     */
    @RequestMapping("detail")
    public void detail(HttpServletRequest request,
                     HttpServletResponse response,
                       @RequestParam(required=true) Long taskId,
                       Long joinId) throws Exception {

        Task task = taskService.queryByPK(taskId);
        TaskJoin taskJoin = taskJoinService.findByTaskIdAndJoinId(taskId, joinId);
        if(taskJoin != null){
            task.setJoinStatus(taskJoin.getStatus());
        }
        WebUtil.printJson(response,new Result().success(createMap("task",task)));
    }

    /**
     * @api {post} /api/task/join  03、报名参加任务
     * @apiVersion 0.0.1
     * @apiName task.join
     * @apiGroup task
     * @apiDescription 报名参加任务
     *
     * @apiParam {NUMBER} joinId 用户id或团队id
     * @apiParam {NUMBER} taskId 任务id
     */
    @RequestMapping("join")
    public void join(HttpServletRequest request,
                       HttpServletResponse response,
                     @RequestParam(required=true) Long taskId,
                     @RequestParam(required=true) Long joinId) throws Exception {

        taskJoinService.create(taskId, joinId);
        WebUtil.printJson(response,new Result().success());
    }

    /**
     * @api {post} /api/task/upload  04、上传图片至已参加的任务进行审核
     * @apiVersion 0.0.1
     * @apiName task.upload
     * @apiGroup task
     * @apiDescription 报名参加任务
     *
     * @apiParam {NUMBER} joinId 用户id或团队id
     * @apiParam {NUMBER} taskId 任务id
     */
    @RequestMapping("upload")
    public void upload(HttpServletRequest request,
                     HttpServletResponse response,
                       @RequestParam(required=true) Long taskId,
                       @RequestParam(required=true) Long joinId,
                       @RequestParam(required = false) MultipartFile[] images) throws Exception {

        //上传参加任务的图片
        taskJoinService.createTaskJoinImage(taskId,joinId,images);
        WebUtil.printJson(response,new Result().success());
    }


    /**
     * 自己写着练手的，没有此接口
     * @param request
     * @param response
     * @param file
     * @throws Exception
     */
    @RequestMapping("importXls")
    public void importXls(HttpServletRequest request,
                       HttpServletResponse response,
                        @RequestParam(required = false)MultipartFile file) throws Exception {


        taskService.importXls(file);
        WebUtil.printJson(response,new Result().success());
    }

    @RequestMapping("exportXls")
    public void exportXls(HttpServletRequest request,
                          HttpServletResponse response) throws Exception {


        taskService.exportXls(Configue.getUploadPath()+"test.xls");
        WebUtil.printJson(response,new Result().success());
    }


}
