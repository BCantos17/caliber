package com.revature.caliber.training.beans;

/**
 * Bean for Trainee
 */
public class Trainee {

    /**
     * id for Trainee (PK)
     */
    private int traineeId;

    /**
     * Full name of the Trainee
     */
    private String name;

    /**
     * Trainee's e-mail
     */
    private String email;

    /**
     * Status like "Signed", "Selected", etc.
     */
    private String trainingStatus;

    /**
     * Batch that the Trainee belongs to
     */
    private Batch batch;

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
     */
    public Trainee(String name, String email, String trainingStatus, Batch batch) {
        super();
        this.name = name;
        this.email = email;
        this.trainingStatus = trainingStatus;
        this.batch = batch;
    }

    /**
     * Instantiates a new Trainee.
     *
     * @param traineeId      the trainee id
     * @param name           the name
     * @param email          the email
     * @param trainingStatus the training status
     * @param batch          the batch
     */
    public Trainee(int traineeId, String name, String email, String trainingStatus, Batch batch) {
        super();
        this.traineeId = traineeId;
        this.name = name;
        this.email = email;
        this.trainingStatus = trainingStatus;
        this.batch = batch;
    }

    /**
     * Gets trainee id.
     *
     * @return the trainee id
     */
// Bi-directional mapping -- to avoid recursion, make DTO to send to UI
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

    @Override
    public String toString() {
        return "Trainee{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", trainingStatus='" + trainingStatus + '\'' +
                ", batch=" + batch +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trainee trainee = (Trainee) o;

        if (!name.equals(trainee.name)) return false;
        if (!email.equals(trainee.email)) return false;
        return trainingStatus.equals(trainee.trainingStatus);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + trainingStatus.hashCode();
        return result;
    }
}
