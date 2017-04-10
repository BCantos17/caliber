package com.revature.caliber.training.beans;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Bean for Trainee
 */
@Entity
@Table(name = "CALIBER_TRAINEE")
public class Trainee {

	/**
	 * id for Trainee (PK)
	 */
	@Id
	@Column(name = "TRAINEE_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRAINEE_ID_SEQUENCE")
	@SequenceGenerator(name = "TRAINEE_ID_SEQUENCE", sequenceName = "TRAINEE_ID_SEQUENCE")
	private int traineeId;

	/**
	 * Full name of the Trainee
	 */
	@Column(name = "TRAINEE_NAME")
	private String name;

	/**
	 * Trainee's e-mail
	 */
	@Column(name = "TRAINEE_EMAIL")
	private String email;

	/**
	 * Status like "Signed", "Selected", etc.
	 */
	@Column(name = "TRAINING_STATUS")
	private String trainingStatus;

	/**
	 * Batch that the Trainee belongs to
	 */
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "BATCH_ID", nullable = false)
	@JsonBackReference(value = "traineeAndBatch")
	private Batch batch;

	public Trainee() {
		super();
	}

	public Trainee(String name, String email, String trainingStatus, Batch batch) {
		super();
		this.name = name;
		this.email = email;
		this.trainingStatus = trainingStatus;
		this.batch = batch;
	}

	public Trainee(int traineeId, String name, String email, String trainingStatus, Batch batch) {
		super();
		this.traineeId = traineeId;
		this.name = name;
		this.email = email;
		this.trainingStatus = trainingStatus;
		this.batch = batch;
	}

	// Bi-directional mapping -- to avoid recursion, make DTO to send to UI
	public int getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(int traineeId) {
		this.traineeId = traineeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTrainingStatus() {
		return trainingStatus;
	}

	public void setTrainingStatus(String trainingStatus) {
		this.trainingStatus = trainingStatus;
	}

	public Batch getBatch() {
		return batch;
	}

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
