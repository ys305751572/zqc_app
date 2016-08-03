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
@Table(name = "t_product_exchange_record")
public class ProductExchangeRecord extends BaseEntity{

    @Column(name = "join_type")
    private Integer joinType;//类型：0-个人，1-团队

    @Column(name = "join_id")
    private Long joinId;//兑换用户ID或团队id

    @Column(name = "name")
    private String name;//手机/团体名称

    @Column(name = "nickname")
    private String nickname;//昵称

    @Column(name = "product_id")
    private Long productId;//商品id

    @Column(name = "product_name")
    private String productName;//商品名称

    @Column(name = "product_type")
    private Integer productType;//商品类型0:实物 1:众筹 2:广告位

    @Column(name = "product_type_name")
    private String productTypeName;//商品类型名称

    @Column(name = "integral")
    private Integer integral;//兑换积分

    @Column(name = "status")
    private Integer status;//状态0:未处理 1:成功 2:失败 3:过期

    @Column(name = "days")
    private Integer days;//周期 这里保存天数

    @Column(name = "ym")
    private Integer ym;//所需益米

    @Column(name = "code")
    private String code;//兑换码

    @Column(name = "valid_start_date")
    private Long validStartDate;//开始有效期 type = 0

    @Column(name = "valid_end_date")
    private Long validEndDate;//结束有效期 type = 0

    @Column(name = "address")
    private String address;//兑换地址 type = 0

    @Column(name = "is_exchange")
    private Integer isExchange;//是否已兑换（0-否，1-是）

    public Integer getJoinType() {
        return joinType;
    }

    public void setJoinType(Integer joinType) {
        this.joinType = joinType;
    }

    public Long getJoinId() {
        return joinId;
    }

    public void setJoinId(Long joinId) {
        this.joinId = joinId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getIsExchange() {
        return isExchange;
    }

    public void setIsExchange(Integer isExchange) {
        this.isExchange = isExchange;
    }
}