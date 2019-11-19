package com.j7arsen.postproject.ui.block.comment;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.j7arsen.domain.model.person.PostPersonModel;
import com.j7arsen.postproject.R;
import com.j7arsen.postproject.ui.block.base.BasePostBlock;
import com.j7arsen.postproject.ui.block.data.BlockType;
import com.j7arsen.postproject.utils.error.ErrorData;

import moxy.presenter.InjectPresenter;

public class PostCommentBlock extends BasePostBlock implements IPostCommentBlockView {

    @InjectPresenter
    PostCommentBlockPresenter presenter;

    public PostCommentBlock(@NonNull Context context) {
        super(context);
    }

    public PostCommentBlock(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PostCommentBlock(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PostCommentBlock(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void showProgress() {
        startLoading();
    }

    @Override
    public void hideProgress() {
        completeLoading();
    }

    @Override
    public void showError(ErrorData errorData) {
        errorLoading(errorData.getErrorMessage());
    }

    @Override
    public void showPostPersonData(PostPersonModel postPersonModel) {
        if (postPersonModel != null) {
            if (postPersonModel.getData() != null && postPersonModel.getData().size() != 0) {
                tvPostBlockTitle.setText(String.format(getResources().getString(R.string.post_comment_count), String.valueOf(postPersonModel.getData().size())));
                postPersonsAdapter.setData(postPersonModel.getData());
            } else {
                emptyBlock();
            }
        } else {
            emptyBlock();
        }
    }

    @Override
    protected void initBlockTitle() {
        ivPostBlockIcon.setBackgroundResource(android.R.drawable.ic_btn_speak_now);
        tvPostBlockTitle.setText(String.format(getResources().getString(R.string.post_comment_count), new String()));
    }

    @Override
    public void reloadBlock() {
        presenter.reloadBlock();
    }

    @Override
    public void loadBlock(long personsCount) {
        presenter.loadBlock(personsCount);
    }

    @Override
    public BlockType getBlockType() {
        return BlockType.COMMENT;
    }
}
