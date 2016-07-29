package com.leoman.product.service.impl;

import com.leoman.common.service.impl.GenericManagerImpl;
import com.leoman.product.dao.ProductExchangeRecordDao;
import com.leoman.product.entity.ProductExchangeRecord;
import com.leoman.product.service.ProductExchangeRecordService;
import com.leoman.user.dao.YmRecordDao;
import com.leoman.user.entity.YmRecord;
import org.springframework.beans.factory.annotation.Autowired;
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
    private YmRecordDao ymRecordDao;

    @Override
    @Transactional
    public void create(ProductExchangeRecord per){
        //新增兑换记录
        exchangeRecordDao.save(per);
        //新增益米变化记录
        YmRecord ymRecord = new YmRecord();
        ymRecord.setType(per.getJoinType());
        ymRecord.setContent("兑换商品");
        ymRecord.setJoinId(per.getJoinId());
        ymRecord.setYm(-per.getYm());
        ymRecordDao.save(ymRecord);
    }


}
