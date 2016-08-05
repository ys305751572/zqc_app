package com.leoman.user.entity;

import com.leoman.common.annotion.Exclude;
import com.leoman.common.entity.BaseEntity;
import com.leoman.team.entity.Team;
import com.leoman.team.entity.TeamUser;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

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
    private Integer status;//状态 0:正常 1:冻结

    @Column(name = "level")
    private Integer level;//会员等级

    @Column(name = "integral")
    private Integer integral;//积分

    @Column(name = "ym")
    private Integer ym;//益米

    @Column(name = "sign")
    private String sign;//index0 : 今日是否签到 0:未签到 1:已签到 index1:连续签到次数 index2:总共签到次数

    @Column(name = "id_card")
    private String IDCard;//身份证号

    @Column(name = "last_sign_date")
    private Date lastSignDate;//身份证号

    @Exclude
    @ManyToOne
    @JoinColumn(name = "login_id")
    private UserLogin userLogin;//用户登录

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Set<Team> teams;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Set<TeamUser> teamUsers;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Set<UserInfoCa> userCas;

    public UserInfo(){}

    public UserInfo(Long id) {
        super.setId(id);
    }

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public Integer getYm() {
        return ym;
    }

    public void setYm(Integer ym) {
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

    public Set<TeamUser> getTeamUsers() {
        return teamUsers;
    }

    public void setTeamUsers(Set<TeamUser> teamUsers) {
        this.teamUsers = teamUsers;
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    public Set<UserInfoCa> getUserCas() {
        return userCas;
    }

    public void setUserCas(Set<UserInfoCa> userCas) {
        this.userCas = userCas;
    }

    public Date getLastSignDate() {
        return lastSignDate;
    }

    public void setLastSignDate(Date lastSignDate) {
        this.lastSignDate = lastSignDate;
    }
}