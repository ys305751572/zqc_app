package com.leoman.dynamic.entity;

import com.leoman.common.annotion.Exclude;
import com.leoman.common.entity.BaseEntity;
import com.leoman.user.entity.UserInfo;

import javax.persistence.*;

/**
 * 朋友圈动态打赏
 * Created by Daisy on 2016/8/4.
 */
@Entity
@Table(name = "t_dynamic_give")
public class DynamicGive extends BaseEntity{

    @Exclude
    @ManyToOne
    @JoinColumn(name = "dynamic_id")
    private Dynamic dynamic;//动态

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserInfo user;//评论用户

    @Column(name = "ym")
    private Integer ym;//打赏益米数

    public Dynamic getDynamic() {
        return dynamic;
    }

    public void setDynamic(Dynamic dynamic) {
        this.dynamic = dynamic;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public Integer getYm() {
        return ym;
    }

    public void setYm(Integer ym) {
        this.ym = ym;
    }
}