package com.leoman.user.dao;


import com.leoman.common.dao.IBaseJpaRepository;
import com.leoman.user.entity.UserInfo;
import com.leoman.user.entity.UserLogin;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Daisy on 2016/7/14.
 */
public interface UserLoginDao extends IBaseJpaRepository<UserLogin> {

}
