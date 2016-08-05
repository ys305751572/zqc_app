package com.leoman.banner.api;

import com.leoman.banner.entity.Banner;
import com.leoman.banner.service.BannerService;
import com.leoman.common.controller.common.CommonController;
import com.leoman.utils.Result;
import com.leoman.utils.WebUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * banner图
 * Created by Daisy on 2016/8/4.
 */
@Controller
@RequestMapping("/api/banner")
public class BannerApi extends CommonController{

    private static Logger logger = LoggerFactory.getLogger(BannerApi.class);

    @Autowired
    private BannerService bannerService;

    /**
     * @api {post} /api/banner/list  01、获取banner列表
     * @apiVersion 0.0.1
     * @apiName banner.list
     * @apiGroup banner
     * @apiDescription 获取banner列表
     *
     * @apiParam {NUMBER} position 位置 0:首页 1:商城
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
                     @RequestParam(required=true) Integer position) throws Exception {

        List<Banner> list = bannerService.findByPosition(position);
        WebUtil.printJson(response,new Result().success(createMap("list",list)));
    }


}
