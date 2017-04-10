package com.revature.caliber.assessment.beans;

/**
 * The type Qc note.
 */
public class QCNote extends Note {

    private int trainee;
    private int week;

    /**
     * Instantiates a new Qc note.
     *
     * @param trainee the trainee
     * @param week    the week
     */
    public QCNote(int trainee, int week) {
        super();
        this.trainee = trainee;
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

    @Override
    public String toString() {
        return super.toString() + " > QCNote{" +
                "trainee=" + trainee +
                ", week=" + week +
                '}';
    }

}
