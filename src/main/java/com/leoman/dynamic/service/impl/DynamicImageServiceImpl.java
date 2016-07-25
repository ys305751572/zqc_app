package com.leoman.dynamic.service.impl;

import com.leoman.common.service.impl.GenericManagerImpl;
import com.leoman.dynamic.dao.DynamicDao;
import com.leoman.dynamic.dao.DynamicImageDao;
import com.leoman.dynamic.entity.Dynamic;
import com.leoman.dynamic.entity.DynamicImage;
import com.leoman.dynamic.service.DynamicImageService;
import com.leoman.dynamic.service.DynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
 * Created by Daisy on 2016/7/21.
 */
@Service
@Transactional
public class DynamicImageServiceImpl extends GenericManagerImpl<DynamicImage,DynamicImageDao> implements DynamicImageService {


}
