package com.j7arsen.postproject.utils.error;

import android.content.Context;

import com.j7arsen.postproject.R;
import com.j7arsen.postproject.utils.AppUtils;
import com.j7arsen.postproject.utils.ResUtils;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import retrofit2.HttpException;

public class ErrorHandler {

    private Context context;
    private String defaultMessage;
    private ResUtils resUtils;
    private AppUtils appUtils;

    public ErrorHandler(Context context, ResUtils resUtils, AppUtils appUtils) {
        this.context = context;
        this.resUtils = resUtils;
        this.appUtils = appUtils;
        this.defaultMessage = resUtils.getString(R.string.message_error_default);
    }

    public ErrorData getError(Throwable throwable) {
        if (throwable instanceof UnknownHostException || throwable instanceof ConnectException) {
            if (!appUtils.isNetworkAvailable(context)) {
                return new ErrorData(ErrorData.ERROR_NETWORK, resUtils.getString(R.string.message_error_connect));
            } else {
                return new ErrorData(ErrorData.ERROR_UNEXPECTED, defaultMessage);
            }
        } else if (throwable instanceof SocketTimeoutException) {
            return new ErrorData(ErrorData.ERROR_SOCKET_TIMEOUT, resUtils.getString(R.string.message_error_socket));
        } else if (throwable instanceof HttpException) {
            String message = null;
            if (((HttpException) throwable).response() != null) {
                if (((HttpException) throwable).response().message() != null) {
                    message = ((HttpException) throwable).response().code() + " " + ((HttpException) throwable).response().message();
                } else {
                    message = defaultMessage;
                }
            } else {
                message = defaultMessage;
            }
            return new ErrorData(ErrorData.ERROR_HTTP, message);
        } else {
            return new ErrorData(ErrorData.ERROR_UNEXPECTED, defaultMessage);
        }
    }

}
