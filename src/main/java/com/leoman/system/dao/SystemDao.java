package com.leoman.system.dao;


import com.leoman.common.dao.IBaseJpaRepository;
import com.leoman.product.entity.Product;
import com.leoman.system.entity.System;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Daisy on 2016/7/28.
 */
public interface SystemDao extends IBaseJpaRepository<System> {

    @Query("select a from System a where a.type = ?1")
    public System findByType(Integer type);

}
