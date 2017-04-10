package com.revature.caliber.beans;

/**
 * The type Qc status.
 */
public class QCStatus {

    private short statusId;
    private String status;

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
     * Instantiates a new Qc status.
     *
     * @param status the status
     */
    public QCStatus(String status) {
        super();
        this.status = status;
    }

    /**
     * Instantiates a new Qc status.
     *
     * @param statusId the status id
     * @param status   the status
     */
    public QCStatus(short statusId, String status) {
        super();
        this.statusId = statusId;
        this.status = status;
    }

    /**
     * Instantiates a new Qc status.
     */
    public QCStatus() {
        super();
    }

}