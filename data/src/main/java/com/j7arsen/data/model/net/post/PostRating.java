package com.j7arsen.data.model.net.post;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostRating {

    @SerializedName("level")
    @Expose
    private long level;
    @SerializedName("value")
    @Expose
    private long value;
    @SerializedName("caption")
    @Expose
    private long caption;
    @SerializedName("proportion")
    @Expose
    private double proportion;

    public long getLevel() {
        return level;
    }

    public void setLevel(long level) {
        this.level = level;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public long getCaption() {
        return caption;
    }

    public void setCaption(long caption) {
        this.caption = caption;
    }

    public double getProportion() {
        return proportion;
    }

    public void setProportion(double proportion) {
        this.proportion = proportion;
    }

}
