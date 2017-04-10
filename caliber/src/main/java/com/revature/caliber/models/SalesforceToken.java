package com.revature.caliber.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Salesforce token.
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


    /**
     * Instantiates a new Salesforce token.
     */
    public SalesforceToken() {
    }

    /**
     * Instantiates a new Salesforce token.
     *
     * @param accessToken  the access token
     * @param signature    the signature
     * @param scope        the scope
     * @param instance_url the instance url
     * @param id           the id
     * @param tokenType    the token type
     * @param issuedAt     the issued at
     */
    public SalesforceToken(String accessToken, String signature, String scope, String instance_url, String id, String tokenType, String issuedAt) {
        this.accessToken = accessToken;
        this.signature = signature;
        this.scope = scope;
        this.instanceUrl = instance_url;
        this.id = id;
        this.tokenType = tokenType;
        this.issuedAt = issuedAt;
    }

    /**
     * Gets access token.
     *
     * @return the access token
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * Sets access token.
     *
     * @param accessToken the access token
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * Gets refresh token.
     *
     * @return the refresh token
     */
    public String getRefreshToken() {
        return refreshToken;
    }

    /**
     * Sets refresh token.
     *
     * @param refreshToken the refresh token
     */
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    /**
     * Gets signature.
     *
     * @return the signature
     */
    public String getSignature() {
        return signature;
    }

    /**
     * Sets signature.
     *
     * @param signature the signature
     */
    public void setSignature(String signature) {
        this.signature = signature;
    }

    /**
     * Gets scope.
     *
     * @return the scope
     */
    public String getScope() {
        return scope;
    }

    /**
     * Sets scope.
     *
     * @param scope the scope
     */
    public void setScope(String scope) {
        this.scope = scope;
    }

    /**
     * Gets id token.
     *
     * @return the id token
     */
    public String getIdToken() {
        return idToken;
    }

    /**
     * Sets id token.
     *
     * @param idToken the id token
     */
    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    /**
     * Gets instance url.
     *
     * @return the instance url
     */
    public String getInstanceUrl() {
        return instanceUrl;
    }

    /**
     * Sets instance url.
     *
     * @param instanceUrl the instance url
     */
    public void setInstanceUrl(String instanceUrl) {
        this.instanceUrl = instanceUrl;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets token type.
     *
     * @return the token type
     */
    public String getTokenType() {
        return tokenType;
    }

    /**
     * Sets token type.
     *
     * @param tokenType the token type
     */
    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    /**
     * Gets issued at.
     *
     * @return the issued at
     */
    public String getIssuedAt() {
        return issuedAt;
    }

    /**
     * Sets issued at.
     *
     * @param issuedAt the issued at
     */
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
