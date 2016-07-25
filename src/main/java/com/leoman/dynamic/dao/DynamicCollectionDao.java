package com.leoman.dynamic.dao;


import com.leoman.common.dao.IBaseJpaRepository;
import com.leoman.dynamic.entity.Dynamic;
import com.leoman.dynamic.entity.DynamicCollection;
import com.leoman.user.entity.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Daisy on 2016/7/22.
 */
public interface DynamicCollectionDao extends IBaseJpaRepository<DynamicCollection> {

    @Query("select a.dynamic from DynamicCollection a where a.user.id =?1")
    public Page<Dynamic> findByDyUserId(Long userId, Pageable pageable);

    @Query("select a from DynamicCollection a where a.dynamic.id = ?1 and a.user.id = ?2")
    public DynamicCollection findByDynamicIdAndUserId(Long dynamicId, Long userId);

}
