
package com.leoman.user.dao;


import com.leoman.common.dao.IBaseJpaRepository;
import com.leoman.user.entity.IntegralRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Daisy on 2016/8/3.
 */
public interface IntegralRecordDao extends IBaseJpaRepository<IntegralRecord> {

    @Query("select a from IntegralRecord a where a.type = ?1 and a.joinId = ?2")
    public Page<IntegralRecord> findByJoinId(Integer type, Long joinId, Pageable pageable);
}
