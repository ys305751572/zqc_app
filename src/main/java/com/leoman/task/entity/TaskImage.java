package com.leoman.task.entity;

import com.leoman.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 任务图片
 * Created by Daisy on 2016/7/25.
 */
@Entity
@Table(name = "t_task_upload_image")
public class TaskImage extends BaseEntity{

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