package com.revature.caliber.assessment.beans;

/**
 * The type Batch note.
 */
public class BatchNote extends Note {

    @Override
    public String toString() {
        return "BatchNote [week=" + week + ", batch=" + batch + ", getWeek()=" + getWeek() + ", getBatch()="
                + getBatch() + ", getNoteId()=" + getNoteId() + ", getContent()=" + getContent()
                + ", getSugarCoatedContent()=" + getSugarCoatedContent() + ", getClass()=" + getClass()
                + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }

    /**
     * The week of the batch's evaluation
     */
    private int week;

    /**
     * The batch identifier
     */
    private int batch;

    /**
     * Instantiates a new Batch note.
     *
     * @param week  the week
     * @param batch the batch
     */
    public BatchNote(int week, int batch) {
        super();
        this.week = week;
        this.batch = batch;
    }

    /**
     * Instantiates a new Batch note.
     */
    public BatchNote() {
        super();
    }

    /**
     * Instantiates a new Batch note.
     *
     * @param content     the content
     * @param sugarCoated the sugar coated
     */
    public BatchNote(String content, boolean sugarCoated) {
        super(content, sugarCoated);
    }

    /**
     * Gets week.
     *
     * @return the week
     */
    public int getWeek() {
        return week;
    }

    /**
     * Sets week.
     *
     * @param week the week
     */
    public void setWeek(int week) {
        this.week = week;
    }

    /**
     * Gets batch.
     *
     * @return the batch
     */
    public long getBatch() {
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

}
