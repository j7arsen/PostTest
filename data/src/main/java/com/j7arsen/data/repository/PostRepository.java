package com.j7arsen.data.repository;

import com.j7arsen.data.api.ITestApi;
import com.j7arsen.data.model.mapper.IObjectModelMapper;
import com.j7arsen.data.model.net.person.PostPersonEntity;
import com.j7arsen.data.model.net.post.PostEntity;
import com.j7arsen.domain.model.person.PostPersonModel;
import com.j7arsen.domain.model.post.PostModel;
import com.j7arsen.domain.repository.IPostRepository;

import io.reactivex.Single;

public class PostRepository implements IPostRepository {

    private ITestApi apiService;
    private IObjectModelMapper<PostEntity, PostModel> postMapper;
    private IObjectModelMapper<PostPersonEntity, PostPersonModel> postPersonMapper;

    public PostRepository(ITestApi apiService, IObjectModelMapper<PostEntity, PostModel> postMapper, IObjectModelMapper<PostPersonEntity, PostPersonModel> postPersonMapper) {
        this.apiService = apiService;
        this.postMapper = postMapper;
        this.postPersonMapper = postPersonMapper;
    }

    @Override
    public Single<PostModel> getDetailPost(String id) {
        return apiService.getDetailPost(id).map(data -> postMapper.mapEntityToDomain(data));
    }

    @Override
    public Single<PostPersonModel> getLikedPostPersons(String id) {
        return apiService.getLikedPostPersons(id).map(data -> postPersonMapper.mapEntityToDomain(data));
    }

    @Override
    public Single<PostPersonModel> getRepostedPostPersons(String id) {
        return apiService.getRepostedPostPersons(id).map(data -> postPersonMapper.mapEntityToDomain(data));
    }

    @Override
    public Single<PostPersonModel> getCommentedPostPersons(String id) {
        return apiService.getCommentedPostPersons(id).map(data -> postPersonMapper.mapEntityToDomain(data));
    }

    @Override
    public Single<PostPersonModel> getMentionedPostPersons(String id) {
        return apiService.getMentionedPostPersons(id).map(data -> postPersonMapper.mapEntityToDomain(data));
    }
}
