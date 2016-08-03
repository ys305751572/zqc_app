package com.leoman.user.service;


import com.leoman.common.service.GenericManager;
import com.leoman.user.entity.IntegralRecord;
import com.leoman.user.entity.YmRecord;
import org.springframework.data.domain.Page;

/**
 * Created by Daisy on 2016/8/3.
 */
public interface IntegralRecordService extends GenericManager<IntegralRecord> {

    public void create(IntegralRecord integralRecord);

    public Page<IntegralRecord> findByJoinId(Integer type, Long joinId, Integer currentPage, Integer pageSize);

}
