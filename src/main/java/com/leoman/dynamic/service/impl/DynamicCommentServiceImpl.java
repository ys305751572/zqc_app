package com.leoman.dynamic.service.impl;

import com.leoman.common.service.impl.GenericManagerImpl;
import com.leoman.dynamic.dao.DynamicCommentDao;
import com.leoman.dynamic.entity.DynamicComment;
import com.leoman.dynamic.service.DynamicCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Daisy on 2016/7/22.
 */
@Service
@Transactional(readOnly = true)
public class DynamicCommentServiceImpl extends GenericManagerImpl<DynamicComment,DynamicCommentDao> implements DynamicCommentService {

    @Autowired
    private DynamicCommentDao dynamicCommentDao;

    @Override
    public List<DynamicComment> findByDynamicId(Long dynamicId){
        return dynamicCommentDao.findByDynamicId(dynamicId);
    }

    @Override
    @Transactional
    public DynamicComment create(DynamicComment dynamicComment){
        return dynamicCommentDao.save(dynamicComment);
    }

}
