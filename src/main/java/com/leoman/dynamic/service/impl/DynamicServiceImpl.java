package com.leoman.dynamic.service.impl;

import com.leoman.common.service.impl.GenericManagerImpl;
import com.leoman.dynamic.dao.DynamicDao;
import com.leoman.dynamic.entity.Dynamic;
import com.leoman.dynamic.entity.DynamicImage;
import com.leoman.dynamic.service.DynamicImageService;
import com.leoman.dynamic.service.DynamicService;
import com.leoman.image.service.UploadImageService;
import com.leoman.user.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.TableGenerator;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Daisy on 2016/7/21.
 */
@Service
@Transactional(readOnly = true)
public class DynamicServiceImpl extends GenericManagerImpl<Dynamic,DynamicDao> implements DynamicService {

    @Autowired
    private DynamicDao dynamicDao;

    @Autowired
    private DynamicImageService dynamicImageService;

    @Autowired
    private UploadImageService uploadImageService;

    @Override
    public Page<Dynamic> findAll(Integer pageNum, Integer pageSize){
        return dynamicDao.findAll(new PageRequest(pageNum-1, pageSize, Sort.Direction.DESC, "isTop","id"));
    }

    @Override
    @Transactional
    public Dynamic create(Long userId,String content,MultipartFile vedio,MultipartFile [] images) {
        String vedioUrl = uploadImageService.uploadFile(vedio);
        //新增动态
        Dynamic dynamic = new Dynamic();
        dynamic.setUser(new UserInfo(userId));
        dynamic.setContent(content);
        dynamic.setVedioUrl(vedioUrl);
        dynamic.setIsTop(0);
        dynamic.setStatus(0);
        dynamicDao.save(dynamic);

        //新增动态图片
        Set<DynamicImage> set = new HashSet<>();
        for (MultipartFile file:images) {
            DynamicImage di = new DynamicImage();
            String imageUrl = uploadImageService.uploadFile(file);
            di.setDynamicId(dynamic.getId());
            di.setImageUrl(imageUrl);
            dynamicImageService.save(di);
            set.add(di);
        }

        dynamic.setImages(set);
        return dynamic;
    }

}
