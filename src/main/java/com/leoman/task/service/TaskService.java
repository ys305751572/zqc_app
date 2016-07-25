package com.leoman.task.service;


import com.leoman.common.service.GenericManager;
import com.leoman.task.entity.Task;
import org.springframework.data.domain.Page;

/**
 * Created by Daisy on 2016/7/25.
 */
public interface TaskService extends GenericManager<Task> {

    public Page<Task> findAll(Task task, Integer currentPage, Integer pageSize);

}
