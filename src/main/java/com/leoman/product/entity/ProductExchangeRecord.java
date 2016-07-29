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

    @Column(name = "product_name")
    private String product_name;//商品名称

    @Column(name = "product_type")
    private Integer product_type;//商品类型0:实物 1:众筹 2:广告位

    @Column(name = "product_type_name")
    private String product_type_name;//商品类型名称

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

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Integer getProduct_type() {
        return product_type;
    }

    public void setProduct_type(Integer product_type) {
        this.product_type = product_type;
    }

    public String getProduct_type_name() {
        return product_type_name;
    }

    public void setProduct_type_name(String product_type_name) {
        this.product_type_name = product_type_name;
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
}