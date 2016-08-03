package com.leoman.team.entity;

import com.leoman.common.entity.BaseEntity;
import com.leoman.task.entity.Task;
import com.leoman.task.entity.TaskJoinImage;
import com.leoman.user.entity.UserInfo;

import javax.persistence.*;
import java.util.Set;

/**
 * 团队表
 * Created by Daisy on 2016/7/27.
 */
@Entity
@Table(name = "t_team")
public class Team extends BaseEntity{

//    @ManyToOne
//    @JoinColumn(name = "user_id")
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "name")
    private String name;

    @Column(name = "slogan")
    private String slogan;

    @Column(name = "status")
    private Integer status;

    @Column(name = "integral")
    private Integer integral;

    @Column(name = "ym")
    private Integer ym;

    @Column(name = "cover_url")
    private String coverUrl;

    @Column(name = "nums")
    private Integer nums;

    @Column(name = "level")
    private Integer level;

    public Team(){}

    public Team(Long id) {
        this.setId(id);
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}