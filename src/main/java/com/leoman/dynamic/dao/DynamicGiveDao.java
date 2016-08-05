package com.leoman.dynamic.dao;


import com.leoman.common.dao.IBaseJpaRepository;
import com.leoman.dynamic.entity.DynamicComment;
import com.leoman.dynamic.entity.DynamicGive;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Daisy on 2016/7/22.
 */
public interface DynamicGiveDao extends IBaseJpaRepository<DynamicGive> {

}
