package com.itplayer.common.base.controller;

import com.itplayer.common.base.resp.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author caijun.yang
 * @date 2018/10/26
 */
public abstract class BaseController {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    protected ResponseData success() {
        return new ResponseData();
    }

    protected ResponseData success(Object data) {
    	
        return new ResponseData().putData(data);
    }
    
    protected ResponseData success(int code, String msg, Object data) {
    	ResponseData responseData = new ResponseData();
    	responseData.setCode(code);
    	responseData.setMsg(msg);
        return responseData.putData(data);
    }
    
    protected ResponseData success(int code, String msg) {
    	ResponseData responseData = new ResponseData();
    	responseData.setCode(code);
    	responseData.setMsg(msg);
        return responseData;
    }
    
    protected ResponseData failed(String erroMsg) {
        return new ResponseData(ResponseData.ERROR, erroMsg);
    }

    protected ResponseData failed() {
        return new ResponseData(ResponseData.ERROR);
    }

    protected ResponseData ignoreFailed() {
        return new ResponseData(ResponseData.IGNORE_ERRO);
    }

    protected ResponseData ignoreFailed(String erroMsg) {
        return new ResponseData(ResponseData.IGNORE_ERRO, erroMsg);
    }

}
