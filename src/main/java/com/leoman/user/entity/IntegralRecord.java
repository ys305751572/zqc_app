package com.leoman.user.entity;

import com.leoman.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 用户或团队积分记录
 * Created by Daisy on 2016/8/3.
 */
@Entity
@Table(name = "t_integral_record")
public class IntegralRecord extends BaseEntity{

    @Column(name = "join_id")
    private Long joinId;//用户名

    @Column(name = "content")
    private String content;//内容

    @Column(name = "type")
    private Integer type;//类型 0:个人 1:团队

    @Column(name = "integral")
    private Integer integral;//增减积分数

    public Long getJoinId() {
        return joinId;
    }

    public void setJoinId(Long joinId) {
        this.joinId = joinId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }
}