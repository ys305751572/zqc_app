package com.leoman.product.service;


import com.leoman.common.service.GenericManager;
import com.leoman.product.entity.Product;
import com.leoman.task.entity.Task;
import org.springframework.data.domain.Page;

/**
 * Created by Daisy on 2016/7/25.
 */
public interface ProductService extends GenericManager<Product> {

    public Page<Product> findAll(Integer currentPage, Integer pageSize);

    public void exchange(Integer joinType, Long productId, Long joinId, Integer days);

    public Product findWishWell();

}
