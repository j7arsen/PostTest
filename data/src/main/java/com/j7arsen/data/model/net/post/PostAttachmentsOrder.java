package com.j7arsen.data.model.net.post;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostAttachmentsOrder {

    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("type")
    @Expose
    private String type;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
