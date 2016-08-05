package com.leoman.report.service.impl;

import com.leoman.common.service.impl.GenericManagerImpl;
import com.leoman.report.dao.ReportDao;
import com.leoman.report.entity.Report;
import com.leoman.report.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Daisy on 2016/8/5.
 */
@Service
@Transactional(readOnly = true)
public class ReportServiceImpl extends GenericManagerImpl<Report,ReportDao> implements ReportService {

    @Autowired
    private ReportDao reportDao;

    @Override
    @Transactional
    public void create(Report report) {
        reportDao.save(report);
    }
}
