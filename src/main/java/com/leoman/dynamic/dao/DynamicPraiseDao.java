package com.leoman.dynamic.dao;


import com.leoman.common.dao.IBaseJpaRepository;
import com.leoman.dynamic.entity.DynamicPraise;
import com.leoman.user.entity.UserInfo;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Daisy on 2016/7/21.
 */
public interface DynamicPraiseDao extends IBaseJpaRepository<DynamicPraise> {

    @Query("select a.user from DynamicPraise a where a.dynamic.id =?1")
    public List<UserInfo> findByDynamicId(Long dynamicId);

    @Query("select a from DynamicPraise a where a.dynamic.id = ?1 and a.user.id = ?2")
    public DynamicPraise findByDynamicIdAndUserId(Long dynamicId, Long userId);

}
