package com.leoman.product.dao;


import com.leoman.common.dao.IBaseJpaRepository;
import com.leoman.product.entity.Product;
import com.leoman.task.entity.Task;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Daisy on 2016/7/28.
 */
public interface ProductDao extends IBaseJpaRepository<Product> {

    @Query("select a from Product a where a.wishingWell = 1")
    public Product findWishWell();

}
