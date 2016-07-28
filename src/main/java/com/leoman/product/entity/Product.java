package com.leoman.product.entity;

import com.leoman.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

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
    private String type;//商品类型 0:实物 1:众筹 2:广告位

    @Column(name = "ym")
    private String ym;//所需益米

    @Column(name = "valid_start_date")
    private String validStartDate;//开始有效期 type = 0

    @Column(name = "valid_end_date")
    private String validEndDate;//结束有效期 type = 0

    @Column(name = "address")
    private String address;//兑换地址 type = 0

    @Column(name = "desc")
    private String desc;//描述

    @Column(name = "nums")
    private String nums;//type = 1时所需人数

    @Column(name = "buy_num")
    private String buyNum;//type = 1时已经众筹人数

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getYm() {
        return ym;
    }

    public void setYm(String ym) {
        this.ym = ym;
    }

    public String getValidStartDate() {
        return validStartDate;
    }

    public void setValidStartDate(String validStartDate) {
        this.validStartDate = validStartDate;
    }

    public String getValidEndDate() {
        return validEndDate;
    }

    public void setValidEndDate(String validEndDate) {
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

    public String getNums() {
        return nums;
    }

    public void setNums(String nums) {
        this.nums = nums;
    }

    public String getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(String buyNum) {
        this.buyNum = buyNum;
    }

    public String getDetailImageUrl() {
        return detailImageUrl;
    }

    public void setDetailImageUrl(String detailImageUrl) {
        this.detailImageUrl = detailImageUrl;
    }
}