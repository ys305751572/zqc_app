package com.leoman.team.dao;


import com.leoman.common.dao.IBaseJpaRepository;
import com.leoman.task.entity.Task;
import com.leoman.team.entity.Team;
import com.leoman.user.entity.UserInfo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Daisy on 2016/7/27.
 */
public interface TeamDao extends IBaseJpaRepository<Team> {

    @Query("select a from Team a where a.name = ?1")
    public Team findByName(String name);

    @Query("select a from Team a where a.userId = ?1")
    public Team findByUserId(Long userId);

}
