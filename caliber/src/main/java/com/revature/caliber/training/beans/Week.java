package com.revature.caliber.training.beans;

import java.util.Set;


/**
 * Bean for Week
 */
public class Week {

    private long weekId;

    private int weekNumber;

    private Batch batch;

    private Set<Category> topics;

    /**
     * Instantiates a new Week.
     *
     * @param weekId     the week id
     * @param weekNumber the week number
     * @param batch      the batch
     * @param topics     the topics
     */
    public Week(long weekId, int weekNumber, Batch batch, Set<Category> topics) {
        super();
        this.weekId = weekId;
        this.weekNumber = weekNumber;
        this.batch = batch;
        this.topics = topics;
    }

    /**
     * Instantiates a new Week.
     *
     * @param weekNumber the week number
     * @param batch      the batch
     * @param topics     the topics
     */
    public Week(int weekNumber, Batch batch, Set<Category> topics) {
        super();
        this.weekNumber = weekNumber;
        this.batch = batch;
        this.topics = topics;
    }

    /**
     * Instantiates a new Week.
     */
    public Week() {
        super();
    }

    /**
     * Gets week id.
     *
     * @return the week id
     */
    public long getWeekId() {
        return weekId;
    }

    /**
     * Sets week id.
     *
     * @param weekId the week id
     */
    public void setWeekId(long weekId) {
        this.weekId = weekId;
    }

    /**
     * Gets week number.
     *
     * @return the week number
     */
    public int getWeekNumber() {
        return weekNumber;
    }

    /**
     * Sets week number.
     *
     * @param weekNumber the week number
     */
    public void setWeekNumber(int weekNumber) {
        this.weekNumber = weekNumber;
    }

    /**
     * Gets batch.
     *
     * @return the batch
     */
    public Batch getBatch() {
        return batch;
    }

    /**
     * Sets batch.
     *
     * @param batch the batch
     */
    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    /**
     * Gets topics.
     *
     * @return the topics
     */
    public Set<Category> getTopics() {
        return topics;
    }

    /**
     * Sets topics.
     *
     * @param topics the topics
     */
    public void setTopics(Set<Category> topics) {
        this.topics = topics;
    }

    @Override
    public String toString() {
        return "Week [weekId=" + weekId + ", weekNumber=" + weekNumber + ", batch=" + batch + ", topics=" + topics
                + "]";
    }

}
