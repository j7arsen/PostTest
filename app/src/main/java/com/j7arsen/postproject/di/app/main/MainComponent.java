package com.j7arsen.postproject.di.app.main;

import com.j7arsen.postproject.ui.MainActivity;
import com.j7arsen.postproject.ui.MainPresenter;
import com.j7arsen.postproject.ui.block.comment.PostCommentBlockPresenter;
import com.j7arsen.postproject.ui.block.like.PostLikeBlockPresenter;
import com.j7arsen.postproject.ui.block.mention.PostMentionBlockPresenter;
import com.j7arsen.postproject.ui.block.repost.PostRepostBlockPresenter;

import dagger.Subcomponent;

@MainScope
@Subcomponent(modules = {MainRepositoryModule.class, MainUseCaseModule.class})
public interface MainComponent {

    void inject(MainActivity mainActivity);

    void inject(MainPresenter mainPresenter);

    void inject(PostLikeBlockPresenter postLikeBlockPresenter);

    void inject(PostRepostBlockPresenter postRepostBlockPresenter);

    void inject(PostCommentBlockPresenter postCommentBlockPresenter);

    void inject(PostMentionBlockPresenter postMentionBlockPresenter);

    @Subcomponent.Builder
    interface Builder {
        MainComponent build();
    }

}
