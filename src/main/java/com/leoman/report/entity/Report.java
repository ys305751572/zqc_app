package com.leoman.report.entity;

import com.leoman.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 意见反馈
 * Created by Daisy on 2016/8/5.
 */
@Entity
@Table(name = "t_report")
public class Report extends BaseEntity{

    @Column(name = "user_id")
    private Long userId;//用户

    @Column(name = "content")
    private String content;//内容

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}