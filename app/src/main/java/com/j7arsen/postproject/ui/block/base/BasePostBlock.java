package com.j7arsen.postproject.ui.block.base;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.j7arsen.postproject.R;
import com.j7arsen.postproject.ui.block.adapter.PostPersonsAdapter;
import com.j7arsen.postproject.ui.block.data.BlockType;

import moxy.MvpDelegate;

public abstract class BasePostBlock extends FrameLayout {

    protected View rootContainer;
    protected ImageView ivPostBlockIcon;
    protected TextView tvPostBlockTitle;
    protected ProgressBar pbPostBlockLoad;
    protected TextView tvPostBlockError;
    protected ImageView ivPostBlockRetry;
    protected RecyclerView rvPostPersons;

    private MvpDelegate parentDelegate;
    private MvpDelegate<BasePostBlock> mvpDelegate;

    protected PostPersonsAdapter postPersonsAdapter;

    public BasePostBlock(@NonNull Context context) {
        super(context);
        initView(context);
    }

    public BasePostBlock(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public BasePostBlock(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public BasePostBlock(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        rootContainer = inflater.inflate(R.layout.view_post_block, this);
        ivPostBlockIcon = rootContainer.findViewById(R.id.iv_post_block_icon);
        tvPostBlockTitle = rootContainer.findViewById(R.id.tv_post_block_title);
        pbPostBlockLoad = rootContainer.findViewById(R.id.pb_block_load);
        tvPostBlockError = rootContainer.findViewById(R.id.tv_post_block_error);
        ivPostBlockRetry = rootContainer.findViewById(R.id.iv_block_retry);
        rvPostPersons = rootContainer.findViewById(R.id.rv_post_persons);
        ivPostBlockRetry.setOnClickListener(view -> reloadBlock());
        initAdapters(context);
        initBlockTitle();
    }

    private void initAdapters(Context context) {
        postPersonsAdapter = new PostPersonsAdapter();
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        rvPostPersons.setLayoutManager(horizontalLayoutManager);
        rvPostPersons.setAdapter(postPersonsAdapter);
    }

    public void init(MvpDelegate parentDelegate) {
        this.parentDelegate = parentDelegate;
        getMvpDelegate().onCreate();
        getMvpDelegate().onAttach();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getMvpDelegate().onSaveInstanceState();
        getMvpDelegate().onDetach();
    }

    public MvpDelegate<BasePostBlock> getMvpDelegate() {
        if (mvpDelegate != null) {
            return mvpDelegate;
        }
        mvpDelegate = new MvpDelegate<>(this);
        mvpDelegate.setParentDelegate(parentDelegate, String.valueOf(getId()));
        return mvpDelegate;
    }

    protected void startLoading() {
        initBlockTitle();
        tvPostBlockError.setText("");
        tvPostBlockError.setVisibility(GONE);
        ivPostBlockRetry.setVisibility(GONE);
        tvPostBlockTitle.setVisibility(VISIBLE);
        ivPostBlockIcon.setVisibility(VISIBLE);
        pbPostBlockLoad.setVisibility(VISIBLE);
    }

    protected void completeLoading() {
        tvPostBlockError.setVisibility(GONE);
        ivPostBlockRetry.setVisibility(GONE);
        pbPostBlockLoad.setVisibility(GONE);
        tvPostBlockTitle.setVisibility(VISIBLE);
        ivPostBlockIcon.setVisibility(VISIBLE);
    }

    protected void errorLoading(String errorMessage) {
        tvPostBlockTitle.setVisibility(GONE);
        ivPostBlockIcon.setVisibility(GONE);
        pbPostBlockLoad.setVisibility(GONE);
        tvPostBlockError.setVisibility(VISIBLE);
        tvPostBlockError.setText(errorMessage);
        ivPostBlockRetry.setVisibility(VISIBLE);
    }

    protected void emptyBlock() {
        String currentTitle = tvPostBlockTitle.getText().toString();
        tvPostBlockTitle.setText(currentTitle + 0);
        rvPostPersons.setVisibility(GONE);
    }

    public abstract void reloadBlock();

    public abstract void loadBlock(long personsCount);

    public abstract BlockType getBlockType();

    protected abstract void initBlockTitle();

}
