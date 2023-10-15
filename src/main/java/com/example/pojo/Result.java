package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: zwy
 * @Project: JavaLaity
 * @Pcakage: com.example.pojo.Result
 * @Date: 2023年10月15日 11:55
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer code;
    private String msg;
    private Object data;
    public static Result success(){
        return new Result(1, "success", null);
    }
    public static Result success(Object data){
        return new Result(1, "success", data);
    }

    public static Result error(String msg){
        return new Result(0, msg, null);
    }
}
