package com.leoman.banner.service;


import com.leoman.banner.entity.Banner;
import com.leoman.common.service.GenericManager;
import com.leoman.team.entity.Team;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Daisy on 2016/8/4.
 */
public interface BannerService extends GenericManager<Banner> {

    public List<Banner> findByPosition(Integer position);
}
