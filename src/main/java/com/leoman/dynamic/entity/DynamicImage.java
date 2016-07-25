package com.leoman.dynamic.entity;

import com.leoman.common.entity.BaseEntity;

import javax.persistence.*;

/**
 * 朋友圈动态图片
 * Created by Daisy on 2016/7/21.
 */
@Entity
@Table(name = "t_dynamic_image")
public class DynamicImage extends BaseEntity{

    @Column(name = "image_url")
    private String imageUrl;//图片路径

    @Column(name = "dynamic_id")
    private Long dynamicId;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getDynamicId() {
        return dynamicId;
    }

    public void setDynamicId(Long dynamicId) {
        this.dynamicId = dynamicId;
    }
}