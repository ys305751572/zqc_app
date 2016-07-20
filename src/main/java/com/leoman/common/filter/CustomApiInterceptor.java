package com.leoman.common.filter;

import com.leoman.user.service.UserInfoService;
import com.leoman.common.core.Constant;
import com.leoman.enums.ErrorType;
import com.leoman.user.entity.UserInfo;
import com.leoman.utils.Result;
import com.leoman.utils.WebUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wangbin on 2015/12/24.
 */
public class CustomApiInterceptor extends HandlerInterceptorAdapter {


    @Autowired
    private UserInfoService userInfoService;


    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
            String userIdStr = request.getParameter("userId");
            if (StringUtils.isNotBlank(userIdStr)) {
                Long userId = Long.valueOf(userIdStr);
                UserInfo userInfo = userInfoService.queryByPK(userId);
                if (userInfo == null) {
                    WebUtil.print(response, new Result(ErrorType.ERROR_CODE_2004));
                    return false;
                }
                request.setAttribute(Constant.CACHE_USER, userInfo);
            }
            return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {


    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {


    }

}
