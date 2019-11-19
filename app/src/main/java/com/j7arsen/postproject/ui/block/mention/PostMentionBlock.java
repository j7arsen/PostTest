package com.j7arsen.postproject.ui.block.mention;

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

public class PostMentionBlock extends BasePostBlock implements IPostMentionBlockView {

    @InjectPresenter
    PostMentionBlockPresenter presenter;

    public PostMentionBlock(@NonNull Context context) {
        super(context);
    }

    public PostMentionBlock(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PostMentionBlock(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PostMentionBlock(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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
                tvPostBlockTitle.setText(String.format(getResources().getString(R.string.post_mention_count), String.valueOf(postPersonModel.getData().size())));
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
        ivPostBlockIcon.setBackgroundResource(android.R.drawable.ic_delete);
        tvPostBlockTitle.setText(String.format(getResources().getString(R.string.post_mention_count), new String()));
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
        return BlockType.MENTION;
    }
}
