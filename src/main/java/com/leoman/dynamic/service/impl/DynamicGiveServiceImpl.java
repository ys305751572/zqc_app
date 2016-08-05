package com.leoman.dynamic.service.impl;

import com.leoman.common.exception.GeneralExceptionHandler;
import com.leoman.common.service.impl.GenericManagerImpl;
import com.leoman.dynamic.dao.DynamicGiveDao;
import com.leoman.dynamic.entity.DynamicGive;
import com.leoman.dynamic.service.DynamicGiveService;
import com.leoman.user.dao.UserInfoDao;
import com.leoman.user.dao.YmRecordDao;
import com.leoman.user.entity.UserInfo;
import com.leoman.user.entity.YmRecord;
import com.leoman.user.service.YmRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Daisy on 2016/8/4.
 */
@Service
@Transactional(readOnly = true)
public class DynamicGiveServiceImpl extends GenericManagerImpl<DynamicGive,DynamicGiveDao> implements DynamicGiveService {

    @Autowired
    private DynamicGiveDao dynamicGiveDao;

    @Autowired
    private UserInfoDao userDao;

    @Autowired
    private YmRecordService ymRecordService;

    @Override
    @Transactional
    public void create(DynamicGive dynamicGive){
        UserInfo user = dynamicGive.getUser();
        if(user == null){
            GeneralExceptionHandler.handle("该用户不存在");
        }
        user = userDao.findOne(user.getId());
        if(dynamicGive.getYm() > user.getYm()){
            GeneralExceptionHandler.handle("该用户的益米数不够打赏益米数");
        }
        //保存打赏记录
        dynamicGiveDao.save(dynamicGive);

        //保存益米记录
        YmRecord ymRecord = new YmRecord();
        ymRecord.setType(0);
        ymRecord.setJoinId(user.getId());
        ymRecord.setYm(-dynamicGive.getYm());
        ymRecord.setContent("打赏朋友圈");
        ymRecordService.create(ymRecord);
    }

}
