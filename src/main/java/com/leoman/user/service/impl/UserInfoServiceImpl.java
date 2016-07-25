package com.leoman.user.service.impl;

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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daisy on 2016/7/14.
 */
@Service
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
    public Page<UserInfo> findAll(UserInfo userInfo, Integer currentPage, Integer pageSize) throws Exception {
        Specification<UserInfo> spec = buildSpecification(userInfo);
        return infoDao.findAll(spec, new PageRequest(currentPage-1, pageSize, Sort.Direction.DESC, "id"));
    }

    @Override
    @Transactional
    public UserInfo create(UserInfo userInfo, String password, String ipAddress) {
        //新增登录
        UserLogin userLogin = new UserLogin();
        userLogin.setUsername(userInfo.getMobile());
        userLogin.setPassword(password);
        userLogin.setIp_address(ipAddress);
        userLogin.setCreateDate(System.currentTimeMillis());
        userLogin.setUpdateDate(System.currentTimeMillis());
        UserLogin ul = loginDao.save(userLogin);

        //新增用户
        userInfo.setUserLogin(ul);
        UserInfo u = infoDao.save(userInfo);
        return u;
    }

    public Specification<UserInfo> buildSpecification(final UserInfo userInfo) {
        /*return new Specification<UserInfo>() {
            @Override
            public Predicate toPredicate(Root<UserInfo> root, CriteriaQuery<?> cq,
                                         CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<Predicate>();



                Predicate[] p = new Predicate[list.size()];
                return cb.and(list.toArray(p));
            }
        };*/
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
                                }else{
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
