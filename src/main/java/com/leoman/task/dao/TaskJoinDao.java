package com.leoman.task.dao;


import com.leoman.common.dao.IBaseJpaRepository;
import com.leoman.task.entity.Task;
import com.leoman.task.entity.TaskJoin;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Daisy on 2016/7/26.
 */
public interface TaskJoinDao extends IBaseJpaRepository<TaskJoin> {

    @Query("select a from TaskJoin a where a.task.id = ?1 and a.joinId = ?2")
    public TaskJoin findByTaskIdAndJoinId(Long taskId, Long joinId);
}
