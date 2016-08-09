package com.leoman.task.service.impl;

import com.leoman.common.service.impl.GenericManagerImpl;
import com.leoman.task.dao.TaskDao;
import com.leoman.task.entity.Task;
import com.leoman.task.service.TaskService;
import com.leoman.utils.XlsUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daisy on 2016/7/25.
 */
@Service
@Transactional(readOnly = true)
public class TaskServiceImpl extends GenericManagerImpl<Task,TaskDao> implements TaskService {

    @Autowired
    private TaskDao taskDao;

    @Override
    public Page<Task> findAll(Task task, Integer currentPage, Integer pageSize){
        Specification<Task> spec = buildSpecification(task);
        return taskDao.findAll(spec, new PageRequest(currentPage-1, pageSize, Sort.Direction.ASC, "startDate"));
    }

    @Override
    @Transactional
    public void importXls(MultipartFile file) throws IOException, ParseException {
        Sheet sheet = XlsUtil.read(file,0);
        int i = 0;
        for (Row row : sheet) {
            if(i>0){
                Task task = new Task();
                for(Cell cell : row){
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                }
                task.setType(Integer.valueOf(row.getCell(0).getStringCellValue()));
                task.setName(row.getCell(1).getStringCellValue());
                task.setJoinType(Integer.valueOf(row.getCell(2).getStringCellValue()));
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                task.setStartDate(sdf.parse(row.getCell(3).getStringCellValue()).getTime());
                task.setEndDate(sdf.parse(row.getCell(4).getStringCellValue()).getTime());
                task.setAddress(row.getCell(5).getStringCellValue());
                taskDao.save(task);
            }
            i++;
        }
    }

    @Override
    public void exportXls(String outPath) throws Exception {
        XlsUtil.write(outPath);
    }

    public Specification<Task> buildSpecification(final Task task) {

        Specification<Task> sepc = new Specification<Task>() {
            @Override
            public Predicate toPredicate(Root<Task> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                try {
                    List<Predicate> predicateList = new ArrayList<Predicate>();
                    Predicate result = null;

                    BeanInfo beanInfo = Introspector.getBeanInfo(task.getClass());
                    PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
                    for (PropertyDescriptor property : propertyDescriptors) {
                        String key = property.getName();//字段名
                        Type type = property.getPropertyType();//字段类型

                        // 过滤class属性
                        if (!key.equals("class")) {
                            // 得到property对应的getter方法
                            Method getter = property.getReadMethod();
                            Object value = getter.invoke(task);

                            if(value != null){
                                //字符串用like拼接
                                if(type.equals(String.class) && !StringUtils.isEmpty(value)){
                                    Predicate predicate = cb.like(root.get(key).as(String.class), "%"+value+"%");
                                    predicateList.add(predicate);
                                }else if(type.equals(Long.class)){
                                    Predicate predicate = cb.equal(root.get(key).as(Long.class), value);
                                    predicateList.add(predicate);
                                }else if(type.equals(Integer.class)){
                                    Predicate predicate = cb.equal(root.get(key).as(Integer.class), value);
                                    predicateList.add(predicate);
                                }
                                //如果字段为type时
                                else if("type".equals(key)){
                                    //益起来任务，则只筛选未过期的任务
                                    if(value.toString().equals(1)){
                                        Predicate predicate = cb.gt(root.get("startDate").as(Long.class), System.currentTimeMillis());
                                        predicateList.add(predicate);
                                    }
                                }
                            }
                        }
                    }
                    if (predicateList.size() > 0) {
                        result = cb.and(predicateList.toArray(new Predicate[]{}));
                    }
                    if (result != null) {
                        query.where(result);
                    }
                } catch (IntrospectionException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                return query.getRestriction();
            }
        };
        return sepc;
    }
}
