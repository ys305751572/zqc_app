package com.leoman.task.entity;

import com.leoman.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 任务参加图片表
 * Created by Daisy on 2016/7/26.
 */
@Entity
@Table(name = "t_task_join_image")
public class TaskJoinImage extends BaseEntity{

    @Column(name = "task_join_id")
    private Long taskJoinId;

    @Column(name = "image_url")
    private String imageUrl;

    public Long getTaskJoinId() {
        return taskJoinId;
    }

    public void setTaskJoinId(Long taskJoinId) {
        this.taskJoinId = taskJoinId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}