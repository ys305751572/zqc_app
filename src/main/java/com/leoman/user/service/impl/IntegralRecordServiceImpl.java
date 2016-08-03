package com.leoman.user.service.impl;

import com.leoman.common.service.impl.GenericManagerImpl;
import com.leoman.team.dao.TeamDao;
import com.leoman.team.entity.Team;
import com.leoman.user.dao.IntegralRecordDao;
import com.leoman.user.dao.UserInfoDao;
import com.leoman.user.entity.IntegralRecord;
import com.leoman.user.entity.UserInfo;
import com.leoman.user.entity.YmRecord;
import com.leoman.user.service.IntegralRecordService;
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
public class IntegralRecordServiceImpl extends GenericManagerImpl<IntegralRecord,IntegralRecordDao> implements IntegralRecordService {

    @Autowired
    private IntegralRecordDao integralRecordDao;

    @Autowired
    private UserInfoDao userInfoDao;

    @Autowired
    private TeamDao teamDao;

    @Override
    @Transactional
    public void create(IntegralRecord integralRecord){

        if(integralRecord.getIntegral() != 0){

            //修改用户积分数
            if(integralRecord.getType().equals(0)){
                UserInfo user = userInfoDao.findOne(integralRecord.getJoinId());
                if(user != null){
                    if(integralRecord.getIntegral() > 0){
                        user.setIntegral(user.getIntegral()+integralRecord.getIntegral());
                    }else {
                        user.setIntegral(user.getIntegral()-integralRecord.getIntegral());
                    }
                    userInfoDao.save(user);
                }
            }
            //修改团队积分数
            else if(integralRecord.getType().equals(1)){
                Team team = teamDao.findOne(integralRecord.getJoinId());
                if(team != null){
                    if(integralRecord.getIntegral() > 0){
                        team.setIntegral(team.getIntegral()+integralRecord.getIntegral());
                    }else {
                        team.setIntegral(team.getIntegral()-integralRecord.getIntegral());
                    }

                    teamDao.save(team);
                }
            }

            //新增积分变化记录
            integralRecordDao.save(integralRecord);
        }
    }

    @Override
    public Page<IntegralRecord> findByJoinId(Integer type, Long joinId, Integer currentPage, Integer pageSize) {
        return integralRecordDao.findByJoinId(type, joinId, new PageRequest(currentPage-1, pageSize, Sort.Direction.DESC, "id"));
    }

}
