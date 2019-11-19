package com.j7arsen.postproject.view.progress;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.j7arsen.postproject.R;
import com.j7arsen.postproject.base.BaseDialogFragment;

import butterknife.BindView;
import butterknife.OnClick;

public class ProgressDialog extends BaseDialogFragment {

    public static final String TAG = "ProgressDialog.TAG";

    @BindView(R.id.pb_dialog_load)
    ProgressBar pbLoad;
    @BindView(R.id.iv_error_logo)
    ImageView ivErrorLogo;
    @BindView(R.id.tv_dialog_progress_error_title)
    TextView tvDialogProgressErrorTitle;
    @BindView(R.id.tv_dialog_progress_error)
    TextView tvDialogProgressError;
    @BindView(R.id.ll_dialog_progress_error)
    LinearLayout llDialogProgressError;
    @BindView(R.id.rl_dialog_progress)
    RelativeLayout rlDialogProgress;

    private String errorMessage;

    private int dialogId;

    private OnProgressDialogVisibleListener mOnProgressDialogVisibleListener;

    private OnButtonClickCallbackListener mOnButtonClickCallbackListener;

    public void setOnProgressDialogVisibleListener(OnProgressDialogVisibleListener onProgressDialogVisibleListener) {
        this.mOnProgressDialogVisibleListener = onProgressDialogVisibleListener;
    }

    public void setOnButtonClickCallbackListener(OnButtonClickCallbackListener oButtonClickCallbackListener) {
        this.mOnButtonClickCallbackListener = oButtonClickCallbackListener;
    }

    @Override
    protected int getLayout() {
        return R.layout.dialog_progress;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.setCanceledOnTouchOutside(false);
        if (mOnProgressDialogVisibleListener != null) {
            mOnProgressDialogVisibleListener.onProgressDialogVisible();
        }
        return dialog;
    }

    @OnClick({R.id.btn_progress_error_ok})
    void okClick(View view) {
        switch (view.getId()) {
            case R.id.btn_progress_error_ok:
                if (mOnButtonClickCallbackListener != null) {
                    mOnButtonClickCallbackListener.onButtonClick(dialogId);
                }
                break;
        }
    }

    public void startLoading() {
        setCancelable(false);
    }

    public void completeLoading() {
        setCancelable(true);
        pbLoad.setVisibility(View.GONE);
        rlDialogProgress.setVisibility(View.GONE);
        llDialogProgressError.setVisibility(View.GONE);
    }

    public void errorLoading(int dialogId, OnButtonClickCallbackListener onOkButtonClickCallbackListener, String errorMessage) {
        setCancelable(true);
        this.dialogId = dialogId;
        this.mOnButtonClickCallbackListener = onOkButtonClickCallbackListener;
        this.errorMessage = errorMessage;
        pbLoad.setVisibility(View.GONE);
        rlDialogProgress.setVisibility(View.VISIBLE);
        llDialogProgressError.setVisibility(View.VISIBLE);
        if (errorMessage != null) {
            tvDialogProgressError.setText(errorMessage);
        }
    }

    public interface OnButtonClickCallbackListener {
        void onButtonClick(int dialogId);
    }

    public interface OnProgressDialogVisibleListener {
        void onProgressDialogVisible();
    }
}
