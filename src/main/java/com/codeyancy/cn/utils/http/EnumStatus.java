package com.codeyancy.cn.utils.http;

/**
 * @author Zjy
 * @date 2021/4/12 21:37
 */
public enum EnumStatus {
    OK(2000,"操作成功"),
    ERROR(4000,"操作失败"),
    NO_EMPLOYEE(4001,"没有此员工"),
    CODE_ERROR(4002,"邮箱验证码不匹配"),
    CODE_TIMEOUT(4003,"邮箱验证码超时"),
    NO_LOGIN(4004,"未登录"),

    ;
    private int status;
    private String message;

    EnumStatus(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
