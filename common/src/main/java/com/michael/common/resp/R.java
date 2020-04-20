package com.michael.common.resp;

import java.io.Serializable;

public class R<T> implements Serializable {

    /**
     * 状态码
     */
    private int code;

    private T data;

    private String msg;


    private R(int code) {
        this(code, null, null);
    }

    private R(int code, String msg) {
        this(code, null, msg);
    }

    private R(int code, T data) {
        this(code, data, null);
    }

    private R(int code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public static <T> R<T> data(int code,T data,String msg) {
        return new R(code, data, data==null?"暂无数据":msg);
    }

    public static <T> R<T> data(int code,T data){
        return new R(code,data);
    }

    public static <T> R<T> data(T data,String msg){
        return data(200,data,msg);
    }

    public static  <T>  R<T> data(T data){
        return data(data,"操作成功");
    }

    public static <T> R<T> success(String msg){
        return new R(RespEnum.SUCCESS.getCode(),msg);
    }

    public static <T> R<T> success(RespEnum respEnum,String msg){
        return new R(respEnum.getCode(),msg);
    }

    public static <T> R<T> fail(String msg){
        return new R(RespEnum.FAIL.getCode(),msg);
    }


    public static <T> R<T> fail(RespEnum respEnum,String msg){
        return new R(respEnum.getCode(),msg);
    }


    public static <T> R<T> status(boolean flag){
        return flag==true?success("操作成功"):fail("操作失败");
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
