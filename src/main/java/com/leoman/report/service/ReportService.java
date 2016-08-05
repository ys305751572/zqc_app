package com.leoman.report.service;


import com.leoman.common.service.GenericManager;
import com.leoman.report.entity.Report;

/**
 * Created by Daisy on 2016/8/4.
 */
public interface ReportService extends GenericManager<Report> {

    public void create(Report report);

}
