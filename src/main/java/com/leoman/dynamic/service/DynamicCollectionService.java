package com.leoman.dynamic.service;


import com.leoman.common.service.GenericManager;
import com.leoman.dynamic.entity.Dynamic;
import com.leoman.dynamic.entity.DynamicCollection;
import com.leoman.user.entity.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Daisy on 2016/7/22.
 */
public interface DynamicCollectionService extends GenericManager<DynamicCollection> {

    public Page<Dynamic> findByDyUserId(Long userId, Integer pageNum, Integer pageSize);

    public void operate(String oper, Long dynamicId, Long userId);

    public DynamicCollection findByDynamicIdAndUserId(Long dynamicId, Long userId);

}
