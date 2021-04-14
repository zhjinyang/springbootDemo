package com.codeyancy.cn.utils.exception;

import com.codeyancy.cn.utils.http.EnumStatus;

/**
 * @author Zjy
 * @date 2021/4/13 11:45
 */
public class LoginException extends RuntimeException{
    private EnumStatus enumStatus;

    public LoginException(EnumStatus enumStatus) {
        this.enumStatus = enumStatus;
    }

    public EnumStatus getEnumStatus() {
        return enumStatus;
    }

    public void setEnumStatus(EnumStatus enumStatus) {
        this.enumStatus = enumStatus;
    }
}
