package com.example.controller;

import com.example.pojo.Emp;
import com.example.pojo.PageBean;
import com.example.pojo.Result;
import com.example.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * @author: zwy
 * @Project: JavaLaity
 * @Pcakage: com.example.controller.EmpController
 * @Date: 2023年10月15日 21:15
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;
//    @GetMapping("emps")
//    public Result page(@RequestParam(defaultValue = "1") Integer page,
//                       @RequestParam(defaultValue = "10") Integer pageSize){
//        log.info("page:{}, pageSize:{}", page, pageSize);
//        PageBean pageBean = empService.page(page, pageSize);
//        return Result.success(pageBean);
//
//    }

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                        @RequestParam(defaultValue = "10") Integer pageSize,
                        String name, Short gender,
                        @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                        @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
        log.info("page:{}, pageSize:{},{},{}", page, pageSize, begin, end);
        PageBean pageBean = empService.page(page, pageSize, name, gender, begin, end);
        return Result.success(pageBean);

    }

    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("批量删除操作：{}", ids);
        empService.delete(ids);
        return Result.success();
    }

    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("新增员工，emp:{}", emp);
        empService.save(emp);
        return Result.success();
    }

}
