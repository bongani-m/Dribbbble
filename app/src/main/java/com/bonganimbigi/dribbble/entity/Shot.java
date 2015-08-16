package com.bonganimbigi.dribbble.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Shot implements Serializable {

    private Long id;

    private String title;

    private String description;

    private String url;

    @SerializedName("views_count")
    private Long viewsCount;

    @SerializedName("image_url")
    private String imageUrl;

    @SerializedName("image_teaser_url")
    private String imageTeaserUrl;

    @SerializedName("image_400_url")
    private String image400Url;

    private Player player;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getViewsCount() {
        return viewsCount;
    }

    public void setViewsCount(Long viewsCount) {
        this.viewsCount = viewsCount;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageTeaserUrl() {
        return imageTeaserUrl;
    }

    public void setImageTeaserUrl(String imageTeaserUrl) {
        this.imageTeaserUrl = imageTeaserUrl;
    }

    public String getImage400Url() {
        return image400Url;
    }

    public void setImage400Url(String image400Url) {
        this.image400Url = image400Url;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
