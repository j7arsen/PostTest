package com.j7arsen.data.api;

import com.j7arsen.data.BuildConfig;

public class Environment {

    public static final String BASE_URL = "https://api.inrating.top/";

    public static final String GET_DETAIL_POST = BASE_URL + "v" + BuildConfig.API_VERSION + "/" + "users/posts/get";
    public static final String GET_LIKED_POST_PERSONS = BASE_URL + "v" + BuildConfig.API_VERSION + "/" + "users/posts/likers/all";
    public static final String GET_REPOSTED_POST_PERSONS = BASE_URL + "v" + BuildConfig.API_VERSION + "/" + "users/posts/reposters/all";
    public static final String GET_COMMENTED_POST_PERSONS = BASE_URL + "v" + BuildConfig.API_VERSION + "/" + "users/posts/commentators/all";
    public static final String GET_MENTIONED_POST_PERSONS = BASE_URL + "v" + BuildConfig.API_VERSION + "/" + "users/posts/mentions/all";

}
