package com.leoman.product.entity;

import com.leoman.common.entity.BaseEntity;

import javax.persistence.*;
import java.util.Set;

/**
 * 商品
 * Created by Daisy on 2016/7/28.
 */
@Entity
@Table(name = "t_product")
public class Product extends BaseEntity{

    @Column(name = "name")
    private String name;//商品名称

    @Column(name = "short_desc")
    private String shortDesc;//简短描述

    @Column(name = "cover_url")
    private String coverUrl;//封面路径

    @Column(name = "detail_image_url")
    private String detailImageUrl;//详情图片

    @Column(name = "type")
    private Integer type;//商品类型 0:实物 1:众筹 2:广告位

    @Column(name = "ym")
    private Integer ym;//所需益米

    @Column(name = "valid_start_date")
    private Long validStartDate;//开始有效期 type = 0

    @Column(name = "valid_end_date")
    private Long validEndDate;//结束有效期 type = 0

    @Column(name = "address")
    private String address;//兑换地址 type = 0

    @Column(name = "detail_desc")
    private String desc;//描述

    @Column(name = "nums")
    private Integer nums;//type = 1时所需人数

    @Column(name = "buy_num")
    private Integer buyNum;//type = 1时已经众筹人数

    @Column(name = "wishing_well")
    private Integer wishingWell;//是否为许愿池

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Set<ProductAds> ads;//规格

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getDetailImageUrl() {
        return detailImageUrl;
    }

    public void setDetailImageUrl(String detailImageUrl) {
        this.detailImageUrl = detailImageUrl;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getYm() {
        return ym;
    }

    public void setYm(Integer ym) {
        this.ym = ym;
    }

    public Long getValidStartDate() {
        return validStartDate;
    }

    public void setValidStartDate(Long validStartDate) {
        this.validStartDate = validStartDate;
    }

    public Long getValidEndDate() {
        return validEndDate;
    }

    public void setValidEndDate(Long validEndDate) {
        this.validEndDate = validEndDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public Integer getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(Integer buyNum) {
        this.buyNum = buyNum;
    }

    public Set<ProductAds> getAds() {
        return ads;
    }

    public void setAds(Set<ProductAds> ads) {
        this.ads = ads;
    }

    public Integer getWishingWell() {
        return wishingWell;
    }

    public void setWishingWell(Integer wishingWell) {
        this.wishingWell = wishingWell;
    }
}