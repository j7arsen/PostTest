package com.j7arsen.data.model.net.post;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PostAttachments {

    @SerializedName("images")
    @Expose
    private List<PostImage> images;

    public List<PostImage> getImages() {
        return images;
    }

    public void setImages(List<PostImage> images) {
        this.images = images;
    }
}
