package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: zwy
 * @Project: JavaLaity
 * @Pcakage: com.example.pojo.PageBean
 * @Date: 2023年10月15日 21:08
 * @Description:分页查询结果封装类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {
    private Long total; // 总记录数
    private List rows; // 结果
}
