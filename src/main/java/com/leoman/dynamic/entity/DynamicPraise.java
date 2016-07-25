package com.leoman.dynamic.entity;

import com.leoman.common.entity.BaseEntity;
import com.leoman.user.entity.UserInfo;

import javax.persistence.*;

/**
 * 朋友圈点赞
 * Created by Daisy on 2016/7/21.
 */
@Entity
@Table(name = "t_dynamic_praise")
public class DynamicPraise extends BaseEntity{

    @JoinColumn(name = "user_id")
    @ManyToOne
    private UserInfo user;//用户

    @JoinColumn(name = "dynamic_id")
    @ManyToOne
    private Dynamic dynamic;//动态

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