package com.j7arsen.data.model.net.post;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PostEntity {

    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("type")
    @Expose
    private int type;
    @SerializedName("allow_comments")
    @Expose
    private boolean allowComments;
    @SerializedName("active")
    @Expose
    private boolean active;
    @SerializedName("author")
    @Expose
    private PostAuthor author;
    @SerializedName("attachments")
    @Expose
    private PostAttachments attachments;
    @SerializedName("site_link")
    @Expose
    private String siteLink;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("created_at_timestamp")
    @Expose
    private long createdAtTimestamp;
    @SerializedName("is_repost")
    @Expose
    private boolean isRepost;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("attachments_order")
    @Expose
    private List<PostAttachmentsOrder> attachmentsOrder;
    @SerializedName("is_liked")
    @Expose
    private boolean isLiked;
    @SerializedName("comments_count")
    @Expose
    private long commentsCount;
    @SerializedName("likes_count")
    @Expose
    private long likesCount;
    @SerializedName("visibility")
    @Expose
    private String visibility;
    @SerializedName("is_avatar")
    @Expose
    private boolean isAvatar;
    @SerializedName("is_bookmarked")
    @Expose
    private boolean isBookmarked;
    @SerializedName("is_reposted")
    @Expose
    private boolean isReposted;
    @SerializedName("bookmarks_count")
    @Expose
    private long bookmarksCount;
    @SerializedName("reposts_count")
    @Expose
    private long repostsCount;
    @SerializedName("views_count")
    @Expose
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

    public boolean isAllowComments() {
        return allowComments;
    }

    public void setAllowComments(boolean allowComments) {
        this.allowComments = allowComments;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public PostAuthor getAuthor() {
        return author;
    }

    public void setAuthor(PostAuthor author) {
        this.author = author;
    }

    public PostAttachments getAttachments() {
        return attachments;
    }

    public void setAttachments(PostAttachments attachments) {
        this.attachments = attachments;
    }

    public String getSiteLink() {
        return siteLink;
    }

    public void setSiteLink(String siteLink) {
        this.siteLink = siteLink;
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

    public boolean isRepost() {
        return isRepost;
    }

    public void setRepost(boolean repost) {
        isRepost = repost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<PostAttachmentsOrder> getAttachmentsOrder() {
        return attachmentsOrder;
    }

    public void setAttachmentsOrder(List<PostAttachmentsOrder> attachmentsOrder) {
        this.attachmentsOrder = attachmentsOrder;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
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

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public boolean isAvatar() {
        return isAvatar;
    }

    public void setAvatar(boolean avatar) {
        isAvatar = avatar;
    }

    public boolean isBookmarked() {
        return isBookmarked;
    }

    public void setBookmarked(boolean bookmarked) {
        isBookmarked = bookmarked;
    }

    public boolean isReposted() {
        return isReposted;
    }

    public void setReposted(boolean reposted) {
        isReposted = reposted;
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
