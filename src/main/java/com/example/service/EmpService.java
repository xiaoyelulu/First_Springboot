package com.example.service;

import com.example.pojo.Emp;
import com.example.pojo.PageBean;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

/**
 * @author: zwy
 * @Project: JavaLaity
 * @Pcakage: com.example.service.EmpService
 * @Date: 2023年10月15日 19:13
 * @Description:
 */
public interface EmpService {
    PageBean page(Integer page, Integer pageSize,String name, Short gender,
                  LocalDate begin,
                  LocalDate end);

    void delete(List<Integer> ids);

    void save(Emp emp);
}
