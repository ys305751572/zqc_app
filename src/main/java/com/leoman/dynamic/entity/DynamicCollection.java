package com.leoman.dynamic.entity;

import com.leoman.common.entity.BaseEntity;
import com.leoman.user.entity.UserInfo;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 朋友圈收藏
 * Created by Daisy on 2016/7/22.
 */
@Entity
@Table(name = "t_dynamic_collection")
public class DynamicCollection extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "dynamic_id")
    private Dynamic dynamic;//动态

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserInfo user;//用户

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public Dynamic getDynamic() {
        return dynamic;
    }

    public void setDynamic(Dynamic dynamic) {
        this.dynamic = dynamic;
    }
}