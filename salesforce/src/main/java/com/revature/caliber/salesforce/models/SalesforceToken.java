package com.revature.caliber.salesforce.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Shehar on 1/19/2017.
 */
public class SalesforceToken {
    @JsonProperty(value = "access_token")
    private String accessToken;

    @JsonProperty(value = "refresh_token")
    private String refreshToken;

    @JsonProperty(value = "signature")
    private String signature;

    @JsonProperty(value = "scope")
    private String scope;

    @JsonProperty(value = "id_token")
    private String idToken;

    @JsonProperty(value = "instance_url")
    private String instanceUrl;

    @JsonProperty(value = "id")
    private String id;

    @JsonProperty(value = "token_type")
    private String tokenType;

    @JsonProperty(value = "issued_at")
    private String issuedAt;


    public SalesforceToken() {}

    public SalesforceToken(String accessToken, String signature, String scope, String instance_url, String id, String tokenType, String issuedAt) {
        this.accessToken = accessToken;
        this.signature = signature;
        this.scope = scope;
        this.instanceUrl = instance_url;
        this.id = id;
        this.tokenType = tokenType;
        this.issuedAt = issuedAt;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public String getInstanceUrl() {
        return instanceUrl;
    }

    public void setInstanceUrl(String instanceUrl) {
        this.instanceUrl = instanceUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(String issuedAt) {
        this.issuedAt = issuedAt;
    }

    @Override
    public String toString() {
        return "SalesforceToken{" +
                "accessToken='" + accessToken + '\'' +
                ", refreshToken='" + refreshToken + '\'' +
                ", signature='" + signature + '\'' +
                ", scope='" + scope + '\'' +
                ", idToken='" + idToken + '\'' +
                ", instanceUrl='" + instanceUrl + '\'' +
                ", id='" + id + '\'' +
                ", tokenType='" + tokenType + '\'' +
                ", issuedAt='" + issuedAt + '\'' +
                '}';
    }
}
