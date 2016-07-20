package com.leoman.user.service;


import com.leoman.common.service.GenericManager;
import com.leoman.user.entity.UserLogin;
import org.springframework.data.domain.Page;

/**
 * Created by Daisy on 2016/7/14.
 */
public interface UserLoginService extends GenericManager<UserLogin> {

    public Page<UserLogin> findAll(UserLogin userInfo, Integer currentPage, Integer pageSize) throws Exception;

    public UserLogin findOne(UserLogin userLogin) throws Exception;

}
