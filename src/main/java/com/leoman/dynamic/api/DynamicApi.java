package com.leoman.dynamic.api;

import com.leoman.common.controller.common.CommonController;
import com.leoman.common.core.Configue;
import com.leoman.common.entity.PageVO;
import com.leoman.dynamic.entity.*;
import com.leoman.dynamic.service.*;
import com.leoman.enums.ErrorType;
import com.leoman.image.service.UploadImageService;
import com.leoman.user.entity.UserInfo;
import com.leoman.utils.Result;
import com.leoman.utils.WebUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 朋友圈动态
 * Created by Daisy on 2016/7/21.
 */
@Controller
@RequestMapping("/api/dynamic")
public class DynamicApi extends CommonController{

    private static Logger logger = LoggerFactory.getLogger(DynamicApi.class);

    @Autowired
    private DynamicService dynamicService;//动态

    @Autowired
    private DynamicPraiseService dynamicPraiseService;//动态点赞

    @Autowired
    private DynamicCollectionService dynamicCollectionService;//收藏

    @Autowired
    private DynamicCommentService dynamicCommentService;//评论

    @Autowired
    private DynamicGiveService dynamicGiveService;//打赏

    /**
     * @api {post} /api/dynamic/add  01、发表朋友圈
     * @apiVersion 0.0.1
     * @apiName dynamic.add
     * @apiGroup dynamic
     * @apiDescription 发表朋友圈
     *
     * @apiParam {NUMBER} userId 用户id
     * @apiParam {STRING} content 内容
     * @apiParam {file} vedio 音频文件
     * @apiParam {files} images 图片文件
     */
    @RequestMapping("add")
    public void add(HttpServletRequest request,
                         HttpServletResponse response,
                         @RequestParam(required = true) Long userId,
                         String content,
                         @RequestParam(required = false) MultipartFile vedio,
                         @RequestParam(required = false) MultipartFile[] images) throws Exception {
        UserInfo user = getUserByRequest(request);
        if(user == null){
            WebUtil.printJson(response,new Result(ErrorType.ERROR_CODE_2004));//用户不存在
            return ;
        }

        //新增朋友圈动态
        Dynamic dynamic = dynamicService.create(userId, content, vedio, images);
        WebUtil.printJson(response,new Result().success(createMap("dynamic", dynamic)));
    }


    /**
     * @api {post} /api/dynamic/list  02、获取朋友圈列表
     * @apiVersion 0.0.1
     * @apiName dynamic.list
     * @apiGroup dynamic
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
                     Long userId,
                     @RequestParam(required=true) Integer pageNum,
                     @RequestParam(required=true) Integer pageSize
                     ) throws Exception {
        Page<Dynamic> page = dynamicService.findAll(pageNum,pageSize);
        for (Dynamic dynamic:page.getContent()) {
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
                if(!StringUtils.isEmpty(di.getImageUrl())){
                    di.setImageUrl(Configue.getUploadUrl()+di.getImageUrl());
                }
            }
        }
        WebUtil.printJson(response,new Result().success(new PageVO(page)));
    }

    /**
     * @api {post} /api/dynamic/delete  03、删除朋友圈
     * @apiVersion 0.0.1
     * @apiName dynamic.delete
     * @apiGroup dynamic
     * @apiDescription 发表朋友圈
     *
     * @apiParam {NUMBER} userId 当前登录用户id
     * @apiParam {NUMBER} dynamicId 动态id
     */
    @RequestMapping("delete")
    public void delete(HttpServletRequest request,
                       HttpServletResponse response,
                       @RequestParam(required = true) Long dynamicId,
                       @RequestParam(required = true) Long userId) throws Exception {
        Dynamic dynamic = dynamicService.queryByPK(dynamicId);
        if(dynamic == null){
            WebUtil.printJson(response,new Result(ErrorType.ERROR_CODE_1001));//未找到数据
            return ;
        }

        if(!dynamic.getUser().getId().equals(userId)){
            WebUtil.printJson(response,new Result(ErrorType.ERROR_CODE_3001));//无法删除他人数据
            return ;
        }

        //删除朋友圈
        dynamicService.deleteByPK(dynamicId);
        WebUtil.printJson(response,new Result().success());
    }

    /**
     * @api {post} /api/dynamic/operate  04、点赞和取消点赞/收藏和取消收藏
     * @apiVersion 0.0.1
     * @apiName dynamic.praise
     * @apiGroup dynamic
     * @apiDescription 发表朋友圈
     *
     * @apiParam {STRING} oper 操作：add-新增， cancel-取消
     * @apiParam {STRING} type 操作类型：praise-点赞， collection-收藏
     * @apiParam {NUMBER} dynamicId 动态id
     * @apiParam {NUMBER} userId 用户id
     */
    @RequestMapping("operate")
    public void operate(HttpServletRequest request,
                    HttpServletResponse response,
                        @RequestParam(required = true) String oper,
                       @RequestParam(required = true) String type,
                        @RequestParam(required = true) Long dynamicId,
                        @RequestParam(required = true) Long userId) throws Exception {
        UserInfo user = getUserByRequest(request);
        if(user == null){
            WebUtil.printJson(response,new Result(ErrorType.ERROR_CODE_2004));//用户不存在
            return ;
        }

        //点赞
        if("praise".equals(type)){
            dynamicPraiseService.operate(oper, dynamicId, userId);
        }
        //收藏
        else if("collection".equals(type)){
            dynamicCollectionService.operate(oper, dynamicId, userId);
        }else{
            WebUtil.printJson(response,new Result(ErrorType.ERROR_CODE_1004));//type类型错误
            return ;
        }

        WebUtil.printJson(response,new Result().success());
    }

    /**
     * @api {post} /api/dynamic/praise/userList  05、获取某条动态的所有点赞用户
     * @apiVersion 0.0.1
     * @apiName dynamic.praiseUserList
     * @apiGroup dynamic
     * @apiDescription 获取某条动态的所有点赞用户
     *
     * @apiParam {NUMBER} dynamicId 动态id
     *
     * @apiSuccess {Object}   list  点赞用户集合
     * @apiSuccess {NUMBER}   id 用户id
     * @apiSuccess {NUMBER}   nickname 用户昵称
     * @apiSuccess {String}   avater 用户头像
     */
    @RequestMapping("praise/userList")
    public void praiseUserList(HttpServletRequest request,
                                HttpServletResponse response,
                               @RequestParam(required = true) Long dynamicId) throws Exception {
        List<UserInfo> userList = dynamicPraiseService.findByDynamicId(dynamicId);
        WebUtil.printJson(response,new Result().success(createMap("list",userList)));
    }

    /**
     * @api {post} /api/dynamic/collectList  06、显示收藏的朋友圈列表
     * @apiVersion 0.0.1
     * @apiName dynamic.collectList
     * @apiGroup dynamic
     * @apiDescription 显示收藏的朋友圈列表
     *
     * @apiParam {NUMBER} userId 用户id
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
     *
     * @apiSuccess {Object}   user 用户对象
     * @apiSuccess {NUMBER}   user.id 用户id
     * @apiSuccess {NUMBER}   user.nickname 用户昵称
     * @apiSuccess {String}   user.avater 用户头像
     *
     * @apiSuccess {Object}   images 图片对象
     * @apiSuccess {String}   images.imageUrl 图片路径
     */
    @RequestMapping("collectList")
    public void collectList(HttpServletRequest request,
                     HttpServletResponse response,
                            @RequestParam(required=true) Long userId,
                     @RequestParam(required=true) Integer pageNum,
                     @RequestParam(required=true) Integer pageSize) throws Exception {
        UserInfo user = getUserByRequest(request);
        if(user == null){
            WebUtil.printJson(response,new Result(ErrorType.ERROR_CODE_2004));//用户不存在
            return ;
        }

        Page<Dynamic> page = dynamicCollectionService.findByDyUserId(userId,pageNum,pageSize);
        WebUtil.printJson(response,new Result().success(new PageVO(page)));
    }

    /**
     * @api {post} /api/dynamic/comment/add  07、评论
     * @apiVersion 0.0.1
     * @apiName dynamic.commentAdd
     * @apiGroup dynamic
     * @apiDescription 发表朋友圈
     *
     * @apiParam {STRING} dynamic.id 动态id
     * @apiParam {STRING} fromUser.id 评论发起人id
     * @apiParam {STRING} toUser.id 评论接收人id
     * @apiParam {STRING} content 内容
     */
    @RequestMapping("comment/add")
    public void commentAdd(HttpServletRequest request,
                    HttpServletResponse response,
                    DynamicComment dynamicComment) throws Exception {

        dynamicCommentService.create(dynamicComment);
        WebUtil.printJson(response,new Result().success());
    }

    /**
     * @api {post} /api/dynamic/commentList  08、获取某条动态的评论列表
     * @apiVersion 0.0.1
     * @apiName dynamic.commentList
     * @apiGroup dynamic
     * @apiDescription 获取某条动态的评论列表
     *
     * @apiParam {NUMBER} dynamicId 动态id
     *
     * @apiSuccess {NUMBER}   id 评论id
     * @apiSuccess {String}   content 评论内容
     * @apiSuccess {String}   createDate 评论时间
     *
     * @apiSuccess {Object}   fromUser 发起评论用户对象
     * @apiSuccess {NUMBER}   fromUser.id 用户id
     * @apiSuccess {NUMBER}   fromUser.nickname 用户昵称
     *
     * @apiSuccess {Object}   toUser 被评论用户对象
     * @apiSuccess {NUMBER}   toUser.id 用户id
     * @apiSuccess {NUMBER}   toUser.nickname 用户昵称
     *
     * @apiSuccess {Object}   images 图片对象
     * @apiSuccess {String}   images.imageUrl 图片路径
     */
    @RequestMapping("commentList")
    public void commentList(HttpServletRequest request,
                            HttpServletResponse response,
                            @RequestParam(required=true) Long dynamicId) throws Exception {

        List<DynamicComment> commentList = dynamicCommentService.findByDynamicId(dynamicId);
        WebUtil.printJson(response,new Result().success(createMap("list",commentList)));
    }

    /**
     * @api {post} /api/dynamic/comment/delete  09、删除自己发起的评论
     * @apiVersion 0.0.1
     * @apiName dynamic.commentDelete
     * @apiGroup dynamic
     * @apiDescription 删除自己发起的评论
     *
     * @apiParam {NUMBER} userId 当前登录用户id
     * @apiParam {NUMBER} commentId 动态id
     */
    @RequestMapping("comment/delete")
    public void commentDelete(HttpServletRequest request,
                       HttpServletResponse response,
                       @RequestParam(required = true) Long commentId,
                       @RequestParam(required = true) Long userId) throws Exception {
        DynamicComment dynamicComment = dynamicCommentService.queryByPK(commentId);
        if(dynamicComment == null){
            WebUtil.printJson(response,new Result(ErrorType.ERROR_CODE_1001));//未找到数据
            return ;
        }

        if(!dynamicComment.getFromUser().getId().equals(userId)){
            WebUtil.printJson(response,new Result(ErrorType.ERROR_CODE_3001));//无法删除他人数据
            return ;
        }

        //删除评论
        dynamicCommentService.delete(dynamicComment);
        WebUtil.printJson(response,new Result().success());
    }

    /**
     * @api {post} /api/dynamic/give  10、打赏朋友圈
     * @apiVersion 0.0.1
     * @apiName dynamic.give
     * @apiGroup dynamic
     * @apiDescription 打赏朋友圈
     *
     * @apiParam {NUMBER} dynamic.id 动态id
     * @apiParam {NUMBER} user.id 用户id
     * @apiParam {NUMBER} ym 打赏益米数
     */
    @RequestMapping("give")
    public void give(HttpServletRequest request,
                              HttpServletResponse response,
                              DynamicGive dynamicGive) throws Exception {

        dynamicGiveService.create(dynamicGive);
        WebUtil.printJson(response,new Result().success());
    }

}
