package com.revature.caliber.assessment.beans;

import java.util.Set;

/**
 * This is the hibernate annotated bean that for the
 * CALIBER_ASSESSMENT table in the database
 */
public class Assessment {

    /**
     * This is the PK ID using a unique sequence generator
     */
    private long assessmentId;

    /**
     * Trainer inputted title,
     * can be anything to help identify this assessment
     */
    private String title;

    /**
     * Batch ID reference
     */
    private int batch;

    /**
     * Raw numerical score before calculations
     */
    private int rawScore;

    /**
     * Assessment type, e.g. LMS, Verbal
     */
    private String type;

    /**
     * WeekID for reference
     */
    private long week;

    /**
     * QCStatus for a week, statuses can be
     * good, ok, bad
     * indicated with smiley, meh and frowny face
     */
    private QCStatus weeklyStatus;

    /**
     * Set of Categories for Assessments (for Hibernate ORM)
     */
    private Set<Category> categories;

    /**
     * Instantiates a new Assessment.
     *
     * @param assessmentId the assessment id
     * @param title        the title
     * @param batch        the batch
     * @param rawScore     the raw score
     * @param type         the type
     * @param week         the week
     * @param categories   the categories
     */
    public Assessment(long assessmentId,
                      String title,
                      int batch,
                      int rawScore,
                      String type,
                      long week,
                      Set<Category> categories) {
        super();
        this.assessmentId = assessmentId;
        this.title = title;
        this.batch = batch;
        this.rawScore = rawScore;
        this.type = type;
        this.week = week;
        this.categories = categories;
    }

    /**
     * Instantiates a new Assessment.
     */
    public Assessment() {
        super();
    }

    /**
     * Instantiates a new Assessment.
     *
     * @param title      the title
     * @param batch      the batch
     * @param rawScore   the raw score
     * @param type       the type
     * @param week       the week
     * @param categories the categories
     */
    public Assessment(String title,
                      int batch,
                      int rawScore,
                      String type,
                      long week,
                      Set<Category> categories) {
        super();
        this.title = title;
        this.batch = batch;
        this.rawScore = rawScore;
        this.type = type;
        this.week = week;
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Assessment{" +
                "assessmentId=" + assessmentId +
                ", title='" + title + '\'' +
                ", batch=" + batch +
                ", rawScore=" + rawScore +
                ", type='" + type + '\'' +
                ", week=" + week +
                ", weeklyStatus=" + weeklyStatus +
                ", categories=" + categories +
                '}';
    }

    /**
     * Gets assessment id.
     *
     * @return the assessment id
     */
    public long getAssessmentId() {
        return assessmentId;
    }

    /**
     * Sets assessment id.
     *
     * @param assessmentId the assessment id
     */
    public void setAssessmentId(long assessmentId) {
        this.assessmentId = assessmentId;
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
     * Gets batch.
     *
     * @return the batch
     */
    public int getBatch() {
        return batch;
    }

    /**
     * Sets batch.
     *
     * @param batch the batch
     */
    public void setBatch(int batch) {
        this.batch = batch;
    }

    /**
     * Gets raw score.
     *
     * @return the raw score
     */
    public int getRawScore() {
        return rawScore;
    }

    /**
     * Sets raw score.
     *
     * @param rawScore the raw score
     */
    public void setRawScore(int rawScore) {
        this.rawScore = rawScore;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets week.
     *
     * @return the week
     */
    public long getWeek() {
        return week;
    }

    /**
     * Sets week.
     *
     * @param week the week
     */
    public void setWeek(long week) {
        this.week = week;
    }

    /**
     * Gets categories.
     *
     * @return the categories
     */
    public Set<Category> getCategories() {
        return categories;
    }

    /**
     * Sets categories.
     *
     * @param categories the categories
     */
    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    /**
     * Gets weekly status.
     *
     * @return the weekly status
     */
    public QCStatus getWeeklyStatus() {
        return weeklyStatus;
    }

    /**
     * Sets weekly status.
     *
     * @param weeklyStatus the weekly status
     */
    public void setWeeklyStatus(QCStatus weeklyStatus) {
        this.weeklyStatus = weeklyStatus;
    }

}