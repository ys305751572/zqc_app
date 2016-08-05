package com.leoman.product.dao;


import com.leoman.common.dao.IBaseJpaRepository;
import com.leoman.product.entity.Product;
import com.leoman.product.entity.ProductExchangeRecord;
import com.leoman.user.entity.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Daisy on 2016/7/29.
 */
public interface ProductExchangeRecordDao extends IBaseJpaRepository<ProductExchangeRecord> {

    @Query("select b from UserInfo b where b.id in ( select a.joinId from ProductExchangeRecord a where a.productId = ?1 )")
    public Page<UserInfo> findByProductId(Long productId, Pageable pageable);

    @Query("select a from ProductExchangeRecord a where a.joinType = ?1 and a.joinId = ?2 ")
    public Page<ProductExchangeRecord> findByJoinId(Integer joinType, Long joinId, Pageable pageable);

    @Query("select a from ProductExchangeRecord a where a.productType = 0 and ( (a.joinType = 0 and a.joinId = ?1) or (a.joinType = 1 and a.joinId = ?2) )")
    public Page<ProductExchangeRecord> findCodes(Long userId, Long teamId, Pageable pageable);

}
