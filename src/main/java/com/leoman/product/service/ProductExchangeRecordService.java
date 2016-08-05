package com.leoman.product.service;


import com.leoman.common.service.GenericManager;
import com.leoman.product.entity.Product;
import com.leoman.product.entity.ProductExchangeRecord;
import com.leoman.user.entity.UserInfo;
import org.springframework.data.domain.Page;

/**
 * Created by Daisy on 2016/7/29.
 */
public interface ProductExchangeRecordService extends GenericManager<ProductExchangeRecord> {

    public void create(ProductExchangeRecord per);

    public Page<UserInfo> findByProductId(Long productId, Integer currentPage, Integer pageSize);

    public Page<ProductExchangeRecord> findByJoinId(Integer joinType, Long joinId, Integer currentPage, Integer pageSize);

    public Page<ProductExchangeRecord> findCodes(Long userId, Integer currentPage, Integer pageSize);
}
