package com.leoman.user.dao;


import com.leoman.common.dao.IBaseJpaRepository;
import com.leoman.user.entity.UserInfo;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Daisy on 2016/7/14.
 */
public interface UserInfoDao extends IBaseJpaRepository<UserInfo> {

    @Query("select a from UserInfo a where a.userLogin.id = ?1 ")
    public UserInfo findByLoginId(Long loginId);

}
