package com.j7arsen.domain.interactor;

import com.j7arsen.domain.executor.IThreadExecutor;
import com.j7arsen.domain.interactor.base.single.BaseSingleUseCaseWithParams;
import com.j7arsen.domain.model.person.PostPersonModel;
import com.j7arsen.domain.repository.IPostRepository;

import io.reactivex.Single;

public class GetLikedPostPersonsUseCase extends BaseSingleUseCaseWithParams<PostPersonModel, GetLikedPostPersonsUseCase.Params> {

    private IPostRepository postRepository;

    public GetLikedPostPersonsUseCase(IThreadExecutor threadExecutor, IPostRepository postRepository) {
        super(threadExecutor);
        this.postRepository = postRepository;
    }

    @Override
    public Single<PostPersonModel> buildUseCase(GetLikedPostPersonsUseCase.Params params) {
        return postRepository.getLikedPostPersons(params.id);
    }

    public static class Params {

        private String id;

        public Params(String id) {
            this.id = id;
        }

    }
}
