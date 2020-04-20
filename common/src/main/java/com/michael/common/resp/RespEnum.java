package com.michael.common.resp;

public enum RespEnum {
    SUCCESS(200,"成功"),
    FAIL(400,"失败");

    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    RespEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
