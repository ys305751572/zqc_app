package com.leoman.report.api;

import com.leoman.common.controller.common.CommonController;
import com.leoman.report.entity.Report;
import com.leoman.report.service.ReportService;
import com.leoman.utils.Result;
import com.leoman.utils.WebUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 意见反馈
 * Created by Daisy on 2016/8/5.
 */
@Controller
@RequestMapping("/api/report")
public class ReportApi extends CommonController{

    private static Logger logger = LoggerFactory.getLogger(ReportApi.class);

    @Autowired
    private ReportService reportService;

    /**
     * @api {post} /api/report/add  01、新增意见反馈
     * @apiVersion 0.0.1
     * @apiName report.add
     * @apiGroup report
     * @apiDescription 新增意见反馈
     *
     * @apiParam {NUMBER} userId 用户id
     * @apiParam {NUMBER} content 内容
     */
    @RequestMapping("add")
    public void list(HttpServletRequest request,
                     HttpServletResponse response,
                     Report report) throws Exception {

        reportService.create(report);
        WebUtil.printJson(response,new Result().success());
    }

}
