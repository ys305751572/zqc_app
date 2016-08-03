package com.leoman.user.service;


import com.leoman.common.service.GenericManager;
import com.leoman.user.entity.UserLogin;
import com.leoman.user.entity.YmRecord;
import org.springframework.data.domain.Page;

/**
 * Created by Daisy on 2016/8/2.
 */
public interface YmRecordService extends GenericManager<YmRecord> {

    public void create(YmRecord ymRecord);

    public Page<YmRecord> findByJoinId(Integer type, Long joinId, Integer currentPage, Integer pageSize);

}
