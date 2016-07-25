package com.leoman.dynamic.service;


import com.leoman.common.service.GenericManager;
import com.leoman.dynamic.entity.DynamicPraise;
import com.leoman.user.entity.UserInfo;

import java.util.List;

/**
 * Created by Daisy on 2016/7/21.
 */
public interface DynamicPraiseService extends GenericManager<DynamicPraise> {

    public List<UserInfo> findByDynamicId(Long dynamicId);

    public void operate(String oper, Long dynamicId, Long userId);

    public DynamicPraise findByDynamicIdAndUserId(Long dynamicId, Long userId);

}
