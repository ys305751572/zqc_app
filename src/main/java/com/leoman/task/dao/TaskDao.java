package com.leoman.task.dao;


import com.leoman.common.dao.IBaseJpaRepository;
import com.leoman.task.entity.Task;
import com.leoman.user.entity.UserInfo;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Daisy on 2016/7/25.
 */
public interface TaskDao extends IBaseJpaRepository<Task> {


}
