package com.bonganimbigi.dribbble.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Player implements Serializable {

    private Long id;

    private String name;

    @SerializedName("avatar_url")
    private String avatarUrl;

    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
