package com.j7arsen.postproject.di.app.main;

import com.j7arsen.data.api.ITestApi;
import com.j7arsen.data.model.mapper.IObjectModelMapper;
import com.j7arsen.data.model.net.person.PostPersonEntity;
import com.j7arsen.data.model.net.post.PostEntity;
import com.j7arsen.data.repository.PostRepository;
import com.j7arsen.data.repository.mapper.PostDetailMapper;
import com.j7arsen.data.repository.mapper.PostPersonMapper;
import com.j7arsen.domain.model.person.PostPersonModel;
import com.j7arsen.domain.model.post.PostModel;
import com.j7arsen.domain.repository.IPostRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class MainRepositoryModule {

    @Provides
    @MainScope
    public IObjectModelMapper<PostEntity, PostModel> postDetailMapper() {
        return new PostDetailMapper();
    }

    @Provides
    @MainScope
    public IObjectModelMapper<PostPersonEntity, PostPersonModel> postPersonMapper() {
        return new PostPersonMapper();
    }

    @Provides
    @MainScope
    public IPostRepository providePostRepository(ITestApi apiService, IObjectModelMapper<PostEntity, PostModel> postDetailMapper, IObjectModelMapper<PostPersonEntity, PostPersonModel> postPersonMapper) {
        return new PostRepository(apiService, postDetailMapper, postPersonMapper);
    }

}
