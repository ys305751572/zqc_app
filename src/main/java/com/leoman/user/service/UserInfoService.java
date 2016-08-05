package com.leoman.user.service;


import com.leoman.common.service.GenericManager;
import com.leoman.user.entity.UserInfo;
import com.leoman.user.entity.UserLogin;
import org.springframework.data.domain.Page;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Daisy on 2016/7/14.
 */
public interface UserInfoService extends GenericManager<UserInfo> {

    public UserInfo findByLoginId(Long loginId);

    public UserInfo findOne(UserInfo userInfo) throws Exception;

    public Page<UserInfo> findAll(Integer currentPage, Integer pageSize) throws Exception;

    public UserInfo create(UserInfo userInfo, String password, String ipAddress);

    public void sign(Long userId) throws Exception;

}
