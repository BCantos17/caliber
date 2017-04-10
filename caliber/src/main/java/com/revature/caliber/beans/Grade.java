package com.revature.caliber.beans;

import java.util.Date;

/**
 * The type Grade.
 */
public class Grade {

    private long gradeId;
    private Assessment assessment;
    private Trainee trainee;
    private Date dateReceived;
    private int score;

    /**
     * Gets grade id.
     *
     * @return the grade id
     */
    public long getGradeId() {
        return gradeId;
    }

    /**
     * Sets grade id.
     *
     * @param gradeId the grade id
     */
    public void setGradeId(long gradeId) {
        this.gradeId = gradeId;
    }

    /**
     * Gets assessment.
     *
     * @return the assessment
     */
    public Assessment getAssessment() {
        return assessment;
    }

    /**
     * Sets assessment.
     *
     * @param assessment the assessment
     */
    public void setAssessment(Assessment assessment) {
        this.assessment = assessment;
    }

    /**
     * Gets trainee.
     *
     * @return the trainee
     */
    public Trainee getTrainee() {
        return trainee;
    }

    /**
     * Sets trainee.
     *
     * @param trainee the trainee
     */
    public void setTrainee(Trainee trainee) {
        this.trainee = trainee;
    }

    /**
     * Gets date received.
     *
     * @return the date received
     */
    public Date getDateReceived() {
        return dateReceived;
    }

    /**
     * Sets date received.
     *
     * @param dateReceived the date received
     */
    public void setDateReceived(Date dateReceived) {
        this.dateReceived = dateReceived;
    }

    /**
     * Gets score.
     *
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * Sets score.
     *
     * @param score the score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Instantiates a new Grade.
     *
     * @param gradeId      the grade id
     * @param assessment   the assessment
     * @param trainee      the trainee
     * @param dateReceived the date received
     * @param score        the score
     */
    public Grade(long gradeId, Assessment assessment, Trainee trainee, Date dateReceived, int score) {
        super();
        this.gradeId = gradeId;
        this.assessment = assessment;
        this.trainee = trainee;
        this.dateReceived = dateReceived;
        this.score = score;
    }

    /**
     * Instantiates a new Grade.
     */
    public Grade() {
        super();
    }

    /**
     * Instantiates a new Grade.
     *
     * @param assessment   the assessment
     * @param trainee      the trainee
     * @param dateReceived the date received
     * @param score        the score
     */
    public Grade(Assessment assessment, Trainee trainee, Date dateReceived, int score) {
        super();
        this.assessment = assessment;
        this.trainee = trainee;
        this.dateReceived = dateReceived;
        this.score = score;
    }


}