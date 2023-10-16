package com.example.mapper;

import com.example.pojo.Emp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: zwy
 * @Project: JavaLaity
 * @Pcakage: com.example.mapper.EmpMapper
 * @Date: 2023年10月15日 19:21
 * @Description:
 */

@Mapper
public interface EmpMapper {
//    @Select("select count(*) from emp")
//    public Long count();
//
//    @Select("select * from emp limit #{start}, #{pageSize}")
//    public List<Emp> page(Integer start, Integer pageSize);
    //@Select("select * from emp")
    public List<Emp> list(String name, Short gender,
                          LocalDate begin,
                          LocalDate end);

    void delete(List<Integer> ids);

    @Insert("insert into emp (username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
            "values (#{username}, #{name}, #{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);
}
