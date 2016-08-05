package com.leoman.product.service.impl;

import com.leoman.common.service.impl.GenericManagerImpl;
import com.leoman.product.dao.ProductExchangeRecordDao;
import com.leoman.product.entity.ProductExchangeRecord;
import com.leoman.product.service.ProductExchangeRecordService;
import com.leoman.team.dao.TeamDao;
import com.leoman.team.entity.Team;
import com.leoman.user.dao.UserInfoDao;
import com.leoman.user.dao.YmRecordDao;
import com.leoman.user.entity.UserInfo;
import com.leoman.user.entity.YmRecord;
import com.leoman.user.service.YmRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Daisy on 2016/7/28.
 */
@Service
@Transactional(readOnly = true)
public class ProductExchangeRecordServiceImpl extends GenericManagerImpl<ProductExchangeRecord,ProductExchangeRecordDao> implements ProductExchangeRecordService {

    @Autowired
    private ProductExchangeRecordDao exchangeRecordDao;

    @Autowired
    private YmRecordService ymRecordService;

    @Autowired
    private TeamDao teamDao;

    @Override
    @Transactional
    public void create(ProductExchangeRecord per){
        //新增兑换记录
        exchangeRecordDao.save(per);

        //新增益米变化记录
        YmRecord ymRecord = new YmRecord();
        ymRecord.setType(per.getJoinType());
        ymRecord.setContent("兑换商品："+per.getProductName());
        ymRecord.setJoinId(per.getJoinId());
        ymRecord.setYm(-per.getYm());
        ymRecordService.create(ymRecord);
    }

    @Override
    public Page<UserInfo> findByProductId(Long productId, Integer currentPage, Integer pageSize){
        return exchangeRecordDao.findByProductId(productId, new PageRequest(currentPage-1, pageSize, Sort.Direction.DESC, "integral"));
    }

    @Override
    public Page<ProductExchangeRecord> findByJoinId(Integer joinType, Long joinId, Integer currentPage, Integer pageSize){
        return exchangeRecordDao.findByJoinId(joinType, joinId, new PageRequest(currentPage-1, pageSize, Sort.Direction.DESC, "id"));
    }

    @Override
    public Page<ProductExchangeRecord> findCodes(Long userId, Integer currentPage, Integer pageSize){
        Team team = teamDao.findByUserId(userId);
        Long teamId = team==null?0:team.getId();
        return exchangeRecordDao.findCodes(userId,teamId, new PageRequest(currentPage-1, pageSize, Sort.Direction.DESC, "id"));
    }

}
