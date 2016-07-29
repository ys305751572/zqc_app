package com.leoman.user.entity;

import com.leoman.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 用户或团队益米记录
 * Created by Daisy on 2016/7/29.
 */
@Entity
@Table(name = "t_ym_record")
public class YmRecord extends BaseEntity{

    @Column(name = "join_id")
    private Long joinId;//用户名

    @Column(name = "content")
    private String content;//内容

    @Column(name = "type")
    private Integer type;//类型 0:个人 1:团队

    @Column(name = "ym")
    private Integer ym;//增减益米数

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

    public Integer getYm() {
        return ym;
    }

    public void setYm(Integer ym) {
        this.ym = ym;
    }
}