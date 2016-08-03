package com.leoman.user.entity;

import com.leoman.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 用户证书
 * Created by Daisy on 2016/8/1.
 */
@Entity
@Table(name = "t_user_info_ca")
public class UserInfoCa extends BaseEntity{

    @Column(name = "user_id")
    private Long userId;//用户名

    @Column(name = "ca_url")
    private String caUrl;//证书路径

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCaUrl() {
        return caUrl;
    }

    public void setCaUrl(String caUrl) {
        this.caUrl = caUrl;
    }
}