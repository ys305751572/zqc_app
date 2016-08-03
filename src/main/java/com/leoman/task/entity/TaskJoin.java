package com.leoman.task.entity;

import com.leoman.common.entity.BaseEntity;

import javax.persistence.*;
import java.util.Set;

/**
 * 任务参加表
 * Created by Daisy on 2016/7/26.
 */
@Entity
@Table(name = "t_task_join")
public class TaskJoin extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @Column(name = "join_id")
    private Long joinId;

    @Column(name = "status")
    private Integer status;//0-进行中，1-已完成，2-未完成

    @Column(name = "is_allot")
    private Integer isAllot;//是否分配（1-已分配, 0-未分配）

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "task_join_id")
    private Set<TaskJoinImage> images;

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Long getJoinId() {
        return joinId;
    }

    public void setJoinId(Long joinId) {
        this.joinId = joinId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Set<TaskJoinImage> getImages() {
        return images;
    }

    public void setImages(Set<TaskJoinImage> images) {
        this.images = images;
    }

    public Integer getIsAllot() {
        return isAllot;
    }

    public void setIsAllot(Integer isAllot) {
        this.isAllot = isAllot;
    }
}