package com.j7arsen.postproject.ui.block.comment;

import com.j7arsen.domain.interactor.GetCommentedPostPersonsUseCase;
import com.j7arsen.domain.model.person.PostPersonModel;
import com.j7arsen.postproject.BuildConfig;
import com.j7arsen.postproject.di.ComponentManager;
import com.j7arsen.postproject.ui.block.base.BasePostBlockPresenter;
import com.j7arsen.postproject.utils.error.ErrorHandler;

import javax.inject.Inject;

import io.reactivex.observers.DisposableSingleObserver;
import moxy.InjectViewState;

@InjectViewState
public class PostCommentBlockPresenter extends BasePostBlockPresenter<IPostCommentBlockView> {

    @Inject
    GetCommentedPostPersonsUseCase getCommentedPostPersonsUseCase;

    @Inject
    ErrorHandler errorHandler;

    public PostCommentBlockPresenter() {
        ComponentManager.getInstance().getMainComponent().inject(this);
    }

    @Override
    protected void loadBlock(long personsCount) {
        if (personsCount != 0) {
            reloadBlock();
        } else {
            getViewState().showPostPersonData(null);
        }
    }

    @Override
    protected void reloadBlock() {
        getCommentedPostPersonsUseCase.execute(new GetCommentedPostPersonsUseCase.Params(String.valueOf(BuildConfig.TEST_POST_ID)), new DisposableSingleObserver<PostPersonModel>() {
            @Override
            protected void onStart() {
                getViewState().showProgress();
            }

            @Override
            public void onSuccess(PostPersonModel postPersonModel) {
                getViewState().showPostPersonData(postPersonModel);
                getViewState().hideProgress();
            }

            @Override
            public void onError(Throwable e) {
                getViewState().showError(errorHandler.getError(e));
            }
        });
    }

    @Override
    public void onDestroy() {
        getCommentedPostPersonsUseCase.dispose();
        super.onDestroy();
    }
}
