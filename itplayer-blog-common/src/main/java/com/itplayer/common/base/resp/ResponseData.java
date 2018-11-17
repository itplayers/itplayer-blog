package com.itplayer.common.base.resp;

import java.io.Serializable;

/**
 * @author caijun.yang
 * @date 2018/10/26
 */
public class ResponseData implements Serializable {

    private static final long serialVersionUID = -7735376359249727752L;

    public ResponseData() {
        this.code = 1;
        this.msg = "success";
    }

    public ResponseData(int code) {
        this.code = code;
    }

    public ResponseData(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 失败
     */
    public static final int ERROR = 0;
    /**
     * 成功
     */
    public static final int SUCCESS = 1;
    /**
     * 忽略失败，继续执行下一步
     */
    public static final int IGNORE_ERRO = 2;

    private int code = SUCCESS;
    private String msg;
    private Object data;

    public ResponseData putData(Object data) {
        setData(data);
        return this;
    }

    public static int getERROR() {
        return ERROR;
    }

    public static int getSUCCESS() {
        return SUCCESS;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseData{" + "code=" + code + ", msg='" + msg + '\'' + ", data=" + data + '}';
    }

}
