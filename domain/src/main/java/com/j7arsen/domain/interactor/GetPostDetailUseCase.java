package com.j7arsen.domain.interactor;

import com.j7arsen.domain.executor.IThreadExecutor;
import com.j7arsen.domain.interactor.base.single.BaseSingleUseCaseWithParams;
import com.j7arsen.domain.model.post.PostModel;
import com.j7arsen.domain.repository.IPostRepository;

import io.reactivex.Single;

public class GetPostDetailUseCase extends BaseSingleUseCaseWithParams<PostModel, GetPostDetailUseCase.Params> {

    private IPostRepository postRepository;

    public GetPostDetailUseCase(IThreadExecutor threadExecutor, IPostRepository postRepository) {
        super(threadExecutor);
        this.postRepository = postRepository;
    }

    @Override
    public Single<PostModel> buildUseCase(GetPostDetailUseCase.Params params) {
        return postRepository.getDetailPost(params.id);
    }

    public static class Params {

        private String id;

        public Params(String id) {
            this.id = id;
        }

    }

}
