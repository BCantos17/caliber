package com.revature.caliber.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Salesforce user status.
 */
public class SalesforceUserStatus {
    @JsonProperty
    private String created_date;
    @JsonProperty
    private String body;

    /**
     * Instantiates a new Salesforce user status.
     */
    public SalesforceUserStatus() {
    }

    /**
     * Instantiates a new Salesforce user status.
     *
     * @param created_date the created date
     * @param body         the body
     */
    public SalesforceUserStatus(String created_date, String body) {
        this.created_date = created_date;
        this.body = body;
    }

    /**
     * Gets created date.
     *
     * @return the created date
     */
    public String getCreated_date() {
        return created_date;
    }

    /**
     * Sets created date.
     *
     * @param created_date the created date
     */
    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    /**
     * Gets body.
     *
     * @return the body
     */
    public String getBody() {
        return body;
    }

    /**
     * Sets body.
     *
     * @param body the body
     */
    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "SalesforceUserStatus{" +
                "created_date='" + created_date + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
