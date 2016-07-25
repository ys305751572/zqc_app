package com.leoman.dynamic.dao;


import com.leoman.common.dao.IBaseJpaRepository;
import com.leoman.dynamic.entity.Dynamic;
import com.leoman.dynamic.entity.DynamicComment;
import com.leoman.user.entity.UserInfo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Daisy on 2016/7/22.
 */
public interface DynamicCommentDao extends IBaseJpaRepository<DynamicComment> {

    @Query("select a from DynamicComment a where a.dynamic.id = ?1 order by a.id desc ")
    public List<DynamicComment> findByDynamicId(Long dynamicId);

}
