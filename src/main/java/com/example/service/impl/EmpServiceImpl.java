package com.example.service.impl;

import com.example.mapper.EmpMapper;
import com.example.pojo.Emp;
import com.example.pojo.PageBean;
import com.example.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: zwy
 * @Project: JavaLaity
 * @Pcakage: com.example.service.impl.EmpServiceImpl
 * @Date: 2023年10月15日 19:14
 * @Description:
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
//    @Override
//    public PageBean page(Integer page, Integer pageSize) {
//        Long count = empMapper.count();
//        List<Emp> empList = empMapper.page((page - 1) * pageSize, pageSize);
//        PageBean pageBean = new PageBean(count, empList);
//        return pageBean;
//    }
    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short gender,
                         LocalDate begin,
                         LocalDate end) {
        // 1. 设置分页参数
        PageHelper.startPage(page, pageSize);

        List<Emp> empList = empMapper.list(name, gender, begin, end);
        Page<Emp> p = (Page<Emp>) empList;
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
    }
}
