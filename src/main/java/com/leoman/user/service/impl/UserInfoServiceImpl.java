package com.leoman.user.service.impl;

import com.leoman.common.exception.GeneralExceptionHandler;
import com.leoman.common.service.impl.GenericManagerImpl;
import com.leoman.user.dao.UserInfoDao;
import com.leoman.user.dao.UserLoginDao;
import com.leoman.user.entity.UserInfo;
import com.leoman.user.entity.UserInfo;
import com.leoman.user.entity.UserInfo;
import com.leoman.user.entity.UserLogin;
import com.leoman.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.util.SystemPropertyUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Daisy on 2016/7/14.
 */
@Service
@Transactional(readOnly = true)
public class UserInfoServiceImpl extends GenericManagerImpl<UserInfo,UserInfoDao> implements UserInfoService {

    @Autowired
    private UserInfoDao infoDao;

    @Autowired
    private UserLoginDao loginDao;

    @Override
    public UserInfo findByLoginId(Long loginId) {
        return infoDao.findByLoginId(loginId);
    }

    @Override
    public UserInfo findOne(UserInfo userInfo) throws  Exception{
        Specification<UserInfo> spec = buildSpecification(userInfo);
        UserInfo user = infoDao.findOne(spec);
        return user;
    }

    @Override
    public Page<UserInfo> findAll(Integer currentPage, Integer pageSize) throws Exception {
        return infoDao.findAll(new PageRequest(currentPage-1, pageSize, Sort.Direction.DESC, "integral"));
    }

    /**
     * 注册
     * @param userInfo
     * @param password
     * @param ipAddress
     * @return
     */
    @Override
    @Transactional
    public UserInfo create(UserInfo userInfo, String password, String ipAddress) {
        //新增登录
        UserLogin userLogin = new UserLogin();
        userLogin.setUsername(userInfo.getMobile());
        userLogin.setPassword(password);
        userLogin.setIp_address(ipAddress);
        UserLogin ul = loginDao.save(userLogin);

        //新增用户
        userInfo.setUserLogin(ul);
        userInfo.setGender(0);
        userInfo.setIntegral(0);
        userInfo.setYm(0);
        userInfo.setLevel(1);
        userInfo.setSign("0|0");
        UserInfo u = infoDao.save(userInfo);
        return u;
    }

    @Override
    @Transactional
    public void sign(Long userId) throws Exception{
        UserInfo user = infoDao.findOne(userId);
        if(user == null){
            GeneralExceptionHandler.handle("用户不存在");
        }
        Date lsd = user.getLastSignDate();

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date now = df.parse(df.format(new Date()));

        String [] signArr = user.getSign().split("\\|");
        Long continueCount = Long.valueOf(signArr[0]);//连续签到次数
        Long totalCount = Long.valueOf(signArr[1]);//总共签到次数

        if(lsd != null){
            Long day = (now.getTime() - lsd.getTime())/(1000*3600*24);
            if(day < 1){
                GeneralExceptionHandler.handle("今天已经签到过了");
            }
            if(day > 1){
                continueCount = 0l;
            }
        }
        user.setLastSignDate(new Date());
        user.setSign( (continueCount+1) + "|" + (totalCount+1) );
        infoDao.save(user);
    }

    public Specification<UserInfo> buildSpecification(final UserInfo userInfo) {
        Specification<UserInfo> sepc = new Specification<UserInfo>() {
            @Override
            public Predicate toPredicate(Root<UserInfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                try {
                    List<Predicate> predicateList = new ArrayList<Predicate>();
                    Predicate result = null;

                    BeanInfo beanInfo = Introspector.getBeanInfo(userInfo.getClass());
                    PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
                    for (PropertyDescriptor property : propertyDescriptors) {
                        String key = property.getName();//字段名
                        Type type = property.getPropertyType();//字段类型

                        // 过滤class属性
                        if (!key.equals("class")) {
                            // 得到property对应的getter方法
                            Method getter = property.getReadMethod();
                            Object value = getter.invoke(userInfo);

                            if(value != null){
                                //字符串用like拼接
                                if(type.equals(String.class) && !StringUtils.isEmpty(value)){
                                    Predicate predicate = cb.like(root.get(key).as(String.class), "%"+value+"%");
                                    predicateList.add(predicate);
                                }else if(type.equals(Integer.class)){
                                    Predicate predicate = cb.equal(root.get(key).as(Integer.class), value);
                                    predicateList.add(predicate);
                                }
                            }
                        }
                    }
                    if (predicateList.size() > 0) {
                        result = cb.and(predicateList.toArray(new Predicate[]{}));
                    }
                    if (result != null) {
                        query.where(result);
                    }
                } catch (IntrospectionException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                return query.getRestriction();
            }
        };
        return sepc;
    }
}
