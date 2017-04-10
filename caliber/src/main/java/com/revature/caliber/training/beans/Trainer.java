package com.revature.caliber.training.beans;

import java.util.Set;

/**
 * Bean for Trainer
 */
public class Trainer {

    /**
     * id for Trainer -- PK
     */
    private int trainerId;

    /**
     * Full name of the Trainer
     */
    private String name;

    /**
     * Title of the Trainer
     */
    private String title;

    /**
     * Email of the Trainer
     */
    private String email;

    /**
     * Salesforce account of the Trainer
     */
    private String salesforceAccount;

    /**
     * Salesforce authentication token of the Trainer
     */
    private String salesforceAuthenticationToken;

    /**
     * Salesforce refresh token of the Trainer
     */
    private String salesforceRefreshToken;

    /**
     * Tier of the Trainer
     */
    private Tier tier;

    // Bi-directional mapping -- to avoid recursion, make DTO to send to UI

    private Set<Batch> batches;

    /**
     * Instantiates a new Trainer.
     */
    public Trainer() {
        super();
    }

    /**
     * Instantiates a new Trainer.
     *
     * @param name                          the name
     * @param title                         the title
     * @param email                         the email
     * @param salesforceAccount             the salesforce account
     * @param salesforceAuthenticationToken the salesforce authentication token
     * @param salesforceRefreshToken        the salesforce refresh token
     * @param tier                          the tier
     */
    public Trainer(String name, String title, String email, String salesforceAccount,
                   String salesforceAuthenticationToken, String salesforceRefreshToken, Tier tier) {
        super();
        this.name = name;
        this.title = title;
        this.email = email;
        this.salesforceAccount = salesforceAccount;
        this.salesforceAuthenticationToken = salesforceAuthenticationToken;
        this.salesforceRefreshToken = salesforceRefreshToken;
        this.tier = tier;
    }

    /**
     * Instantiates a new Trainer.
     *
     * @param name                          the name
     * @param title                         the title
     * @param email                         the email
     * @param salesforceAccount             the salesforce account
     * @param salesforceAuthenticationToken the salesforce authentication token
     * @param salesforceRefreshToken        the salesforce refresh token
     * @param tier                          the tier
     * @param batches                       the batches
     */
    public Trainer(String name, String title, String email, String salesforceAccount,
                   String salesforceAuthenticationToken, String salesforceRefreshToken, Tier tier, Set<Batch> batches) {
        super();
        this.name = name;
        this.title = title;
        this.email = email;
        this.salesforceAccount = salesforceAccount;
        this.salesforceAuthenticationToken = salesforceAuthenticationToken;
        this.salesforceRefreshToken = salesforceRefreshToken;
        this.tier = tier;
        this.batches = batches;
    }

    /**
     * Instantiates a new Trainer.
     *
     * @param trainerId         the trainer id
     * @param name              the name
     * @param title             the title
     * @param email             the email
     * @param salesforceAccount the salesforce account
     * @param tier              the tier
     */
    public Trainer(int trainerId, String name, String title, String email, String salesforceAccount, Tier tier) {
        super();
        this.trainerId = trainerId;
        this.name = name;
        this.title = title;
        this.email = email;
        this.salesforceAccount = salesforceAccount;
        this.tier = tier;
    }

    /**
     * Instantiates a new Trainer.
     *
     * @param trainerId         the trainer id
     * @param name              the name
     * @param title             the title
     * @param email             the email
     * @param salesforceAccount the salesforce account
     * @param tier              the tier
     * @param batches           the batches
     */
    public Trainer(int trainerId, String name, String title, String email, String salesforceAccount, Tier tier,
                   Set<Batch> batches) {
        super();
        this.trainerId = trainerId;
        this.name = name;
        this.title = title;
        this.email = email;
        this.salesforceAccount = salesforceAccount;
        this.tier = tier;
        this.batches = batches;
    }

    /**
     * Gets trainer id.
     *
     * @return the trainer id
     */
    public int getTrainerId() {
        return trainerId;
    }

    /**
     * Sets trainer id.
     *
     * @param trainerId the trainer id
     */
    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets salesforce account.
     *
     * @return the salesforce account
     */
    public String getSalesforceAccount() {
        return salesforceAccount;
    }

    /**
     * Sets salesforce account.
     *
     * @param salesforceAccount the salesforce account
     */
    public void setSalesforceAccount(String salesforceAccount) {
        this.salesforceAccount = salesforceAccount;
    }

    /**
     * Gets salesforce authentication token.
     *
     * @return the salesforce authentication token
     */
    public String getSalesforceAuthenticationToken() {
        return salesforceAuthenticationToken;
    }

    /**
     * Sets salesforce authentication token.
     *
     * @param salesforceAuthenticationToken the salesforce authentication token
     */
    public void setSalesforceAuthenticationToken(String salesforceAuthenticationToken) {
        this.salesforceAuthenticationToken = salesforceAuthenticationToken;
    }

    /**
     * Gets tier.
     *
     * @return the tier
     */
    public Tier getTier() {
        return tier;
    }

    /**
     * Sets tier.
     *
     * @param tier the tier
     */
    public void setTier(Tier tier) {
        this.tier = tier;
    }

    /**
     * Gets batches.
     *
     * @return the batches
     */
    public Set<Batch> getBatches() {
        return batches;
    }

    /**
     * Sets batches.
     *
     * @param batches the batches
     */
    public void setBatches(Set<Batch> batches) {
        this.batches = batches;
    }

    /**
     * Gets salesforce refresh token.
     *
     * @return the salesforce refresh token
     */
    public String getSalesforceRefreshToken() {
        return salesforceRefreshToken;
    }

    /**
     * Sets salesforce refresh token.
     *
     * @param salesforceRefreshToken the salesforce refresh token
     */
    public void setSalesforceRefreshToken(String salesforceRefreshToken) {
        this.salesforceRefreshToken = salesforceRefreshToken;
    }

}
