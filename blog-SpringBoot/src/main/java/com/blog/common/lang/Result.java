package com.blog.common.lang;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author 于立凯
 * @Description
 * @Date 2021年07月08日 15:08
 */
@Data
public class Result implements Serializable {

    private int code;//200正常，非200异常
    private String msg;
    private Object data;

    public static Result succ(int code,String msg,Object data){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);

        return result;
    }

    public static Result succ(Object data){
        return succ(200,"操作成功",data);
    }

    public static Result fail(int code,String msg,Object data){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);

        return result;
    }
    public static Result fail(String msg){
        return fail(400,msg,null);
    }
}
