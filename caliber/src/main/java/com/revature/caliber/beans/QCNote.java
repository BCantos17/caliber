package com.revature.caliber.beans;

/**
 * The type Qc note.
 */
public class QCNote extends Note {

    private Trainee trainee;
    private Week week;


    /**
     * Instantiates a new Qc note.
     *
     * @param trainee the trainee
     * @param week    the week
     */
    public QCNote(Trainee trainee, Week week) {
        super();
        this.trainee = trainee;
        this.week = week;
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
     * Instantiates a new Qc note.
     */
    public QCNote() {
        super();
    }

    /**
     * Instantiates a new Qc note.
     *
     * @param content     the content
     * @param sugarCoated the sugar coated
     */
    public QCNote(String content, boolean sugarCoated) {
        super(content, sugarCoated);
    }

}