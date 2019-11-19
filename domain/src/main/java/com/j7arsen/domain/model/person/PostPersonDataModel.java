package com.j7arsen.domain.model.person;

import java.io.Serializable;

public class PostPersonDataModel implements Serializable {

    private long id;
    private String nickname;
    private String activeGift;
    private PostPersonAvatarImageModel avatarImage;
    private boolean offPage;
    private String name;
    private String lastname;
    private String status;
    private String gender;
    private boolean isSubscribed;
    private boolean isOnline;
    private long lastOnlineTimestamp;
    private boolean inMyBlacklist;
    private boolean hasMeInBlacklist;
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

    public PostPersonAvatarImageModel getAvatarImage() {
        return avatarImage;
    }

    public void setAvatarImage(PostPersonAvatarImageModel avatarImage) {
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
