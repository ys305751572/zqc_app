package com.leoman.task.service;


import com.leoman.common.service.GenericManager;
import com.leoman.task.entity.Task;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;

/**
 * Created by Daisy on 2016/7/25.
 */
public interface TaskService extends GenericManager<Task> {

    public Page<Task> findAll(Task task, Integer currentPage, Integer pageSize);

    public void importXls(MultipartFile file) throws IOException, ParseException;

    public void exportXls(String outPath) throws Exception;

}
