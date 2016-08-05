package com.leoman.banner.service.impl;

import com.leoman.banner.dao.BannerDao;
import com.leoman.banner.entity.Banner;
import com.leoman.banner.service.BannerService;
import com.leoman.common.exception.GeneralExceptionHandler;
import com.leoman.common.service.impl.GenericManagerImpl;
import com.leoman.image.service.UploadImageService;
import com.leoman.team.dao.TeamDao;
import com.leoman.team.dao.TeamUserDao;
import com.leoman.team.entity.Team;
import com.leoman.team.entity.TeamUser;
import com.leoman.team.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Daisy on 2016/8/4.
 */
@Service
public class BannerServiceImpl extends GenericManagerImpl<Banner,BannerDao> implements BannerService {

    @Autowired
    private BannerDao bannerDao;

    @Override
    public List<Banner> findByPosition(Integer position) {
        return bannerDao.findByPosition(position);
    }
}
