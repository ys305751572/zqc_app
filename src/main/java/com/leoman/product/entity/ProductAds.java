package com.leoman.product.entity;

import com.leoman.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 商品
 * Created by Daisy on 2016/7/29.
 */
@Entity
@Table(name = "t_product_ads")
public class ProductAds extends BaseEntity{

    @Column(name = "product_id")
    private Long productId;//商品id

    @Column(name = "days")
    private Integer days;//周期

    @Column(name = "ym")
    private Integer ym;//所需益米

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Integer getYm() {
        return ym;
    }

    public void setYm(Integer ym) {
        this.ym = ym;
    }
}