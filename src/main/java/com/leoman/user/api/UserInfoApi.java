package com.leoman.user.api;

import com.leoman.cache.service.CommonStringCache;
import com.leoman.common.controller.common.CommonController;
import com.leoman.common.core.Configue;
import com.leoman.enums.ErrorType;
import com.leoman.image.entity.Image;
import com.leoman.image.service.UploadImageService;
import com.leoman.user.entity.UserInfo;
import com.leoman.user.entity.UserLogin;
import com.leoman.user.service.UserInfoService;
import com.leoman.user.service.UserLoginService;
import com.leoman.utils.*;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Daisy on 2016/7/14.
 */
@Controller
@RequestMapping("/api/user")
public class UserInfoApi extends CommonController{

    private static Logger logger = LoggerFactory.getLogger(UserInfoApi.class);

    private static final String REG_CODE_PREFIX = "REG_CODE_";
    private static final String FIND_PASSWORD_CODE_PREFIX = "FIND_PASSWORD_CODE_";

    @Resource(name = "commonStringCache")
    private CommonStringCache commonStringCache;//缓存

    @Autowired
    private UserLoginService userLoginService;//用户登录

    @Autowired
    private UserInfoService userInfoService;//用户

    @Autowired
    private UploadImageService uploadImageService;//图片上传

    /**
     * @api {post} /api/user/login  01、登录
     * @apiVersion 0.0.1
     * @apiName user.login
     * @apiGroup user
     * @apiDescription 用户登录
     *
     * @apiParam {STRING} username 用户名
     * @apiParam {STRING} password 密码
     *
     * @apiSuccess {Object}   user  用户对象
     * @apiSuccess {NUMBER}   user.id 用户id
     * @apiSuccess {String}   user.mobile 手机号
     * @apiSuccess {String}   user.nickname 昵称
     * @apiSuccess {NUMBER}   user.gender 性别 男-0，女-1
     * @apiSuccess {String}   user.avater 头像
     * @apiSuccess {String}   user.status 状态 0:正常 1:冻结
     * @apiSuccess {String}   user.level 会员等级
     * @apiSuccess {String}   user.integral 积分
     * @apiSuccess {String}   user.ym 益米
     * @apiSuccess {String}   user.IDCard 身份证号
     * @apiSuccess {String}   user.sign index0 : 今日是否签到 0:未签到 1:已签到 index1:连续签到次数 index2:总共签到次数
     */
    @RequestMapping("login")
    public void login(HttpServletRequest request,
                      HttpServletResponse response,
                      UserLogin userLogin){
        try {
            UserLogin ul = userLoginService.findOne(userLogin);
            if(ul == null){
                WebUtil.print(response,new Result(ErrorType.ERROR_CODE_2004));//用户不存在
            }
            if(!userLogin.getPassword().equals(ul.getPassword())){
                WebUtil.print(response,new Result(ErrorType.ERROR_CODE_2003));//密码错误
            }

            //登录成功后，返回当前用户信息
            UserInfo user = userInfoService.findByLoginId(ul.getId());

            if(user.getStatus().equals(1)){
                WebUtil.print(response,new Result(ErrorType.ERROR_CODE_3002));//用户被冻结
            }
            WebUtil.printJson(response,new Result().success(createMap("user", user)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @api {post} /api/userInfo/register  02、注册
     * @apiVersion 0.0.1
     * @apiName user.register
     * @apiGroup user
     * @apiDescription 用户注册
     * @apiParam {STRING} mobile 手机号
     * @apiParam {STRING} password 密码
     * @apiParam {STRING} nickname 昵称
     * @apiParam {STRING} mobile 身份证号
     * @apiParam {NUMBER} gender 性别 男:0 女:1
     * @apiParam {STRING} code 验证码
     */
    @RequestMapping("register")
    public void register(HttpServletRequest request,
                         HttpServletResponse response,
                         UserInfo userInfo,
                         @RequestParam(required = true) String password,
                         @RequestParam(required = true) String code) throws Exception {

        String cacheCode =  commonStringCache.get(REG_CODE_PREFIX+ userInfo.getMobile());
        if(StringUtils.isBlank(cacheCode)||!cacheCode.equals(code)){
            WebUtil.printJson(response,new Result(ErrorType.ERROR_CODE_2002));//验证码错误
            return;
        }

        UserInfo user = userInfoService.findOne(new UserInfo(userInfo.getMobile()));
        if(user != null){
            WebUtil.printJson(response,new Result(ErrorType.ERROR_CODE_2001));//手机号已被注册
            return;
        }

        //新增用户
        userInfoService.create(userInfo, Md5Util.md5(password), HttpUtils.getUserIpByRequest(request));
        WebUtil.printJson(response,getUserJson(userInfo));
    }

    /**
     * @api {post} /api/user/info  03、获取用户信息
     * @apiVersion 0.0.1
     * @apiName user.info
     * @apiGroup user
     * @apiDescription 获取用户信息
     * @apiParam {STRING} userId 用户ID
     *
     */
    @RequestMapping("info")
    public void info(HttpServletRequest request,
                     HttpServletResponse response,
                     @RequestParam(required=true) Long userId){
        UserInfo userInfo = getUserByRequest(request);
        if(userInfo == null){
            WebUtil.printJson(response,new Result(ErrorType.ERROR_CODE_2004));//用户不存在
            return ;
        }
        WebUtil.printJson(response,getUserJson(userInfo));
    }


    /**
     * @api {post} /api/user/edit  04、修改个人信息
     * @apiVersion 0.0.1
     * @apiName user.edit
     * @apiGroup user
     * @apiDescription 修改用户个人信息
     *
     * @apiParam {NUMBER} userId 用户ID
     * @apiParam {String} [nickname]  用户昵称
     * @apiParam {NUMBER} [sex] 性别(0男,1女)
     *
     * @apiSuccess {Object}   user  用户对象
     * @apiSuccess {NUMBER}   user.id 用户id
     * @apiSuccess {String}   user.mobile 手机号
     * @apiSuccess {String}   user.nickname 昵称
     * @apiSuccess {String}   user.gender 性别
     * @apiSuccess {String}   user.avater 头像
     * @apiSuccess {String}   user.status 状态 0:正常 1:冻结
     * @apiSuccess {String}   user.level 会员等级
     * @apiSuccess {String}   user.integral 积分
     * @apiSuccess {String}   user.ym 益米
     * @apiSuccess {String}   user.IDCard 身份证号
     * @apiSuccess {String}   user.sign index0 : 今日是否签到 0:未签到 1:已签到 index1:连续签到次数 index2:总共签到次数
     */
    @RequestMapping("edit")
    public void edit(HttpServletRequest request,
                     HttpServletResponse response,
                     @RequestParam(required=true) Long userId,
                     String nickname,
                     Integer gender){
        UserInfo userInfo = getUserByRequest(request);
        if(userInfo == null){
            WebUtil.printJson(response,new Result(ErrorType.ERROR_CODE_2004));//用户不存在
            return ;
        }
        //昵称
        if(StringUtils.isNotEmpty(nickname)){
            userInfo.setNickname(nickname);
        }
        //性别
        if(gender != null){
            userInfo.setGender(gender);
        }
        userInfoService.update(userInfo);
        WebUtil.printJson(response,getUserJson(userInfo));
    }

    /**
     * @api {post} /api/user/head/upload 05、上传用户头像
     * @apiVersion 0.0.1
     * @apiName user.head.upload
     * @apiGroup user
     *
     * @apiDescription 上传用户头像
     *
     * @apiParam {NUMBER} userId 用户ID
     * @apiParam {FILE} file 头像
     */
    @RequestMapping(value = "/head/upload")
    public void userHeadUpload(HttpServletRequest request,
                               HttpServletResponse response,
                               @RequestParam(required = true) Long userId,
                               @RequestParam(required = true) MultipartFile file)throws Exception  {
        UserInfo userInfo = getUserByRequest(request);
        if(userInfo == null){
            WebUtil.printJson(response,new Result(ErrorType.ERROR_CODE_2004));//用户不存在
            return ;
        }
        Image image = uploadImageService.uploadImage(file);
        userInfo.setAvater(image.getPath());//设置头像
        userInfoService.update(userInfo);
        WebUtil.printJson(response,getUserJson(userInfo));
    }

    /**
     * @api {post} /api/user/password/edit  06、修改密码-通过原密码修改密码
     * @apiVersion 0.0.1
     * @apiName user.password.edit
     * @apiGroup user
     * @apiDescription 使用旧密码修改密码
     *
     * @apiParam {NUMBER} userId 用户ID
     * @apiParam {String} oldPassword 旧密码(MD5)
     * @apiParam {String} newPassword 新密码(MD5)
     *
     *
     */
    @RequestMapping(value = "/password/edit")
    public void editPassword(HttpServletRequest request,
                             HttpServletResponse response,
                             @RequestParam(required=true) Long userId,
                             @RequestParam(required=true) String oldPassword,
                             @RequestParam(required=true) String newPassword) throws Exception{
        UserInfo user = getUserByRequest(request);
        if(user == null){
            WebUtil.printJson(response,new Result(ErrorType.ERROR_CODE_2004));//用户不存在
        }
        UserLogin userLogin = userLoginService.findOne(new UserLogin(user.getMobile()));
        if(!userLogin.getPassword().equals(Md5Util.md5(oldPassword))){
            WebUtil.printJson(response,new Result(ErrorType.ERROR_CODE_2005));//旧密码错误
            return;
        }
        userLogin.setPassword(Md5Util.md5(newPassword));//修改密码
        userLoginService.update(userLogin);
        WebUtil.printJson(response,new Result().success());
    }


    /**
     * @api {post} /api/user/sms/code  07、发送验证码
     * @apiVersion 0.0.1
     * @apiName user.sms.code
     * @apiGroup user
     * @apiDescription 根据类型发送验证码
     *
     * @apiParam {STRING} [mobile]  手机号
     * @apiParam {STRING} type  验证码类型(PASSWORD 找回密码验证码，REGISTER 注册验证码)
     *
     */
    @RequestMapping(value = "/sms/code")
    public void smsCode(HttpServletRequest request,
                        HttpServletResponse response,
                        @RequestParam(required=true) String mobile,
                        @RequestParam(required=true) String type){

        try {
            UserInfo userInfo = userInfoService.findOne(new UserInfo(mobile));
            String cacheFlag = "";
            if("REGISTER".equals(type)){
                if(userInfo !=null){
                    WebUtil.printJson(response,new Result(ErrorType.ERROR_CODE_2001));//手机号已被注册
                    return ;
                }
                cacheFlag = REG_CODE_PREFIX;
            }else if("PASSWORD".equals(type)){
                if(userInfo ==null){
                    WebUtil.printJson(response,new Result(ErrorType.ERROR_CODE_2013));//手机号不存在
                    return ;
                }
                cacheFlag = FIND_PASSWORD_CODE_PREFIX;
            }else{
                WebUtil.printJson(response,new Result(ErrorType.ERROR_CODE_1004));
                return ;
            }

            //发送验证码
            String code = SeqNoUtils.getVerCode(6);
            logger.info("--------------------->"+code);
            //发送短信
            sendSms(mobile,code);
            commonStringCache.put(cacheFlag + mobile, code,10*60);
            WebUtil.printJson(response,new Result());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @api {post} /api/user/password/code/valid  08、找回密码-校验验证码是否正确
     * @apiVersion 0.0.1
     * @apiName user.password.find.edit
     * @apiGroup user
     * @apiDescription 使用验证码修改密码
     * @apiParam {String} mobile  手机号
     * @apiParam {String} code  验证码
     */
    @RequestMapping(value = "/password/code/valid")
    public void updatePasswordEdit(HttpServletRequest request,
                                   HttpServletResponse response,
                                   @RequestParam(required=true) String mobile,
                                   @RequestParam(required=true) String code){

        try {
            String cacheCode =  commonStringCache.get(FIND_PASSWORD_CODE_PREFIX+mobile);
            if(StringUtils.isBlank(cacheCode) || !cacheCode.equals(code)){
                WebUtil.printJson(response,new Result(ErrorType.ERROR_CODE_2002));//验证码错误
                return;
            }
            WebUtil.printJson(response,new Result().success());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @api {post} /api/user/password/reset  09、修改密码-找回密码验证码验证成功后，重设密码
     * @apiVersion 0.0.1
     * @apiName user.password.reset
     * @apiGroup user
     * @apiDescription 使用旧密码修改密码
     *
     * @apiParam {String} mobile 手机号
     * @apiParam {String} newPassword 新密码(MD5)
     *
     *
     */
    @RequestMapping(value = "/password/reset")
    public void editPassword(HttpServletRequest request,
                             HttpServletResponse response,
                             @RequestParam(required=true) String mobile,
                             @RequestParam(required=true) String newPassword){
        try {
            UserLogin userLogin = userLoginService.findOne(new UserLogin(mobile));
            if(userLogin == null){
                WebUtil.printJson(response,new Result(ErrorType.ERROR_CODE_2004));//用户不存在
                return ;
            }
            userLogin.setPassword(Md5Util.md5(newPassword));//修改密码
            userLoginService.update(userLogin);
            WebUtil.printJson(response,new Result().success());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /**
     * 发送短信验证码
     * @param phone
     * @param code
     */
    public void sendSms(String phone,String code){
        String url = "http://v1.avatardata.cn/Sms/Send";
        String templateId ="04e0894446d943bba1f11fc57d48c378";
        String key = Configue.getSmsApiKey();
        Map<String,String> map = new HashMap<>();
        map.put("key",key);
        map.put("phone",phone);
        map.put("templateId",templateId);
        map.put("param","致青春平台验证码,"+code+",10分钟");
        HttpUtils.sendPost(url,map);
    }



    /**
     * 统一处理用户json
     * @param userInfo
     * @return
     */
    private String getUserJson(UserInfo userInfo){
        handleHeadUrl(userInfo);
        String result =  JsonUtil.obj2Json(new Result().success(createMap("user", userInfo)));
        return result;
    }


    /**
     * 处理用户头像
     * @param userInfo
     */
    public static void handleHeadUrl(UserInfo userInfo) {
        if(userInfo != null){
            if(StringUtils.isNotBlank(userInfo.getAvater())){
                userInfo.setAvater(Configue.getUploadUrl()+ userInfo.getAvater());
            }else{
                userInfo.setAvater("");
            }
        }
    }

}
