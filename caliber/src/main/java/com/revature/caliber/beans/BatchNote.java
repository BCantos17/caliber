package com.revature.caliber.beans;

/**
 * The type Batch note.
 */
public class BatchNote extends Note {

    private Week week;
    private Batch batch;

    /**
     * Gets week.
     *
     * @return the week
     */
    public Week getWeek() {
        return week;
    }

    /**
     * Sets week.
     *
     * @param week the week
     */
    public void setWeek(Week week) {
        this.week = week;
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
     * Instantiates a new Batch note.
     *
     * @param week  the week
     * @param batch the batch
     */
    public BatchNote(Week week, Batch batch) {
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

}