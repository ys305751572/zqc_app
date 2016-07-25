package com.leoman.dynamic.entity;

import com.leoman.common.annotion.Exclude;
import com.leoman.common.entity.BaseEntity;
import com.leoman.user.entity.UserInfo;

import javax.persistence.*;
import java.util.Set;

/**
 * 朋友圈动态评论
 * Created by Daisy on 2016/7/22.
 */
@Entity
@Table(name = "t_dynamic_comment")
public class DynamicComment extends BaseEntity{

    @Exclude
    @ManyToOne
    @JoinColumn(name = "dynamic_id")
    private Dynamic dynamic;//动态

    @ManyToOne
    @JoinColumn(name = "from_user_id")
    private UserInfo fromUser;//评论用户

    @ManyToOne
    @JoinColumn(name = "to_user_id")
    private UserInfo toUser;//被评论用户

    @Column(name = "content")
    private String content;

    public Dynamic getDynamic() {
        return dynamic;
    }

    public void setDynamic(Dynamic dynamic) {
        this.dynamic = dynamic;
    }

    public UserInfo getFromUser() {
        return fromUser;
    }

    public void setFromUser(UserInfo fromUser) {
        this.fromUser = fromUser;
    }

    public UserInfo getToUser() {
        return toUser;
    }

    public void setToUser(UserInfo toUser) {
        this.toUser = toUser;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}