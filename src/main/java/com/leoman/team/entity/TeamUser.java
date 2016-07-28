package com.leoman.team.entity;

import com.leoman.common.entity.BaseEntity;
import com.leoman.user.entity.UserInfo;

import javax.persistence.*;

/**
 * 团队用户表
 * Created by Daisy on 2016/7/27.
 */
@Entity
@Table(name = "t_team_user")
public class TeamUser extends BaseEntity{

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "team_id")
    private Long teamId;

    @Column(name = "is_header")
    private Integer isHeader;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Integer getIsHeader() {
        return isHeader;
    }

    public void setIsHeader(Integer isHeader) {
        this.isHeader = isHeader;
    }
}