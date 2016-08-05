package com.leoman.team.service;


import com.leoman.common.service.GenericManager;
import com.leoman.task.entity.Task;
import com.leoman.team.entity.Team;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Daisy on 2016/7/27.
 */
public interface TeamService extends GenericManager<Team> {

    public Team create(String name, String slogan, Long userId, MultipartFile cover);

    public void join(Long teamId, Long userId);

    public void quit(Long teamId, Long userId);

    public Page<Team> findAll(Integer currentPage, Integer pageSize);

}
