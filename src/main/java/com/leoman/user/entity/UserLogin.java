package com.leoman.user.entity;

import com.leoman.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 用户登录
 * Created by Daisy on 2016/7/14.
 */
@Entity
@Table(name = "t_user_login")
public class UserLogin extends BaseEntity{

    @Column(name = "username")
    private String username;//用户名

    @Column(name = "password")
    private String password;//密码

    @Column(name = "last_login_date")
    private String last_login_date;//最后登录时间

    @Column(name = "ip_address")
    private String ip_address;//ip地址

    public UserLogin(){};

    public UserLogin(String username) {
        this.username = username;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLast_login_date() {
        return last_login_date;
    }

    public void setLast_login_date(String last_login_date) {
        this.last_login_date = last_login_date;
    }
}