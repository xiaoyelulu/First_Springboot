package com.example.controller;

import com.example.pojo.Dept;
import com.example.pojo.Result;
import com.example.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: zwy
 * @Project: JavaLaity
 * @Pcakage: com.example.controller.DeptController
 * @Date: 2023年10月15日 11:22
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
    // @RequestMapping(value = "/depts", method = RequestMethod.GET)
    @Autowired
    private DeptService deptService;
    @GetMapping
    public Result list(){
        log.info("查询全部部门数据");
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("根据 id 删除部门：{}", id);
        deptService.delete(id);
        return Result.success();
    }
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("添加部门数据:{}", dept);
        deptService.add(dept);
        return Result.success();
    }
}
