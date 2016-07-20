package com.leoman.enums;

/**
 * Created by Administrator on 2015/12/2.
 */
public enum ErrorType {



    ERROR_CODE_1001("参数不正确",1001),
    ERROR_CODE_1002("服务器异常",1002),
    ERROR_CODE_1003("url不存在",1003),
    ERROR_CODE_1004("type类型错误",1004),
    ERROR_CODE_2001("手机号已被注册",2001),
    ERROR_CODE_2002("验证码错误",2002),
    ERROR_CODE_2003("用户名密码错误",2003),
    ERROR_CODE_2004("用户不存在",2004),
    ERROR_CODE_2005("旧密码错误",2005),
    ERROR_CODE_2006("邮箱己被注册",2006),
    ERROR_CODE_2007("用户名已被注册",2007),
    ERROR_CODE_2008("密保问题提交出错",2008),
    ERROR_CODE_2009("该类型已经通过认证",2009),
    ERROR_CODE_2010("用户名,手机号或邮箱不存在",2010),
    ERROR_CODE_2011("安全问题验证错误",2011),
    ERROR_CODE_2012("验证超时，请重新验证",2012),
    ERROR_CODE_2013("手机号不存在",2013),
    ERROR_CODE_2014("邮箱不存在",2014),
    ERROR_CODE_3001("抽奖未开启",3001),
    ERROR_CODE_3002("用户活跃度不足200",3002),
    ERROR_CODE_3003("活跃度不足200不能转换",3003),

    ErrorType;


    private String name;

    private int code;



    private ErrorType(){}

    private ErrorType(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
