package com.zyt.api.context;

/**
 * Created by zhuyintao.
 * Date: 2018/9/23
 */
public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = -6131985319050460519L;
    private Integer errorCode;

    public Integer getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public ServiceException(String errorMsg) {
        super(errorMsg);
        this.errorCode = Constants.FAILURE_CODE;
    }

    public ServiceException(String errorMsg, Integer errorCode) {
        super(errorMsg);
        this.errorCode = errorCode;
    }
}
