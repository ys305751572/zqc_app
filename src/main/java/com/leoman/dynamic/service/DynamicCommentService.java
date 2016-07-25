package com.leoman.dynamic.service;


import com.leoman.common.service.GenericManager;
import com.leoman.dynamic.entity.Dynamic;
import com.leoman.dynamic.entity.DynamicComment;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Daisy on 2016/7/22.
 */
public interface DynamicCommentService extends GenericManager<DynamicComment> {

    public List<DynamicComment> findByDynamicId(Long dynamicId);

    public DynamicComment create(DynamicComment dynamicComment);

}
