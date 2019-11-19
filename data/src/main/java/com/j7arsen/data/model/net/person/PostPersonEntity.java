package com.j7arsen.data.model.net.person;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PostPersonEntity {

    @SerializedName("data")
    @Expose
    private List<PostPersonDataEntity> data;
    @SerializedName("links")
    @Expose
    private PostPersonLinks links;
    @SerializedName("meta")
    @Expose
    private PostPersonMeta meta;

    public List<PostPersonDataEntity> getData() {
        return data;
    }

    public void setData(List<PostPersonDataEntity> data) {
        this.data = data;
    }

    public PostPersonLinks getLinks() {
        return links;
    }

    public void setLinks(PostPersonLinks links) {
        this.links = links;
    }

    public PostPersonMeta getMeta() {
        return meta;
    }

    public void setMeta(PostPersonMeta meta) {
        this.meta = meta;
    }
}
