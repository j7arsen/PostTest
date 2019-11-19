package com.j7arsen.data.model.net.post;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostAuthor {

    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("nickname")
    @Expose
    private String nickname;
    @SerializedName("avatar_image")
    @Expose
    private PostAvatarImage avatarImage;
    @SerializedName("off_page")
    @Expose
    private boolean offPage;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("lastname")
    @Expose
    private String lastname;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("is_subscribed")
    @Expose
    private boolean isSubscribed;
    @SerializedName("is_online")
    @Expose
    private boolean isOnline;
    @SerializedName("rating")
    @Expose
    private PostRating rating;
    @SerializedName("comments")
    @Expose
    private String comments;
    @SerializedName("chat_main_lang")
    @Expose
    private String chatMainLang;
    @SerializedName("is_voted")
    @Expose
    private boolean isVoted;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public PostAvatarImage getAvatarImage() {
        return avatarImage;
    }

    public void setAvatarImage(PostAvatarImage avatarImage) {
        this.avatarImage = avatarImage;
    }

    public boolean isOffPage() {
        return offPage;
    }

    public void setOffPage(boolean offPage) {
        this.offPage = offPage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isSubscribed() {
        return isSubscribed;
    }

    public void setSubscribed(boolean subscribed) {
        isSubscribed = subscribed;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public PostRating getRating() {
        return rating;
    }

    public void setRating(PostRating rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getChatMainLang() {
        return chatMainLang;
    }

    public void setChatMainLang(String chatMainLang) {
        this.chatMainLang = chatMainLang;
    }

    public boolean isVoted() {
        return isVoted;
    }

    public void setVoted(boolean voted) {
        isVoted = voted;
    }
}
