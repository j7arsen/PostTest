package com.j7arsen.postproject.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.j7arsen.domain.model.post.PostModel;
import com.j7arsen.postproject.R;
import com.j7arsen.postproject.base.BaseActivity;
import com.j7arsen.postproject.di.ComponentManager;
import com.j7arsen.postproject.ui.block.base.BasePostBlock;
import com.j7arsen.postproject.ui.block.comment.PostCommentBlock;
import com.j7arsen.postproject.ui.block.data.BlockType;
import com.j7arsen.postproject.ui.block.like.PostLikeBlock;
import com.j7arsen.postproject.ui.block.mention.PostMentionBlock;
import com.j7arsen.postproject.ui.block.repost.PostRepostBlock;
import com.j7arsen.postproject.utils.ResUtils;
import com.j7arsen.postproject.utils.error.ErrorData;
import com.j7arsen.postproject.view.progress.ProgressView;

import javax.inject.Inject;

import butterknife.BindView;
import moxy.presenter.InjectPresenter;
import moxy.presenter.ProvidePresenter;

public class MainActivity extends BaseActivity implements IMainView {

    @BindView(R.id.navigation_bar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_title)
    TextView titleTextView;
    @BindView(R.id.tv_post_view_count)
    TextView tvPostViewCount;
    @BindView(R.id.ll_block_container)
    LinearLayout llBlockContainer;
    @BindView(R.id.sv_content)
    ScrollView svContent;
    @BindView(R.id.pv_load)
    ProgressView pvLoad;
    @BindView(R.id.b_post_like_persons)
    PostLikeBlock postLikeBlock;
    @BindView(R.id.b_post_comment_persons)
    PostCommentBlock postCommentBlock;
    @BindView(R.id.b_post_mention_persons)
    PostMentionBlock postMentionBlock;
    @BindView(R.id.b_post_repost_persons)
    PostRepostBlock postRepostBlock;

    @Inject
    ResUtils resUtils;

    @InjectPresenter
    MainPresenter presenter;

    @ProvidePresenter
    public MainPresenter createMainPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ComponentManager.getInstance().getMainComponent().inject(this);
        super.onCreate(savedInstanceState);
        initToolbar();
        setListeners();
        initDelegateForBlocks();
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            titleTextView.setText(resUtils.getString(R.string.screen_title));
        }
    }

    private void setListeners() {
        pvLoad.setOnRetryListener(() -> presenter.loadPostDetail());
    }

    private void initDelegateForBlocks() {
        postLikeBlock.init(getMvpDelegate());
        postCommentBlock.init(getMvpDelegate());
        postMentionBlock.init(getMvpDelegate());
        postRepostBlock.init(getMvpDelegate());
    }

    @Override
    public void showPostData(PostModel postModel) {
        if (postModel != null) {
            tvPostViewCount.setText(String.format(resUtils.getString(R.string.post_view_count), String.valueOf(postModel.getViewsCount())));
            if (!presenter.isInRestoreState(this)) {
                final int childCount = llBlockContainer.getChildCount();
                if (childCount != 0) {
                    for (int i = 0; i < childCount; i++) {
                        BasePostBlock basePostBlock = (BasePostBlock) llBlockContainer.getChildAt(i);
                        basePostBlock.loadBlock(getBlockInitCount(basePostBlock.getBlockType(), postModel));
                    }
                }
            }
        }
    }

    private long getBlockInitCount(BlockType blockType, PostModel postModel) {
        switch (blockType) {
            case LIKE:
                return postModel.getLikesCount();
            case COMMENT:
                return postModel.getCommentsCount();
            case MENTION:
                return postModel.getBookmarksCount();
            case REPOST:
                return postModel.getRepostsCount();
            default:
                return 0;
        }
    }

    @Override
    public void showProgress() {
        svContent.setVisibility(View.GONE);
        pvLoad.startLoading();
    }

    @Override
    public void hideProgress() {
        svContent.setVisibility(View.VISIBLE);
        pvLoad.completeLoading();
    }

    @Override
    public void showError(ErrorData errorData) {
        svContent.setVisibility(View.GONE);
        pvLoad.errorLoading(errorData.getErrorMessage());
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

}
