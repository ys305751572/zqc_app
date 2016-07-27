package com.leoman.task.entity;

import com.leoman.common.entity.BaseEntity;
import com.leoman.dynamic.entity.DynamicImage;
import com.leoman.user.entity.UserInfo;

import javax.persistence.*;
import java.util.Set;

/**
 * 任务
 * Created by Daisy on 2016/7/25.
 */
@Entity
@Table(name = "t_task")
public class Task extends BaseEntity{

    @Column(name = "type")
    private Integer type;//类型：1-益起来任务，2-脑洞开了没任务

    @Column(name = "name")
    private String name;//任务名称

    @Column(name = "cover_url")
    private String coverUrl;//封面路径

    @Column(name = "join_type")
    private Integer joinType;//活动类型 0:个人 1:团队（新改）

    @Column(name = "start_date")
    private Long startDate;//任务开始时间

    @Column(name = "end_date")
    private Long endDate;//任务结束时间

    @Column(name = "address")
    private String address;//活动地点

    @Column(name = "organizers")
    private String organizers;//主办方

    @Column(name = "nums")
    private Integer nums;//所需人数

    @Column(name = "join_num")
    private Integer joinNum;//已报名人数

    @Column(name = "reward_ym")
    private Integer rewardYm;//奖励益米

    @Column(name = "reward_integral")
    private Integer rewardIntegral;//奖励积分

    @Column(name = "detail")
    private String detail;//详情

    @Transient
    private Integer joinStatus;//参加状态

    public Task(){}

    public Task(Long id) {
        this.setId(id);
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public Integer getJoinType() {
        return joinType;
    }

    public void setJoinType(Integer joinType) {
        this.joinType = joinType;
    }

    public Long getStartDate() {
        return startDate;
    }

    public void setStartDate(Long startDate) {
        this.startDate = startDate;
    }

    public Long getEndDate() {
        return endDate;
    }

    public void setEndDate(Long endDate) {
        this.endDate = endDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOrganizers() {
        return organizers;
    }

    public void setOrganizers(String organizers) {
        this.organizers = organizers;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public Integer getJoinNum() {
        return joinNum;
    }

    public void setJoinNum(Integer joinNum) {
        this.joinNum = joinNum;
    }

    public Integer getRewardYm() {
        return rewardYm;
    }

    public void setRewardYm(Integer rewardYm) {
        this.rewardYm = rewardYm;
    }

    public Integer getRewardIntegral() {
        return rewardIntegral;
    }

    public void setRewardIntegral(Integer rewardIntegral) {
        this.rewardIntegral = rewardIntegral;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getJoinStatus() {
        return joinStatus;
    }

    public void setJoinStatus(Integer joinStatus) {
        this.joinStatus = joinStatus;
    }
}