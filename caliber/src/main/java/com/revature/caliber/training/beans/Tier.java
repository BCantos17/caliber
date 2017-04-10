package com.revature.caliber.training.beans;

/**
 * The type Tier.
 */
public class Tier {

    private short tierId;

    private String tier;

    private short ranking;

    /**
     * Instantiates a new Tier.
     */
    public Tier() {
        super();
    }

    /**
     * Instantiates a new Tier.
     *
     * @param tier    the tier
     * @param ranking the ranking
     */
    public Tier(String tier, short ranking) {
        super();
        this.tier = tier;
        this.ranking = ranking;
    }

    /**
     * Instantiates a new Tier.
     *
     * @param tierId  the tier id
     * @param tier    the tier
     * @param ranking the ranking
     */
    public Tier(short tierId, String tier, short ranking) {
        super();
        this.tierId = tierId;
        this.tier = tier;
        this.ranking = ranking;
    }

    /**
     * Gets tier id.
     *
     * @return the tier id
     */
    public short getTierId() {
        return tierId;
    }

    /**
     * Sets tier id.
     *
     * @param tierId the tier id
     */
    public void setTierId(short tierId) {
        this.tierId = tierId;
    }

    /**
     * Gets tier.
     *
     * @return the tier
     */
    public String getTier() {
        return tier;
    }

    /**
     * Sets tier.
     *
     * @param tier the tier
     */
    public void setTier(String tier) {
        this.tier = tier;
    }

    /**
     * Gets ranking.
     *
     * @return the ranking
     */
    public short getRanking() {
        return ranking;
    }

    /**
     * Sets ranking.
     *
     * @param ranking the ranking
     */
    public void setRanking(short ranking) {
        this.ranking = ranking;
    }

}
