package com.leoman.dynamic.entity;

import com.leoman.common.entity.BaseEntity;
import com.leoman.user.entity.UserInfo;

import javax.persistence.*;
import java.util.Set;

/**
 * 朋友圈动态
 * Created by Daisy on 2016/7/21.
 */
@Entity
@Table(name = "t_dynamic")
public class Dynamic extends BaseEntity{

    @Column(name = "title")
    private String title;//标题

    @Column(name = "content")
    private String content;//内容

    @Column(name = "vedio_url")
    private String vedioUrl;//音频路径

    @Column(name = "is_top")
    private Integer isTop;//是否置顶：1-是，0-否

    @Column(name = "status")
    private Integer status;//状态：0-正常，1-删除

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserInfo user;//用户

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "dynamic_id")
    private Set<DynamicImage> images;//动态图片

    @Transient
    private Boolean isCollect;//是否收藏

    @Transient
    private Boolean isPraise;//是否点赞

    public Dynamic(){};

    public Dynamic(Long id) {
        this.setId(id);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getVedioUrl() {
        return vedioUrl;
    }

    public void setVedioUrl(String vedioUrl) {
        this.vedioUrl = vedioUrl;
    }

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public Set<DynamicImage> getImages() {
        return images;
    }

    public void setImages(Set<DynamicImage> images) {
        this.images = images;
    }

    public Boolean getIsCollect() {
        return isCollect;
    }

    public void setIsCollect(Boolean isCollect) {
        this.isCollect = isCollect;
    }

    public Boolean getIsPraise() {
        return isPraise;
    }

    public void setIsPraise(Boolean isPraise) {
        this.isPraise = isPraise;
    }
}