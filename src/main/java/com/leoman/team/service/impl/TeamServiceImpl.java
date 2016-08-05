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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    @Override
    public Page<Team> findAll(Integer currentPage, Integer pageSize){
        return teamDao.findAll(new PageRequest(currentPage-1, pageSize, Sort.Direction.DESC, "integral"));
    }


    /**
     * 创建一个团队
     * @param name
     * @param slogan
     * @param userId
     * @param cover
     * @return
     */
    @Override
    public Team create(String name, String slogan, Long userId, MultipartFile cover) {
        Team t = teamDao.findByName(name);
        if(t != null){
            GeneralExceptionHandler.handle("该名字已重复，请重新输入");
        }

        TeamUser tu = teamUserDao.findByUserId(userId);
        if(tu != null){
            GeneralExceptionHandler.handle("该用户已在其他团队：");
        }

        String coverUrl = uploadImageService.uploadFile(cover);

        //新增一个团队
        Team team = new Team();
        team.setName(name);
        team.setUserId(userId);
        team.setSlogan(slogan);
        team.setCoverUrl(coverUrl);
        team.setStatus(0);
        team.setIntegral(0);
        team.setYm(0);
        team.setNums(1);
        team.setLevel(1);
        teamDao.save(team);

        //新增团队成员
        TeamUser teamUser = new TeamUser();
        teamUser.setTeamId(team.getId());
        teamUser.setUserId(userId);
        teamUser.setIsHeader(1);
        teamUserDao.save(teamUser);

        return team;
    }

    /**
     * 加入一个团队
     * @param teamId
     * @param userId
     */
    @Override
    public void join(Long teamId, Long userId) {
        TeamUser tu = teamUserDao.findByUserId(userId);
        if(tu != null){
            GeneralExceptionHandler.handle("该用户已在其他团队");
        }

        //新增团队成员
        TeamUser teamUser = new TeamUser();
        teamUser.setTeamId(teamId);
        teamUser.setUserId(userId);
        teamUser.setIsHeader(0);
        teamUserDao.save(teamUser);

        //修改团队人数
        Team team = teamDao.findOne(teamId);
        if(team != null){
            team.setNums(team.getNums()+1);
            teamDao.save(team);
        }
    }

    /**
     * 退出一个团队
     * @param userId
     */
    @Override
    public void quit(Long teamId, Long userId) {
        TeamUser tu = teamUserDao.findByUserId(userId);
        if(tu == null){
            GeneralExceptionHandler.handle("该用户不在团队,或者用户所在团队不存在");
        }

        if(tu.getIsHeader().equals(1)){
            GeneralExceptionHandler.handle("群主不能退群");
        }

        teamUserDao.delete(tu);

        //修改团队人数
        Team team = teamDao.findOne(teamId);
        if(team != null){
            team.setNums(team.getNums()-1);
            teamDao.save(team);
        }
    }

}
