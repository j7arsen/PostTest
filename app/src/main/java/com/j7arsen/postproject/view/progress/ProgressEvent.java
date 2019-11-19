package com.j7arsen.postproject.view.progress;

import com.j7arsen.postproject.utils.error.ErrorData;

public class ProgressEvent {

    public static final int START_PROGRESS = 0;
    public static final int COMPLETE_PROGRESS = 1;
    public static final int ERROR_PROGRESS = 2;
    public static final int UNSUBSCRIBE = 3;

    private int mStatus;
    private String mErrorMessage;
    private ErrorData mErrorData;
    private ProgressDialog.OnButtonClickCallbackListener mOnButtonClickCallbackListener;

    public ProgressEvent(int mStatus) {
        this.mStatus = mStatus;
    }

    public ProgressEvent(int mStatus, ErrorData errorData) {
        this.mStatus = mStatus;
        this.mErrorData = errorData;
    }

    public ProgressEvent(int mStatus, String mErrorMessage) {
        this.mStatus = mStatus;
        this.mErrorMessage = mErrorMessage;
    }

    public ProgressEvent(int mStatus, ErrorData errorData, ProgressDialog.OnButtonClickCallbackListener mOnButtonClickCallbackListener) {
        this.mStatus = mStatus;
        this.mErrorData = errorData;
        this.mOnButtonClickCallbackListener = mOnButtonClickCallbackListener;
    }

    public ProgressEvent(int mStatus, String mErrorMessage, ProgressDialog.OnButtonClickCallbackListener onOkButtonClickCallbackListener) {
        this.mStatus = mStatus;
        this.mErrorMessage = mErrorMessage;
        this.mOnButtonClickCallbackListener = onOkButtonClickCallbackListener;
    }

    public int getStatus() {
        return mStatus;
    }

    public void setStatus(int mStatus) {
        this.mStatus = mStatus;
    }

    public String getErrorMessage() {
        return mErrorMessage;
    }

    public void setErrorMessage(String mErrorMessage) {
        this.mErrorMessage = mErrorMessage;
    }

    public ErrorData getErrorData() {
        return mErrorData;
    }

    public void setErrorData(ErrorData mErrorData) {
        this.mErrorData = mErrorData;
    }

    public ProgressDialog.OnButtonClickCallbackListener getOnButtonClickCallbackListener() {
        return mOnButtonClickCallbackListener;
    }

    public void setOnButtonClickCallbackListener(ProgressDialog.OnButtonClickCallbackListener mOnOkButtonClickCallbackListener) {
        this.mOnButtonClickCallbackListener = mOnOkButtonClickCallbackListener;
    }

}
