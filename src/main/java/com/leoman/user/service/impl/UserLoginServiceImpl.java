package com.leoman.user.service.impl;

import com.leoman.common.service.impl.GenericManagerImpl;
import com.leoman.pay.util.MD5Util;
import com.leoman.user.dao.UserLoginDao;
import com.leoman.user.entity.UserLogin;
import com.leoman.user.service.UserLoginService;
import com.leoman.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daisy on 2016/7/14.
 */
@Service
public class UserLoginServiceImpl extends GenericManagerImpl<UserLogin,UserLoginDao> implements UserLoginService {

    @Autowired
    private UserLoginDao dao;

    @Override
    public Page<UserLogin> findAll(UserLogin userInfo, Integer currentPage, Integer pageSize) throws Exception {
        Specification<UserLogin> spec = buildSpecification(userInfo);
        return dao.findAll(spec, new PageRequest(currentPage-1, pageSize, Sort.Direction.DESC, "id"));
    }

    @Override
    public UserLogin findOne(UserLogin userLogin) throws  Exception{
        Specification<UserLogin> spec = buildSpecification(userLogin);
        UserLogin login = dao.findOne(spec);
        return login;
    }

    public Specification<UserLogin> buildSpecification(final UserLogin userLogin) {

        Specification<UserLogin> sepc = new Specification<UserLogin>() {
            @Override
            public Predicate toPredicate(Root<UserLogin> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                try {
                    List<Predicate> predicateList = new ArrayList<Predicate>();
                    Predicate result = null;

                    BeanInfo beanInfo = Introspector.getBeanInfo(userLogin.getClass());
                    PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
                    for (PropertyDescriptor property : propertyDescriptors) {
                        String key = property.getName();//字段名
                        Type type = property.getPropertyType();//字段类型

                        // 过滤class属性
                        if (!key.equals("class")) {
                            // 得到property对应的getter方法
                            Method getter = property.getReadMethod();
                            Object value = getter.invoke(userLogin);

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
