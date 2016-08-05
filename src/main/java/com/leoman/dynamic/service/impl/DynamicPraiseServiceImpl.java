package com.leoman.dynamic.service.impl;

import com.leoman.common.exception.GeneralExceptionHandler;
import com.leoman.common.service.impl.GenericManagerImpl;
import com.leoman.dynamic.dao.DynamicPraiseDao;
import com.leoman.dynamic.entity.Dynamic;
import com.leoman.dynamic.entity.DynamicPraise;
import com.leoman.dynamic.service.DynamicPraiseService;
import com.leoman.enums.ErrorType;
import com.leoman.user.entity.UserInfo;
import com.leoman.utils.Result;
import com.leoman.utils.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Daisy on 2016/7/21.
 */
@Service
@Transactional
public class DynamicPraiseServiceImpl extends GenericManagerImpl<DynamicPraise,DynamicPraiseDao> implements DynamicPraiseService {

    @Autowired
    private DynamicPraiseDao dynamicPraiseDao;

    /**
     * 点赞和取消点赞
     * @param oper
     * @param dynamicId
     * @param userId
     */
    @Override
    public void operate(String oper, Long dynamicId, Long userId){
        if("add".equals(oper)){
            DynamicPraise dynamicPraise = dynamicPraiseDao.findByDynamicIdAndUserId(dynamicId, userId);
            if(dynamicPraise != null){
                GeneralExceptionHandler.handle("dynamicId = "+dynamicId+", userId = "+userId+" 已点赞");
            }
            DynamicPraise dp = new DynamicPraise();
            dp.setDynamic(new Dynamic(dynamicId));
            dp.setUser(new UserInfo(userId));
            dynamicPraiseDao.save(dp);
        }else if("cancel".equals(oper)){
            DynamicPraise dynamicPraise = dynamicPraiseDao.findByDynamicIdAndUserId(dynamicId, userId);
            if(dynamicPraise == null){
                GeneralExceptionHandler.handle("无法找到数据");
            }
            dynamicPraiseDao.delete(dynamicPraise);
        }else{
            GeneralExceptionHandler.handle("oper参数值不符合要求");
        }
    }

    @Override
    public DynamicPraise findByDynamicIdAndUserId(Long dynamicId, Long userId) {
        return dynamicPraiseDao.findByDynamicIdAndUserId(dynamicId,userId);
    }

    @Override
    public List<UserInfo> findByDynamicId(Long dynamicId) {
        return dynamicPraiseDao.findByDynamicId(dynamicId);
    }


}
