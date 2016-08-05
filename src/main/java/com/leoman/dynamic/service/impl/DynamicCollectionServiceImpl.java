package com.leoman.dynamic.service.impl;

import com.leoman.common.exception.GeneralExceptionHandler;
import com.leoman.common.service.impl.GenericManagerImpl;
import com.leoman.dynamic.dao.DynamicCollectionDao;
import com.leoman.dynamic.entity.Dynamic;
import com.leoman.dynamic.entity.DynamicCollection;
import com.leoman.dynamic.service.DynamicCollectionService;
import com.leoman.user.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Daisy on 2016/7/22.
 */
@Service
@Transactional
public class DynamicCollectionServiceImpl extends GenericManagerImpl<DynamicCollection,DynamicCollectionDao> implements DynamicCollectionService {

    @Autowired
    private DynamicCollectionDao dynamicCollectionDao;

    /**
     * 收藏和取消收藏
     * @param oper
     * @param dynamicId
     * @param userId
     */
    @Override
    public void operate(String oper, Long dynamicId, Long userId){
        if("add".equals(oper)){
            DynamicCollection dynamicCollection = dynamicCollectionDao.findByDynamicIdAndUserId(dynamicId, userId);
            if(dynamicCollection != null){
                GeneralExceptionHandler.handle("dynamicId = "+dynamicId+", userId = "+userId+" 已收藏");
            }
            DynamicCollection dp = new DynamicCollection();
            dp.setDynamic(new Dynamic(dynamicId));
            dp.setUser(new UserInfo(userId));
            dynamicCollectionDao.save(dp);
        }else if("cancel".equals(oper)){
            DynamicCollection dynamicCollection = dynamicCollectionDao.findByDynamicIdAndUserId(dynamicId, userId);
            if(dynamicCollection == null){
                GeneralExceptionHandler.handle("未找到该数据");
            }
            dynamicCollectionDao.delete(dynamicCollection);
        }else{
            GeneralExceptionHandler.handle("oper参数值不符合要求");
        }
    }

    @Override
    public DynamicCollection findByDynamicIdAndUserId(Long dynamicId, Long userId) {
        return dynamicCollectionDao.findByDynamicIdAndUserId(dynamicId,userId);
    }

    @Override
    public Page<Dynamic> findByDyUserId(Long userId, Integer pageNum, Integer pageSize){
        return dynamicCollectionDao.findByDyUserId(userId, new PageRequest(pageNum - 1, pageSize, Sort.Direction.DESC, "id"));
    }
}
