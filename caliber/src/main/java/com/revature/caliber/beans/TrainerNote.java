package com.revature.caliber.beans;

/**
 * The type Trainer note.
 */
public class TrainerNote extends Note {

    private Trainee trainee;
    private Week week;

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
     * Instantiates a new Trainer note.
     */
    public TrainerNote() {
        super();
    }


}