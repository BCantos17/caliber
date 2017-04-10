package com.revature.caliber.assessment.beans;

import java.util.Set;

/**
 * JavaBean for QCStatus Object Status of assessments determine by Quality Control (Trainer Object)
 */
public class QCStatus {

    private short statusId;

    private String status;

    private Set<Assessment> assessments;

    /**
     * Instantiates a new Qc status.
     */
    public QCStatus() {
        super();
    }

    /**
     * Instantiates a new Qc status.
     *
     * @param status the status
     */
    public QCStatus(String status) {
        this.status = status;
    }

    /**
     * Instantiates a new Qc status.
     *
     * @param statusId the status id
     * @param status   the status
     */
    public QCStatus(short statusId, String status) {
        this.statusId = statusId;
        this.status = status;
    }

    /**
     * Gets status id.
     *
     * @return the status id
     */
    public short getStatusId() {
        return statusId;
    }

    /**
     * Sets status id.
     *
     * @param statusId the status id
     */
    public void setStatusId(short statusId) {
        this.statusId = statusId;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(String status) {
        this.status = status;
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

    @Override
    public String toString() {
        return "QCStatus [statusId=" + statusId + ", status=" + status + ", assessments=" + assessments + "]";
    }

}