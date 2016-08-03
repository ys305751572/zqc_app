package com.leoman.task.service;


import com.leoman.common.service.GenericManager;
import com.leoman.task.entity.Task;
import com.leoman.task.entity.TaskJoin;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Daisy on 2016/7/25.
 */
public interface TaskJoinService extends GenericManager<TaskJoin> {

    public void create(Long taskId, Long joinId);

    public TaskJoin findByTaskIdAndJoinId(Long taskId, Long joinId);

    public void createTaskJoinImage(Long taskId, Long joinId, MultipartFile[] images);

    public Page<TaskJoin> findByUserId(Long userId, Integer status, Integer currentPage, Integer pageSize);

    public void allotYm(Long userId, Long taskJoinId, Integer ym);

}
