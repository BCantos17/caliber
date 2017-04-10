package com.revature.caliber.assessment.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 * Java Bean for Grade Object
 */
public class Grade {

    /**
     * gradeId- primary key for Grade table
     */
    private long gradeId;

    /**
     * Assessment - A trainee received a grade on specified assessment
     */
    private Assessment assessment;

    /**
     * Trainee- the trainee that receives this Grade object
     */
    private int trainee;

    /**
     * dateReceived- date this Grade object was received
     */
    private Date dateReceived;

    /**
     * score - score of the grade
     */
    private int score;

    /**
     * Instantiates a new Grade.
     */
    public Grade() {
        super();
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
    public Grade(long gradeId, Assessment assessment, int trainee, Date dateReceived, int score) {
        super();
        this.gradeId = gradeId;
        this.assessment = assessment;
        this.trainee = trainee;
        this.dateReceived = dateReceived;
        this.score = score;
    }

    /**
     * Instantiates a new Grade.
     *
     * @param assessment   the assessment
     * @param trainee      the trainee
     * @param dateReceived the date received
     * @param score        the score
     */
    public Grade(Assessment assessment, int trainee, Date dateReceived, int score) {
        super();
        this.assessment = assessment;
        this.trainee = trainee;
        this.dateReceived = dateReceived;
        this.score = score;
    }

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
    public int getTrainee() {
        return trainee;
    }

    /**
     * Sets trainee.
     *
     * @param trainee the trainee
     */
    public void setTrainee(int trainee) {
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

    @Override
    public String toString() {
        return "Grade [gradeId=" + gradeId + ", assessment=" + assessment + ", trainee=" + trainee + ", dateReceived="
                + dateReceived + ", score=" + score + "]";
    }


}