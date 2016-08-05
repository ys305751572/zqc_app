package com.leoman.banner.entity;

import com.leoman.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * banner
 * Created by Daisy on 2016/8/4.
 */
@Entity
@Table(name = "t_banner")
public class Banner extends BaseEntity{

    @Column(name = "image_url")
    private String imageUrl;//bannar图路径

    @Column(name = "start_date")
    private Long startDate;//开始时间

    @Column(name = "end_date")
    private Long endDate;//开始时间

    @Column(name = "position")
    private Integer position;//位置 0:首页 1:商城

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }
}