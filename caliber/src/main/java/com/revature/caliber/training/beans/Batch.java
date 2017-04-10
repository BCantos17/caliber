package com.revature.caliber.training.beans;

import java.util.Date;
import java.util.Set;

/**
 * The type Batch.
 */
public class Batch {

    private int batchId;

    private String trainingName;

    private Trainer trainer;

    private Trainer coTrainer;

    private String skillType;

    private String trainingType;

    private Date startDate;

    private Date endDate;

    private String location;

    private short goodGradeThreshold;

    private short borderlineGradeThreshold;

    // Bi-directional mapping -- to avoid recursion, make DTO to send to UI

    private Set<Trainee> trainees;

    private Set<Week> weeks;

    /**
     * Instantiates a new Batch.
     */
/*
     * Default Constructor
	 */
    public Batch() {
    }

    /**
     * Instantiates a new Batch.
     *
     * @param batchId                  the batch id
     * @param trainingName             the training name
     * @param trainer                  the trainer
     * @param coTrainer                the co trainer
     * @param skillType                the skill type
     * @param trainingType             the training type
     * @param startDate                the start date
     * @param endDate                  the end date
     * @param location                 the location
     * @param goodGradeThreshold       the good grade threshold
     * @param borderlineGradeThreshold the borderline grade threshold
     * @param trainees                 the trainees
     * @param weeks                    the weeks
     */
/*
     * Constructor with ID
	 */
    public Batch(int batchId, String trainingName, Trainer trainer, Trainer coTrainer, String skillType,
                 String trainingType, Date startDate, Date endDate, String location, short goodGradeThreshold,
                 short borderlineGradeThreshold, Set<Trainee> trainees, Set<Week> weeks) {
        this.batchId = batchId;
        this.trainingName = trainingName;
        this.trainer = trainer;
        this.coTrainer = coTrainer;
        this.skillType = skillType;
        this.trainingType = trainingType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.goodGradeThreshold = goodGradeThreshold;
        this.borderlineGradeThreshold = borderlineGradeThreshold;
        this.trainees = trainees;
        this.weeks = weeks;
    }

    /**
     * Instantiates a new Batch.
     *
     * @param trainingName             the training name
     * @param trainer                  the trainer
     * @param coTrainer                the co trainer
     * @param skillType                the skill type
     * @param trainingType             the training type
     * @param startDate                the start date
     * @param endDate                  the end date
     * @param location                 the location
     * @param goodGradeThreshold       the good grade threshold
     * @param borderlineGradeThreshold the borderline grade threshold
     * @param trainees                 the trainees
     * @param weeks                    the weeks
     */
/*
	 * Constructor with no ID
	 */
    public Batch(String trainingName, Trainer trainer, Trainer coTrainer, String skillType, String trainingType,
                 Date startDate, Date endDate, String location, short goodGradeThreshold, short borderlineGradeThreshold,
                 Set<Trainee> trainees, Set<Week> weeks) {
        this.trainingName = trainingName;
        this.trainer = trainer;
        this.coTrainer = coTrainer;
        this.skillType = skillType;
        this.trainingType = trainingType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.goodGradeThreshold = goodGradeThreshold;
        this.borderlineGradeThreshold = borderlineGradeThreshold;
        this.trainees = trainees;
        this.weeks = weeks;
    }

    /**
     * Gets batch id.
     *
     * @return the batch id
     */
/*
	 * Setters and Getters
	 */
    public int getBatchId() {
        return batchId;
    }

    /**
     * Sets batch id.
     *
     * @param batchId the batch id
     */
    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    /**
     * Gets training name.
     *
     * @return the training name
     */
    public String getTrainingName() {
        return trainingName;
    }

    /**
     * Sets training name.
     *
     * @param trainingName the training name
     */
    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    /**
     * Gets trainer.
     *
     * @return the trainer
     */
    public Trainer getTrainer() {
        return trainer;
    }

    /**
     * Sets trainer.
     *
     * @param trainer the trainer
     */
    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    /**
     * Gets co trainer.
     *
     * @return the co trainer
     */
    public Trainer getCoTrainer() {
        return coTrainer;
    }

    /**
     * Sets co trainer.
     *
     * @param coTrainer the co trainer
     */
    public void setCoTrainer(Trainer coTrainer) {
        this.coTrainer = coTrainer;
    }

    /**
     * Gets skill type.
     *
     * @return the skill type
     */
    public String getSkillType() {
        return skillType;
    }

    /**
     * Sets skill type.
     *
     * @param skillType the skill type
     */
    public void setSkillType(String skillType) {
        this.skillType = skillType;
    }

    /**
     * Gets training type.
     *
     * @return the training type
     */
    public String getTrainingType() {
        return trainingType;
    }

    /**
     * Sets training type.
     *
     * @param trainingType the training type
     */
    public void setTrainingType(String trainingType) {
        this.trainingType = trainingType;
    }

    /**
     * Gets start date.
     *
     * @return the start date
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Sets start date.
     *
     * @param startDate the start date
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets end date.
     *
     * @return the end date
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Sets end date.
     *
     * @param endDate the end date
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * Gets location.
     *
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets location.
     *
     * @param location the location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Gets good grade threshold.
     *
     * @return the good grade threshold
     */
    public short getGoodGradeThreshold() {
        return goodGradeThreshold;
    }

    /**
     * Sets good grade threshold.
     *
     * @param goodGradeThreshold the good grade threshold
     */
    public void setGoodGradeThreshold(short goodGradeThreshold) {
        this.goodGradeThreshold = goodGradeThreshold;
    }

    /**
     * Gets borderline grade threshold.
     *
     * @return the borderline grade threshold
     */
    public short getBorderlineGradeThreshold() {
        return borderlineGradeThreshold;
    }

    /**
     * Sets borderline grade threshold.
     *
     * @param borderlineGradeThreshold the borderline grade threshold
     */
    public void setBorderlineGradeThreshold(short borderlineGradeThreshold) {
        this.borderlineGradeThreshold = borderlineGradeThreshold;
    }

    /**
     * Gets trainees.
     *
     * @return the trainees
     */
    public Set<Trainee> getTrainees() {
        return trainees;
    }

    /**
     * Sets trainees.
     *
     * @param trainees the trainees
     */
    public void setTrainees(Set<Trainee> trainees) {
        this.trainees = trainees;
    }

    /**
     * Gets weeks.
     *
     * @return the weeks
     */
    public Set<Week> getWeeks() {
        return weeks;
    }

    /**
     * Sets weeks.
     *
     * @param weeks the weeks
     */
    public void setWeeks(Set<Week> weeks) {
        this.weeks = weeks;
    }

    @Override
    public String toString() {
        return "Batch{" + "batchId=" + batchId + ", trainingName='" + trainingName + '\'' + ", trainer="
                + trainer.getName() + ", skillType='" + skillType + '\'' + ", trainingType='" + trainingType + '\''
                + ", startDate=" + startDate + ", endDate=" + endDate + ", location='" + location + '\''
                + ", goodGradeThreshold=" + goodGradeThreshold + ", borderlineGradeThreshold="
                + borderlineGradeThreshold + '}';
    }
}