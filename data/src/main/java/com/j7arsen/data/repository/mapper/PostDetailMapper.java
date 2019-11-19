package com.j7arsen.data.repository.mapper;

import com.j7arsen.data.model.mapper.IObjectModelMapper;
import com.j7arsen.data.model.net.post.PostEntity;
import com.j7arsen.domain.model.post.PostModel;

public class PostDetailMapper implements IObjectModelMapper<PostEntity, PostModel> {

    @Override
    public PostModel mapEntityToDomain(PostEntity postEntity) {
        PostModel postModel = new PostModel();
        postModel.setId(postEntity.getId());
        postModel.setCreatedAt(postEntity.getCreatedAt());
        postModel.setCreatedAtTimestamp(postEntity.getCreatedAtTimestamp());
        postModel.setTitle(postEntity.getTitle());
        postModel.setSlug(postEntity.getSlug());
        postModel.setRepostsCount(postEntity.getRepostsCount());
        postModel.setBookmarksCount(postEntity.getBookmarksCount());
        postModel.setCommentsCount(postEntity.getCommentsCount());
        postModel.setLikesCount(postEntity.getLikesCount());
        postModel.setViewsCount(postEntity.getViewsCount());
        postModel.setType(postEntity.getType());
        return postModel;
    }

    @Override
    public PostEntity mapDomainToEntity(PostModel postModel) {
        PostEntity postEntity = new PostEntity();
        postEntity.setId(postModel.getId());
        postEntity.setCreatedAt(postModel.getCreatedAt());
        postEntity.setCreatedAtTimestamp(postModel.getCreatedAtTimestamp());
        postEntity.setTitle(postModel.getTitle());
        postEntity.setSlug(postModel.getSlug());
        postEntity.setRepostsCount(postModel.getRepostsCount());
        postEntity.setBookmarksCount(postModel.getBookmarksCount());
        postEntity.setCommentsCount(postModel.getCommentsCount());
        postEntity.setLikesCount(postModel.getLikesCount());
        postEntity.setViewsCount(postModel.getViewsCount());
        postEntity.setType(postModel.getType());
        return postEntity;
    }
}
