package com.leoman.user.entity;

import com.leoman.common.annotion.Exclude;
import com.leoman.common.entity.BaseEntity;

import javax.persistence.*;

/**
 * 用户基本信息
 * Created by Daisy on 2016/7/14.
 */
@Entity
@Table(name = "t_user_info")
public class UserInfo extends BaseEntity{

    @Column(name = "mobile")
    private String mobile;//手机号

    @Column(name = "nickname")
    private String nickname;//昵称

    @Column(name = "gender")
    private Integer gender;//性别 男:0 女:1

    @Column(name = "avater")
    private String avater;//头像

    @Column(name = "status")
    private String status;//状态 0:正常 1:冻结

    @Column(name = "level")
    private String level;//会员等级

    @Column(name = "integral")
    private String integral;//积分

    @Column(name = "ym")
    private String ym;//益米

    @Column(name = "sign")
    private String sign;//index0 : 今日是否签到 0:未签到 1:已签到 index1:连续签到次数 index2:总共签到次数

    @Column(name = "IDCard")
    private String IDCard;//身份证号

    @Exclude
    @ManyToOne
    @JoinColumn(name = "login_id")
    private UserLogin userLogin;//用户登录

    public UserInfo(){};

    public UserInfo(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getAvater() {
        return avater;
    }

    public void setAvater(String avater) {
        this.avater = avater;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getIntegral() {
        return integral;
    }

    public void setIntegral(String integral) {
        this.integral = integral;
    }

    public String getYm() {
        return ym;
    }

    public void setYm(String ym) {
        this.ym = ym;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getIDCard() {
        return IDCard;
    }

    public void setIDCard(String IDCard) {
        this.IDCard = IDCard;
    }

    public UserLogin getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(UserLogin userLogin) {
        this.userLogin = userLogin;
    }


}