package com.j7arsen.data.api;

import com.j7arsen.data.model.net.person.PostPersonEntity;
import com.j7arsen.data.model.net.post.PostEntity;

import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ITestApi {

    @FormUrlEncoded
    @POST(Environment.GET_DETAIL_POST)
    Single<PostEntity> getDetailPost(@Field(RequestField.ID) String id);

    @FormUrlEncoded
    @POST(Environment.GET_LIKED_POST_PERSONS)
    Single<PostPersonEntity> getLikedPostPersons(@Field(RequestField.ID) String id);

    @FormUrlEncoded
    @POST(Environment.GET_REPOSTED_POST_PERSONS)
    Single<PostPersonEntity> getRepostedPostPersons(@Field(RequestField.ID) String id);

    @FormUrlEncoded
    @POST(Environment.GET_COMMENTED_POST_PERSONS)
    Single<PostPersonEntity> getCommentedPostPersons(@Field(RequestField.ID) String id);

    @FormUrlEncoded
    @POST(Environment.GET_MENTIONED_POST_PERSONS)
    Single<PostPersonEntity> getMentionedPostPersons(@Field(RequestField.ID) String id);

}
