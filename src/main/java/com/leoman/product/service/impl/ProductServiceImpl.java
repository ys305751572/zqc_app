package com.leoman.product.service.impl;

import com.leoman.common.service.impl.GenericManagerImpl;
import com.leoman.product.dao.ProductDao;
import com.leoman.product.entity.Product;
import com.leoman.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * Created by Daisy on 2016/7/25.
 */
@Service
public class ProductServiceImpl extends GenericManagerImpl<Product,ProductDao> implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Page<Product> findAll(Integer currentPage, Integer pageSize){
        return productDao.findAll(new PageRequest(currentPage-1, pageSize, Sort.Direction.DESC, "id"));
    }

}
