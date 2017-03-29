package com.foreks.chucknorrisjokes.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ozan on 29/03/17.
 */

public class RandomJokeResponse {

    @SerializedName("icon_url")
    @Expose
    private String iconUrl;
    @SerializedName("value")
    @Expose
    private String value;

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
