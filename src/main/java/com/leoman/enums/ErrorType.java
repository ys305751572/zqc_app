package com.leoman.enums;

/**
 * Created by Administrator on 2015/12/2.
 */
public enum ErrorType {



    ERROR_CODE_1001("参数不正确",1001),
    ERROR_CODE_1002("服务器异常",1002),
    ERROR_CODE_1004("type类型错误",1004),
    ERROR_CODE_2001("手机号已被注册",2001),
    ERROR_CODE_2002("验证码错误",2002),
    ERROR_CODE_2003("用户名密码错误",2003),
    ERROR_CODE_2004("用户不存在",2004),
    ERROR_CODE_2005("旧密码错误",2005),
    ERROR_CODE_2007("用户名已被注册",2007),
    ERROR_CODE_2012("验证超时，请重新验证",2012),
    ERROR_CODE_2013("手机号不存在",2013),
    ERROR_CODE_3001("当前登录人无法删除他人的数据",3001),
    ERROR_CODE_3002("用户被冻结",3002),


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
