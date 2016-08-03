package com.leoman.user.dao;


import com.leoman.common.dao.IBaseJpaRepository;
import com.leoman.user.entity.UserLogin;
import com.leoman.user.entity.YmRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Daisy on 2016/7/29.
 */
public interface YmRecordDao extends IBaseJpaRepository<YmRecord> {

    @Query("select a from YmRecord a where a.type = ?1 and a.joinId = ?2")
    public Page<YmRecord> findByJoinId(Integer type, Long joinId, Pageable pageable);
}
