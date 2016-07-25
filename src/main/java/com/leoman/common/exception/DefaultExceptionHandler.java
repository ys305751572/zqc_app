package com.leoman.common.exception;

import com.leoman.enums.ErrorType;
import com.leoman.utils.Result;
import com.leoman.utils.WebUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wangbin on 2015/12/25.
 */
public class DefaultExceptionHandler implements HandlerExceptionResolver {


    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        try {
            HandlerMethod handlerMethod =	(HandlerMethod)handler;
            if(handlerMethod!=null){
                String methodName =  handlerMethod.getMethod().getName();
                String beanName = handlerMethod.getBean().getClass().getName();
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                GeneralExceptionHandler.log(beanName + "类" + methodName + "方法" + "异常", ex);
                if(ex.getMessage().contains("Exception")){
                    WebUtil.print(response,new Result(ErrorType.ERROR_CODE_1002));//服务器异常
                }else{
                    WebUtil.print(response,new Result().failure(ex.getMessage()));//指定的错误消息
                }
            }
        }catch (Exception e){
            GeneralExceptionHandler.log(e);
        }
        return null;
    }




}
