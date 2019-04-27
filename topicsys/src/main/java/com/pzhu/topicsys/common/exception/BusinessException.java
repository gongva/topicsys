package com.pzhu.topicsys.common.exception;

/**
 * Desc:业务异常
 *
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = -3876502758804606346L;

    private Integer code;

    public BusinessException() {
    }

    public BusinessException(String message) {
        this(ErrorCode.ERROR_CODE_BUSINESS, message);
    }

    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(String message, Throwable th) {
        super(message, th);
    }

    public BusinessException(Integer code, String message, Throwable th) {
        super(message, th);
        this.code = code;
    }

    public BusinessException(Throwable th) {
        super(th);
    }

    public String getMessage() {
        return super.getMessage();
    }

    public Integer getCode() {
        if (code == null) {
            return -1;
        }
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}