package com.j7arsen.domain.repository;

import com.j7arsen.domain.model.person.PostPersonModel;
import com.j7arsen.domain.model.post.PostModel;

import io.reactivex.Single;

public interface IPostRepository {

    Single<PostModel> getDetailPost(String id);

    Single<PostPersonModel> getLikedPostPersons(String id);

    Single<PostPersonModel> getRepostedPostPersons(String id);

    Single<PostPersonModel> getCommentedPostPersons(String id);

    Single<PostPersonModel> getMentionedPostPersons(String id);

}
