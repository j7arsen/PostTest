package com.j7arsen.postproject.ui;

import com.j7arsen.domain.interactor.GetPostDetailUseCase;
import com.j7arsen.domain.model.post.PostModel;
import com.j7arsen.postproject.BuildConfig;
import com.j7arsen.postproject.base.BasePresenter;
import com.j7arsen.postproject.di.ComponentManager;
import com.j7arsen.postproject.utils.error.ErrorHandler;

import javax.inject.Inject;

import io.reactivex.observers.DisposableSingleObserver;
import moxy.InjectViewState;

@InjectViewState
public class MainPresenter extends BasePresenter<IMainView> {

    @Inject
    ErrorHandler errorHandler;

    @Inject
    GetPostDetailUseCase getPostDetailUseCase;

    public MainPresenter() {
        ComponentManager.getInstance().getMainComponent().inject(this);
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        loadPostDetail();
    }

    public void loadPostDetail() {
        getPostDetailUseCase.execute(new GetPostDetailUseCase.Params(String.valueOf(BuildConfig.TEST_POST_ID)), new DisposableSingleObserver<PostModel>() {
            @Override
            protected void onStart() {
                getViewState().showProgress();
            }

            @Override
            public void onSuccess(PostModel postModel) {
                getViewState().showPostData(postModel);
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
        getPostDetailUseCase.dispose();
        ComponentManager.getInstance().destroyMainComponent();
        super.onDestroy();
    }
}
