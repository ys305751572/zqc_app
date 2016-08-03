package com.leoman.team.dao;


import com.leoman.common.dao.IBaseJpaRepository;
import com.leoman.team.entity.Team;
import com.leoman.team.entity.TeamUser;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Daisy on 2016/7/27.
 */
public interface TeamUserDao extends IBaseJpaRepository<TeamUser> {

    @Query("select a from TeamUser a where a.userId = ?1")
    public TeamUser findByUserId(Long userId);

    @Query("select a from TeamUser a where a.teamId = ?1")
    public List<TeamUser> findByTeamId(Long teamId);

}
