package com.revature.caliber.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Salesforce user urls.
 */
public class SalesforceUserUrls {
    @JsonProperty
    private String enterprise;
    @JsonProperty
    private String metadata;
    @JsonProperty
    private String partner;
    @JsonProperty
    private String rest;
    @JsonProperty
    private String sobjects;
    @JsonProperty
    private String search;
    @JsonProperty
    private String query;
    @JsonProperty
    private String recent;
    @JsonProperty
    private String profile;
    @JsonProperty
    private String feeds;
    @JsonProperty
    private String groups;
    @JsonProperty
    private String users;
    @JsonProperty
    private String feed_items;
    @JsonProperty
    private String feed_elements;
    @JsonProperty
    private String custom_domain;

    /**
     * Instantiates a new Salesforce user urls.
     */
    public SalesforceUserUrls() {
    }

    /**
     * Gets enterprise.
     *
     * @return the enterprise
     */
    public String getEnterprise() {
        return enterprise;
    }

    /**
     * Sets enterprise.
     *
     * @param enterprise the enterprise
     */
    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }

    /**
     * Gets metadata.
     *
     * @return the metadata
     */
    public String getMetadata() {
        return metadata;
    }

    /**
     * Sets metadata.
     *
     * @param metadata the metadata
     */
    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    /**
     * Gets partner.
     *
     * @return the partner
     */
    public String getPartner() {
        return partner;
    }

    /**
     * Sets partner.
     *
     * @param partner the partner
     */
    public void setPartner(String partner) {
        this.partner = partner;
    }

    /**
     * Gets rest.
     *
     * @return the rest
     */
    public String getRest() {
        return rest;
    }

    /**
     * Sets rest.
     *
     * @param rest the rest
     */
    public void setRest(String rest) {
        this.rest = rest;
    }

    /**
     * Gets sobjects.
     *
     * @return the sobjects
     */
    public String getSobjects() {
        return sobjects;
    }

    /**
     * Sets sobjects.
     *
     * @param sobjects the sobjects
     */
    public void setSobjects(String sobjects) {
        this.sobjects = sobjects;
    }

    /**
     * Gets search.
     *
     * @return the search
     */
    public String getSearch() {
        return search;
    }

    /**
     * Sets search.
     *
     * @param search the search
     */
    public void setSearch(String search) {
        this.search = search;
    }

    /**
     * Gets query.
     *
     * @return the query
     */
    public String getQuery() {
        return query;
    }

    /**
     * Sets query.
     *
     * @param query the query
     */
    public void setQuery(String query) {
        this.query = query;
    }

    /**
     * Gets recent.
     *
     * @return the recent
     */
    public String getRecent() {
        return recent;
    }

    /**
     * Sets recent.
     *
     * @param recent the recent
     */
    public void setRecent(String recent) {
        this.recent = recent;
    }

    /**
     * Gets profile.
     *
     * @return the profile
     */
    public String getProfile() {
        return profile;
    }

    /**
     * Sets profile.
     *
     * @param profile the profile
     */
    public void setProfile(String profile) {
        this.profile = profile;
    }

    /**
     * Gets feeds.
     *
     * @return the feeds
     */
    public String getFeeds() {
        return feeds;
    }

    /**
     * Sets feeds.
     *
     * @param feeds the feeds
     */
    public void setFeeds(String feeds) {
        this.feeds = feeds;
    }

    /**
     * Gets groups.
     *
     * @return the groups
     */
    public String getGroups() {
        return groups;
    }

    /**
     * Sets groups.
     *
     * @param groups the groups
     */
    public void setGroups(String groups) {
        this.groups = groups;
    }

    /**
     * Gets users.
     *
     * @return the users
     */
    public String getUsers() {
        return users;
    }

    /**
     * Sets users.
     *
     * @param users the users
     */
    public void setUsers(String users) {
        this.users = users;
    }

    /**
     * Gets feed items.
     *
     * @return the feed items
     */
    public String getFeed_items() {
        return feed_items;
    }

    /**
     * Sets feed items.
     *
     * @param feed_items the feed items
     */
    public void setFeed_items(String feed_items) {
        this.feed_items = feed_items;
    }

    /**
     * Gets feed elements.
     *
     * @return the feed elements
     */
    public String getFeed_elements() {
        return feed_elements;
    }

    /**
     * Sets feed elements.
     *
     * @param feed_elements the feed elements
     */
    public void setFeed_elements(String feed_elements) {
        this.feed_elements = feed_elements;
    }

    /**
     * Gets custom domain.
     *
     * @return the custom domain
     */
    public String getCustom_domain() {
        return custom_domain;
    }

    /**
     * Sets custom domain.
     *
     * @param custom_domain the custom domain
     */
    public void setCustom_domain(String custom_domain) {
        this.custom_domain = custom_domain;
    }

    @Override
    public String toString() {
        return "SalesforceUserUrls{" +
                "enterprise='" + enterprise + '\'' +
                ", metadata='" + metadata + '\'' +
                ", partner='" + partner + '\'' +
                ", rest='" + rest + '\'' +
                ", sobjects='" + sobjects + '\'' +
                ", search='" + search + '\'' +
                ", query='" + query + '\'' +
                ", recent='" + recent + '\'' +
                ", profile='" + profile + '\'' +
                ", feeds='" + feeds + '\'' +
                ", groups='" + groups + '\'' +
                ", users='" + users + '\'' +
                ", feed_items='" + feed_items + '\'' +
                ", feed_elements='" + feed_elements + '\'' +
                ", custom_domain='" + custom_domain + '\'' +
                '}';
    }
}
