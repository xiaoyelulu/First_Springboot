package com.example.service;

import com.example.pojo.Dept;
import com.example.pojo.Result;

import java.util.List;

/**
 * @author: zwy
 * @Project: JavaLaity
 * @Pcakage: com.example.service.DeptService
 * @Date: 2023年10月15日 19:12
 * @Description:
 */
public interface DeptService {
    /**
     *
     * @return
     */
    List<Dept> list();

    void delete(Integer id);

    void add(Dept dept);
}
