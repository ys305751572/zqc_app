package com.leoman.dynamic.service;


import com.leoman.common.service.GenericManager;
import com.leoman.dynamic.entity.Dynamic;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Daisy on 2016/7/21.
 */
public interface DynamicService extends GenericManager<Dynamic> {

    public Dynamic create(Long userId, String content, MultipartFile vedio, MultipartFile [] images);

    public Page<Dynamic> findAll(Integer pageNum, Integer pageSize);

}
