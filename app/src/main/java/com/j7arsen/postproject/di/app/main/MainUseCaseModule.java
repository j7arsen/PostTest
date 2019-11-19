package com.j7arsen.postproject.di.app.main;

import com.j7arsen.domain.executor.IThreadExecutor;
import com.j7arsen.domain.interactor.GetCommentedPostPersonsUseCase;
import com.j7arsen.domain.interactor.GetLikedPostPersonsUseCase;
import com.j7arsen.domain.interactor.GetMentionedPostPersonsUseCase;
import com.j7arsen.domain.interactor.GetPostDetailUseCase;
import com.j7arsen.domain.interactor.GetRepostedPostPersonsUseCase;
import com.j7arsen.domain.repository.IPostRepository;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class MainUseCaseModule {

    @Provides
    @MainScope
    public GetPostDetailUseCase getPostDetailUseCase(IPostRepository postRepository, @Named("io_main_background") IThreadExecutor threadExecutor) {
        return new GetPostDetailUseCase(threadExecutor, postRepository);
    }

    @Provides
    @MainScope
    public GetLikedPostPersonsUseCase getLikedPostPersonsUseCase(IPostRepository postRepository, @Named("io_main_background") IThreadExecutor threadExecutor) {
        return new GetLikedPostPersonsUseCase(threadExecutor, postRepository);
    }

    @Provides
    @MainScope
    public GetRepostedPostPersonsUseCase getRepostedPostPersonsUseCase(IPostRepository postRepository, @Named("io_main_background") IThreadExecutor threadExecutor) {
        return new GetRepostedPostPersonsUseCase(threadExecutor, postRepository);
    }

    @Provides
    @MainScope
    public GetCommentedPostPersonsUseCase getCommentedPostPersonsUseCase(IPostRepository postRepository, @Named("io_main_background") IThreadExecutor threadExecutor) {
        return new GetCommentedPostPersonsUseCase(threadExecutor, postRepository);
    }

    @Provides
    @MainScope
    public GetMentionedPostPersonsUseCase getMentionedPostPersonsUseCase(IPostRepository postRepository, @Named("io_main_background") IThreadExecutor threadExecutor) {
        return new GetMentionedPostPersonsUseCase(threadExecutor, postRepository);
    }

}
