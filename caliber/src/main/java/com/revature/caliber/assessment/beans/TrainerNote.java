package com.revature.caliber.assessment.beans;

/**
 * The type Trainer note.
 */
public class TrainerNote extends Note {

    /**
     * The trainer who made the comment
     */
    private int trainer;

    /**
     * The week that the trainer made the evaluation
     */
    private int week;

    /**
     * Instantiates a new Trainer note.
     */
    public TrainerNote() {
        super();
    }

    /**
     * Instantiates a new Trainer note.
     *
     * @param content     the content
     * @param sugarCoated the sugar coated
     */
    public TrainerNote(String content, boolean sugarCoated) {
        super(content, sugarCoated);
    }

    /**
     * Gets trainer.
     *
     * @return the trainer
     */
    public int getTrainer() {
        return trainer;
    }

    /**
     * Sets trainer.
     *
     * @param trainer the trainer
     */
    public void setTrainer(int trainer) {
        this.trainer = trainer;
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


}
