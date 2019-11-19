package com.j7arsen.data.model.net.person;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostPersonDataEntity {

    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("nickname")
    @Expose
    private String nickname;
    @SerializedName("active_gift")
    @Expose
    private String activeGift;
    @SerializedName("avatar_image")
    @Expose
    private PostPersonAvatarImage avatarImage;
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
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("is_subscribed")
    @Expose
    private boolean isSubscribed;
    @SerializedName("is_online")
    @Expose
    private boolean isOnline;
    @SerializedName("last_online_timestamp")
    @Expose
    private long lastOnlineTimestamp;
    @SerializedName("in_my_blacklist")
    @Expose
    private boolean inMyBlacklist;
    @SerializedName("has_me_in_blacklist")
    @Expose
    private boolean hasMeInBlacklist;
    @SerializedName("multiplier")
    @Expose
    private int multiplier;

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

    public String getActiveGift() {
        return activeGift;
    }

    public void setActiveGift(String activeGift) {
        this.activeGift = activeGift;
    }

    public PostPersonAvatarImage getAvatarImage() {
        return avatarImage;
    }

    public void setAvatarImage(PostPersonAvatarImage avatarImage) {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public long getLastOnlineTimestamp() {
        return lastOnlineTimestamp;
    }

    public void setLastOnlineTimestamp(long lastOnlineTimestamp) {
        this.lastOnlineTimestamp = lastOnlineTimestamp;
    }

    public boolean isInMyBlacklist() {
        return inMyBlacklist;
    }

    public void setInMyBlacklist(boolean inMyBlacklist) {
        this.inMyBlacklist = inMyBlacklist;
    }

    public boolean isHasMeInBlacklist() {
        return hasMeInBlacklist;
    }

    public void setHasMeInBlacklist(boolean hasMeInBlacklist) {
        this.hasMeInBlacklist = hasMeInBlacklist;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }
}
