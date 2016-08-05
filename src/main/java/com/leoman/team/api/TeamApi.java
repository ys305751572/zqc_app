package com.leoman.team.api;

import com.leoman.common.controller.common.CommonController;
import com.leoman.common.core.Configue;
import com.leoman.common.entity.PageVO;
import com.leoman.enums.ErrorType;
import com.leoman.image.entity.Image;
import com.leoman.image.service.UploadImageService;
import com.leoman.task.entity.Task;
import com.leoman.task.entity.TaskJoin;
import com.leoman.task.service.TaskJoinService;
import com.leoman.task.service.TaskService;
import com.leoman.team.entity.Team;
import com.leoman.team.service.TeamService;
import com.leoman.user.entity.UserInfo;
import com.leoman.utils.JsonUtil;
import com.leoman.utils.Result;
import com.leoman.utils.WebUtil;
import org.apache.commons.lang.StringUtils;
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

/**
 * 团队
 * Created by Daisy on 2016/7/27.
 */
@Controller
@RequestMapping("/api/team")
public class TeamApi extends CommonController{

    private static Logger logger = LoggerFactory.getLogger(TeamApi.class);

    @Autowired
    private TeamService teamService;

    @Autowired
    private UploadImageService uploadImageService;

    /**
     * @api {post} /api/team/add  01、创建一个团队
     * @apiVersion 0.0.1
     * @apiName team.add
     * @apiGroup team
     * @apiDescription 创建一个团队
     *
     * @apiParam {String} name 团队名称
     * @apiParam {String} slogan 团队口号
     * @apiParam {NUMBER} userId 用户id
     * @apiParam {file} cover 团队封面
     */
    @RequestMapping("add")
    public void add(HttpServletRequest request,
                       HttpServletResponse response,
                    String slogan,
                     @RequestParam(required=true) String name,
                     @RequestParam(required=true) Long userId,
                    @RequestParam(required = false) MultipartFile cover
                    ) throws Exception {

        Team team = teamService.create(name, slogan,userId, cover);
        WebUtil.printJson(response,getTeamJson(team));
    }

    /**
     * @api {post} /api/team/join  02、加入一个团队
     * @apiVersion 0.0.1
     * @apiName team.join
     * @apiGroup team
     * @apiDescription 加入一个团队
     *
     * @apiParam {NUMBER} teamId 团队id
     * @apiParam {NUMBER} userId 用户id
     */
    @RequestMapping("join")
    public void join(HttpServletRequest request,
                    HttpServletResponse response,
                    @RequestParam(required=true) Long teamId,
                    @RequestParam(required=true) Long userId) throws Exception {

        teamService.join(teamId, userId);
        WebUtil.printJson(response,new Result().success());
    }

    /**
     * @api {post} /api/team/info  03、获取一个团队的信息
     * @apiVersion 0.0.1
     * @apiName team.info
     * @apiGroup team
     * @apiDescription 加入一个团队
     *
     * @apiParam {NUMBER} teamId 团队id
     *
     * @apiSuccess {NUMBER} id 团队id
     * @apiSuccess {String} name 团队名称
     * @apiSuccess {String} slogan 团队口号
     * @apiSuccess {NUMBER} integral 积分
     * @apiSuccess {NUMBER} ym 益米
     * @apiSuccess {NUMBER} coverUrl 封面图片
     *
     * @apiSuccess {Object}   user 用户对象
     * @apiSuccess {NUMBER}   user.id 用户id
     * @apiSuccess {NUMBER}   user.nickname 用户昵称
     * @apiSuccess {String}   user.avater 用户头像
     */
    @RequestMapping("info")
    public void info(HttpServletRequest request,
                     HttpServletResponse response,
                     @RequestParam(required=true) Long teamId) throws Exception {

        Team team = teamService.queryByPK(teamId);
        WebUtil.printJson(response,getTeamJson(team));
    }

    /**
     * @api {post} /api/team/cover/upload 04、修改团队封面
     * @apiVersion 0.0.1
     * @apiName team.coverUpload
     * @apiGroup team
     * @apiDescription 修改团队封面
     *
     * @apiParam {NUMBER} teamId 团队ID
     * @apiParam {FILE} file 封面
     */
    @RequestMapping(value = "/cover/upload")
    public void coverUpload(HttpServletRequest request,
                               HttpServletResponse response,
                               @RequestParam(required = true) Long teamId,
                               @RequestParam(required = true) MultipartFile cover)throws Exception  {

        String coverUrl = uploadImageService.uploadFile(cover);
        Team team = teamService.queryByPK(teamId);
        team.setCoverUrl(coverUrl);
        teamService.save(team);
        WebUtil.printJson(response,getTeamJson(team));
    }

    /**
     * @api {post} /api/team/edit 05、修改团队信息
     * @apiVersion 0.0.1
     * @apiName team.edit
     * @apiGroup team
     * @apiDescription 修改团队封面
     *
     * @apiParam {NUMBER} teamId 团队ID
     * @apiParam {String} slogan 口号
     */
    @RequestMapping(value = "/edit")
    public void edit(HttpServletRequest request,
                            HttpServletResponse response,
                     @RequestParam(required = true) Long teamId,
                     String slogan)throws Exception  {

        Team team = teamService.queryByPK(teamId);
        if(team == null){
            WebUtil.printJson(response,new Result(ErrorType.ERROR_CODE_1001));//没有数据
            return ;
        }
        if(slogan != null){
            team.setSlogan(slogan);
        }
        teamService.save(team);
        WebUtil.printJson(response,getTeamJson(team));
    }

    /**
     * @api {post} /api/team/quit  06、退出一个团队
     * @apiVersion 0.0.1
     * @apiName team.quit
     * @apiGroup team
     * @apiDescription 退出一个团队
     *
     * @apiParam {NUMBER} teamId 团队id
     * @apiParam {NUMBER} userId 用户id
     */
    @RequestMapping("quit")
    public void quit(HttpServletRequest request,
                     HttpServletResponse response,
                     @RequestParam(required = true) Long teamId,
                     @RequestParam(required=true) Long userId) throws Exception {

        teamService.quit(teamId, userId);
        WebUtil.printJson(response,new Result().success());
    }

    /**
     * @api {post} /api/team/list  07、排行榜-获取团队列表
     * @apiVersion 0.0.1
     * @apiName team.list
     * @apiGroup team
     * @apiDescription 排行榜-获取团队列表
     *
     * @apiParam {NUMBER} pageNum 页码
     * @apiParam {NUMBER} pageSize 每页请求数
     *
     * @apiSuccess {NUMBER} id 团队id
     * @apiSuccess {String} name 团队名称
     * @apiSuccess {String} slogan 团队口号
     * @apiSuccess {NUMBER} integral 积分
     * @apiSuccess {NUMBER} ym 益米
     * @apiSuccess {NUMBER} coverUrl 封面图片
     *
     * @apiSuccess {Object}   user 用户对象
     * @apiSuccess {NUMBER}   user.id 用户id
     * @apiSuccess {NUMBER}   user.nickname 用户昵称
     * @apiSuccess {String}   user.avater 用户头像
     */
    @RequestMapping("list")
    public void list(HttpServletRequest request,
                     HttpServletResponse response,
                     @RequestParam(required=true) Integer pageNum,
                     @RequestParam(required=true) Integer pageSize) throws Exception {

        Page<Team> page = teamService.findAll(pageNum,pageSize);
        WebUtil.printJson(response,new Result().success(new PageVO(page)));
    }


    private String getTeamJson(Team team){
        if(team != null){
            if(StringUtils.isNotBlank(team.getCoverUrl())){
                team.setCoverUrl(Configue.getUploadUrl()+ team.getCoverUrl());
            }else{
                team.setCoverUrl("");
            }
        }
        String result =  JsonUtil.obj2Json(new Result().success(createMap("team", team)));
        return result;
    }
}
