package com.leoman.team.service.impl;

import com.leoman.common.exception.GeneralExceptionHandler;
import com.leoman.common.service.impl.GenericManagerImpl;
import com.leoman.image.service.UploadImageService;
import com.leoman.team.dao.TeamDao;
import com.leoman.team.dao.TeamUserDao;
import com.leoman.team.entity.Team;
import com.leoman.team.entity.TeamUser;
import com.leoman.team.service.TeamService;
import com.leoman.user.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Daisy on 2016/7/27.
 */
@Service
public class TeamServiceImpl extends GenericManagerImpl<Team,TeamDao> implements TeamService {

    @Autowired
    private TeamDao teamDao;

    @Autowired
    private TeamUserDao teamUserDao;

    @Autowired
    private UploadImageService uploadImageService;


    /**
     * 创建一个团队
     * @param name
     */
    @Override
    public Team create(String name, String slogan, Long userId, MultipartFile cover) {
        Team t = teamDao.findByName(name);
        if(t != null){
            GeneralExceptionHandler.handle("该名字已重复，请重新输入");
        }

        TeamUser tu = teamUserDao.findByUserId(userId);
        if(tu != null){
            GeneralExceptionHandler.handle("该用户已在团队："+ tu.getTeam().getName());
        }

        String coverUrl = uploadImageService.uploadFile(cover);

        //新增一个团队
        Team team = new Team();
        team.setName(name);
        team.setUser(new UserInfo(userId));
        team.setSlogan(slogan);
        team.setCoverUrl(coverUrl);
        team.setStatus(0);
        team.setIntegral(0);
        team.setYm(0);
        team.setNums(1);
        team.setCreateDate(System.currentTimeMillis());
        team.setUpdateDate(System.currentTimeMillis());
        teamDao.save(team);

        //新增团队成员
        TeamUser teamUser = new TeamUser();
        teamUser.setTeam(team);
        teamUser.setUser(new UserInfo(userId));
        teamUser.setCreateDate(System.currentTimeMillis());
        teamUser.setUpdateDate(System.currentTimeMillis());
        teamUserDao.save(teamUser);

        return team;
    }

    @Override
    public void join(Long teamId, Long userId) {
        TeamUser tu = teamUserDao.findByUserId(userId);
        if(tu != null){
            GeneralExceptionHandler.handle("该用户已在团队："+tu.getTeam().getName());
        }

        //新增团队成员
        TeamUser teamUser = new TeamUser();
        teamUser.setTeam(new Team(teamId));
        teamUser.setUser(new UserInfo(userId));
        teamUser.setCreateDate(System.currentTimeMillis());
        teamUser.setUpdateDate(System.currentTimeMillis());
        teamUserDao.save(teamUser);

        //修改团队人数
        Team team = tu.getTeam();
        team.setNums(team.getNums()+1);
        teamDao.save(team);
    }
}
