package com.j7arsen.postproject.utils.error;

import java.io.Serializable;

public class ErrorData implements Serializable {

    public static final int ERROR_NETWORK = 100001;
    public static final int ERROR_SOCKET_TIMEOUT = 100002;
    public static final int ERROR_UNEXPECTED = 100003;
    public static final int ERROR_HTTP = 100004;

    private int errorType;
    private int errorHttpCode;
    private int errorCode;
    private String errorMessage;

    public ErrorData(int errorType, String errorMessage) {
        this.errorType = errorType;
        this.errorMessage = errorMessage;
    }
    public ErrorData(int errorType, int errorHttpCode, String errorMessage) {
        this.errorType = errorType;
        this.errorHttpCode = errorHttpCode;
        this.errorMessage = errorMessage;
    }

    public ErrorData(int errorType, int errorHttpCode, int errorCode, String errorMessage) {
        this.errorType = errorType;
        this.errorHttpCode = errorHttpCode;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public int getErrorType() {
        return errorType;
    }

    public int getErrorHttpCode() {
        return errorHttpCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorType(int errorType) {
        this.errorType = errorType;
    }

    public void setErrorHttpCode(int errorHttpCode) {
        this.errorHttpCode = errorHttpCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
