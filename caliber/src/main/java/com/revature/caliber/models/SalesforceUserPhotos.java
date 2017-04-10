package com.revature.caliber.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Salesforce user photos.
 */
public class SalesforceUserPhotos {
    @JsonProperty
    private String picture;
    @JsonProperty
    private String thumbnail;

    /**
     * Instantiates a new Salesforce user photos.
     */
    public SalesforceUserPhotos() {
    }

    /**
     * Instantiates a new Salesforce user photos.
     *
     * @param picture   the picture
     * @param thumbnail the thumbnail
     */
    public SalesforceUserPhotos(String picture, String thumbnail) {
        this.picture = picture;
        this.thumbnail = thumbnail;
    }

    /**
     * Gets picture.
     *
     * @return the picture
     */
    public String getPicture() {
        return picture;
    }

    /**
     * Sets picture.
     *
     * @param picture the picture
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * Gets thumbnail.
     *
     * @return the thumbnail
     */
    public String getThumbnail() {
        return thumbnail;
    }

    /**
     * Sets thumbnail.
     *
     * @param thumbnail the thumbnail
     */
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return "SalesforceUserPhotos{" +
                "picture='" + picture + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                '}';
    }
}
