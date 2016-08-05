package com.leoman.dynamic.service;


import com.leoman.common.service.GenericManager;
import com.leoman.dynamic.entity.DynamicComment;
import com.leoman.dynamic.entity.DynamicGive;

import java.util.List;

/**
 * Created by Daisy on 2016/8/4.
 */
public interface DynamicGiveService extends GenericManager<DynamicGive> {

    public void create(DynamicGive dynamicGive);
}
