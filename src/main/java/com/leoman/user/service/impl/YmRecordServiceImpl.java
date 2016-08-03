package com.leoman.user.service.impl;

import com.leoman.common.service.impl.GenericManagerImpl;
import com.leoman.team.dao.TeamDao;
import com.leoman.team.entity.Team;
import com.leoman.user.dao.UserInfoDao;
import com.leoman.user.dao.YmRecordDao;
import com.leoman.user.entity.UserInfo;
import com.leoman.user.entity.YmRecord;
import com.leoman.user.service.YmRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Daisy on 2016/8/2.
 */
@Service
@Transactional(readOnly = true)
public class YmRecordServiceImpl extends GenericManagerImpl<YmRecord,YmRecordDao> implements YmRecordService {

    @Autowired
    private YmRecordDao ymRecordDao;

    @Autowired
    private UserInfoDao userInfoDao;

    @Autowired
    private TeamDao teamDao;

    @Override
    @Transactional
    public void create(YmRecord ymRecord){

        if(ymRecord.getYm() != 0){

            //修改用户益米数
            if(ymRecord.getType().equals(0)){
                UserInfo user = userInfoDao.findOne(ymRecord.getJoinId());
                if(user != null){
                    if(ymRecord.getYm() > 0){
                        user.setYm(user.getYm()+ymRecord.getYm());
                    }else {
                        user.setYm(user.getYm()-ymRecord.getYm());
                    }
                    userInfoDao.save(user);
                }
            }
            //修改团队益米数
            else if(ymRecord.getType().equals(1)){
                Team team = teamDao.findOne(ymRecord.getJoinId());
                if(team != null){
                    if(ymRecord.getYm() > 0){
                        team.setYm(team.getYm()+ymRecord.getYm());
                    }else {
                        team.setYm(team.getYm()-ymRecord.getYm());
                    }

                    teamDao.save(team);
                }
            }

            //新增益米变化记录
            ymRecordDao.save(ymRecord);
        }
    }

    @Override
    public Page<YmRecord> findByJoinId(Integer type, Long joinId, Integer currentPage, Integer pageSize) {
        return ymRecordDao.findByJoinId(type, joinId, new PageRequest(currentPage-1, pageSize, Sort.Direction.DESC, "id"));
    }

}
