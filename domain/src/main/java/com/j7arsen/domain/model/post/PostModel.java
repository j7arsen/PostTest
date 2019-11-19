package com.j7arsen.domain.model.post;

import java.io.Serializable;

public class PostModel implements Serializable {

    private long id;
    private String slug;
    private int type;
    private String createdAt;
    private long createdAtTimestamp;
    private String title;
    private long commentsCount;
    private long likesCount;
    private long bookmarksCount;
    private long repostsCount;
    private long viewsCount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public long getCreatedAtTimestamp() {
        return createdAtTimestamp;
    }

    public void setCreatedAtTimestamp(long createdAtTimestamp) {
        this.createdAtTimestamp = createdAtTimestamp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(long commentsCount) {
        this.commentsCount = commentsCount;
    }

    public long getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(long likesCount) {
        this.likesCount = likesCount;
    }

    public long getBookmarksCount() {
        return bookmarksCount;
    }

    public void setBookmarksCount(long bookmarksCount) {
        this.bookmarksCount = bookmarksCount;
    }

    public long getRepostsCount() {
        return repostsCount;
    }

    public void setRepostsCount(long repostsCount) {
        this.repostsCount = repostsCount;
    }

    public long getViewsCount() {
        return viewsCount;
    }

    public void setViewsCount(long viewsCount) {
        this.viewsCount = viewsCount;
    }
}
