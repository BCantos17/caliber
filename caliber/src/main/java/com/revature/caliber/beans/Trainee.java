package com.revature.caliber.beans;

import java.util.Set;

/**
 * The type Trainee.
 */
public class Trainee {

    private int traineeId;
    private String name;
    private String email;
    private String trainingStatus;
    private Batch batch;

    // Bi-directional mapping -- to avoid recursion, make DTO to send to UI
    private Set<Grade> grades;
    private Set<TrainerNote> trainerNotes;
    private Set<QCNote> qcNotes;

    /**
     * Gets trainee id.
     *
     * @return the trainee id
     */
    public int getTraineeId() {
        return traineeId;
    }

    /**
     * Sets trainee id.
     *
     * @param traineeId the trainee id
     */
    public void setTraineeId(int traineeId) {
        this.traineeId = traineeId;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets training status.
     *
     * @return the training status
     */
    public String getTrainingStatus() {
        return trainingStatus;
    }

    /**
     * Sets training status.
     *
     * @param trainingStatus the training status
     */
    public void setTrainingStatus(String trainingStatus) {
        this.trainingStatus = trainingStatus;
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
     * Gets grades.
     *
     * @return the grades
     */
    public Set<Grade> getGrades() {
        return grades;
    }

    /**
     * Sets grades.
     *
     * @param grades the grades
     */
    public void setGrades(Set<Grade> grades) {
        this.grades = grades;
    }

    /**
     * Gets trainer notes.
     *
     * @return the trainer notes
     */
    public Set<TrainerNote> getTrainerNotes() {
        return trainerNotes;
    }

    /**
     * Sets trainer notes.
     *
     * @param trainerNotes the trainer notes
     */
    public void setTrainerNotes(Set<TrainerNote> trainerNotes) {
        this.trainerNotes = trainerNotes;
    }

    /**
     * Gets qc notes.
     *
     * @return the qc notes
     */
    public Set<QCNote> getQcNotes() {
        return qcNotes;
    }

    /**
     * Sets qc notes.
     *
     * @param qcNotes the qc notes
     */
    public void setQcNotes(Set<QCNote> qcNotes) {
        this.qcNotes = qcNotes;
    }

    /**
     * Instantiates a new Trainee.
     */
    public Trainee() {
        super();
    }

    /**
     * Instantiates a new Trainee.
     *
     * @param name           the name
     * @param email          the email
     * @param trainingStatus the training status
     * @param batch          the batch
     * @param grades         the grades
     */
    public Trainee(String name, String email, String trainingStatus, Batch batch, Set<Grade> grades) {
        super();
        this.name = name;
        this.email = email;
        this.trainingStatus = trainingStatus;
        this.batch = batch;
        this.grades = grades;
    }

    /**
     * Instantiates a new Trainee.
     *
     * @param traineeId      the trainee id
     * @param name           the name
     * @param email          the email
     * @param trainingStatus the training status
     * @param batch          the batch
     * @param grades         the grades
     * @param trainerNotes   the trainer notes
     * @param qcNotes        the qc notes
     */
    public Trainee(int traineeId, String name, String email, String trainingStatus, Batch batch, Set<Grade> grades,
                   Set<TrainerNote> trainerNotes, Set<QCNote> qcNotes) {
        super();
        this.traineeId = traineeId;
        this.name = name;
        this.email = email;
        this.trainingStatus = trainingStatus;
        this.batch = batch;
        this.grades = grades;
        this.trainerNotes = trainerNotes;
        this.qcNotes = qcNotes;
    }

    @Override
    public String toString() {
        return "Trainee{" +
                "traineeId=" + traineeId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", trainingStatus='" + trainingStatus + '\'' +
                ", batch=" + batch +
                ", grades=" + grades +
                ", trainerNotes=" + trainerNotes +
                ", qcNotes=" + qcNotes +
                '}';
    }
}
