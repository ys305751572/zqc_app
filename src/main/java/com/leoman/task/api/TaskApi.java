package com.leoman.task.api;

import com.leoman.common.controller.common.CommonController;
import com.leoman.common.core.Configue;
import com.leoman.common.entity.PageVO;
import com.leoman.dynamic.entity.*;
import com.leoman.dynamic.service.DynamicCollectionService;
import com.leoman.dynamic.service.DynamicCommentService;
import com.leoman.dynamic.service.DynamicPraiseService;
import com.leoman.dynamic.service.DynamicService;
import com.leoman.enums.ErrorType;
import com.leoman.task.entity.Task;
import com.leoman.task.service.TaskService;
import com.leoman.user.entity.UserInfo;
import com.leoman.utils.Result;
import com.leoman.utils.WebUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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

    /**
     * @api {post} /api/task/list  01、获取任务列表
     * @apiVersion 0.0.1
     * @apiName task.list
     * @apiGroup task
     * @apiDescription 获取朋友圈列表
     *
     * @apiParam {NUMBER} pageNum 页码
     * @apiParam {NUMBER} pageSize 每页请求数
     *
     * @apiSuccess {Object}   list  朋友圈列表集合
     * @apiSuccess {NUMBER}   id 动态id
     * @apiSuccess {String}   title 标题
     * @apiSuccess {String}   content 内容
     * @apiSuccess {String}   vedioUrl 音频路径
     * @apiSuccess {NUMBER}   isTop 是否置顶（1-是，0-否）
     * @apiSuccess {String}   status 状态（0-正常，1-删除）
     * @apiSuccess {Boolean}  isPraise 是否点赞
     * @apiSuccess {Boolean}  isCollect 是否收藏
     *
     * @apiSuccess {Object}   user 用户对象
     * @apiSuccess {NUMBER}   user.id 用户id
     * @apiSuccess {NUMBER}   user.nickname 用户昵称
     * @apiSuccess {String}   user.avater 用户头像
     *
     * @apiSuccess {Object}   images 图片对象
     * @apiSuccess {String}   images.imageUrl 图片路径
     */
    @RequestMapping("list")
    public void list(HttpServletRequest request,
                     HttpServletResponse response,
                     Task task,
                     @RequestParam(required=true) Integer pageNum,
                     @RequestParam(required=true) Integer pageSize,
                     Long userId) throws Exception {
        Page<Task> page = taskService.findAll(task, pageNum,pageSize);
        /*for (Dynamic dynamic:page.getContent()) {
            dynamic.setIsPraise(false);
            DynamicPraise dp = dynamicPraiseService.findByDynamicIdAndUserId(dynamic.getId(),userId);
            if(dp != null){
                dynamic.setIsPraise(true);//是否点赞
            }

            dynamic.setIsCollect(false);
            DynamicCollection dc = dynamicCollectionService.findByDynamicIdAndUserId(dynamic.getId(),userId);
            if(dc != null){
                dynamic.setIsCollect(true);//是否收藏
            }

            for (DynamicImage di:dynamic.getImages()) {
                di.setImageUrl(Configue.getUploadUrl()+di.getImageUrl());
            }
        }*/
        WebUtil.printJson(response,new Result().success(new PageVO(page)));
    }



}
