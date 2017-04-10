package com.revature.caliber.beans;

import java.util.Set;

/**
 * The type Week.
 */
public class Week {

    private long weekId;
    private int weekNumber;
    private Batch batch;
    private Set<Category> topics;

    // Bi-directional mapping -- to avoid recursion, make DTO to send to UI
    private Set<Assessment> assessments;
    private BatchNote batchNotes;
    private Set<QCNote> qcNotes;
    private Set<TrainerNote> trainerNotes;

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

    /**
     * Gets assessments.
     *
     * @return the assessments
     */
    public Set<Assessment> getAssessments() {
        return assessments;
    }

    /**
     * Sets assessments.
     *
     * @param assessments the assessments
     */
    public void setAssessments(Set<Assessment> assessments) {
        this.assessments = assessments;
    }

    /**
     * Gets batch notes.
     *
     * @return the batch notes
     */
    public BatchNote getBatchNotes() {
        return batchNotes;
    }

    /**
     * Sets batch notes.
     *
     * @param batchNotes the batch notes
     */
    public void setBatchNotes(BatchNote batchNotes) {
        this.batchNotes = batchNotes;
    }

    /**
     * Gets qc notes.
     *
     * @return the qc notes
     */
    public Set<QCNote> getQcNotes() {
        return qcNotes;
    }

    /**
     * Sets qc notes.
     *
     * @param qcNotes the qc notes
     */
    public void setQcNotes(Set<QCNote> qcNotes) {
        this.qcNotes = qcNotes;
    }

    /**
     * Gets trainer notes.
     *
     * @return the trainer notes
     */
    public Set<TrainerNote> getTrainerNotes() {
        return trainerNotes;
    }

    /**
     * Sets trainer notes.
     *
     * @param trainerNotes the trainer notes
     */
    public void setTrainerNotes(Set<TrainerNote> trainerNotes) {
        this.trainerNotes = trainerNotes;
    }
    
    
    
    /**
     * Instantiates a new Week.
     */
    public Week() {
		super();
	}

	/**
     * Instantiates a new Week.
     *
     * @param weekId      the week id
     * @param weekNumber  the week number
     * @param batch       the batch
     * @param topics      the topics
     * @param assessments the assessments
     */
    public Week(long weekId, int weekNumber, Batch batch, Set<Category> topics, Set<Assessment> assessments) {
        super();
        this.weekId = weekId;
        this.weekNumber = weekNumber;
        this.batch = batch;
        this.topics = topics;
        this.assessments = assessments;
    }

    /**
     * Instantiates a new Week.
     *
     * @param weekId       the week id
     * @param weekNumber   the week number
     * @param batch        the batch
     * @param topics       the topics
     * @param assessments  the assessments
     * @param batchNotes   the batch notes
     * @param qcNotes      the qc notes
     * @param trainerNotes the trainer notes
     */
    public Week(long weekId, int weekNumber, Batch batch, Set<Category> topics, Set<Assessment> assessments,
                BatchNote batchNotes, Set<QCNote> qcNotes, Set<TrainerNote> trainerNotes) {
        super();
        this.weekId = weekId;
        this.weekNumber = weekNumber;
        this.batch = batch;
        this.topics = topics;
        this.assessments = assessments;
        this.batchNotes = batchNotes;
        this.qcNotes = qcNotes;
        this.trainerNotes = trainerNotes;
    }

    /**
     * Instantiates a new Week.
     *
     * @param weekNumber  the week number
     * @param batch       the batch
     * @param topics      the topics
     * @param assessments the assessments
     */
    public Week(int weekNumber, Batch batch, Set<Category> topics, Set<Assessment> assessments) {
        super();
        this.weekNumber = weekNumber;
        this.batch = batch;
        this.topics = topics;
        this.assessments = assessments;
    }


    @Override
    public String toString() {
        return "Week{" +
                "weekId=" + weekId +
                ", weekNumber=" + weekNumber +
                ", batch=" + batch +
                ", topics=" + topics +
                ", assessments=" + assessments +
                ", batchNotes=" + batchNotes +
                ", qcNotes=" + qcNotes +
                ", trainerNotes=" + trainerNotes +
                '}';
    }

}
