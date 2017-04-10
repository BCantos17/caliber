package com.revature.caliber.training.beans;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="CALIBER_BATCH")
public class Batch {

	@Id
	@Column(name = "BATCH_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="BATCH_ID_SEQUENCE")
	@SequenceGenerator(name = "BATCH_ID_SEQUENCE", sequenceName = "BATCH_ID_SEQUENCE")
	private long batchId;

	@Column(name = "TRAINING_NAME")
	private String trainingName;


	@ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	@JoinColumn(name = "TRAINER_ID", nullable = false)
	//@JsonManagedReference(value = "batchAndTrainer")
	private Trainer trainer;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "CO_TRAINER_ID")
	//@JsonManagedReference(value = "batchAndCoTrainer")
	private Trainer coTrainer;

	@Column(name = "SKILL_TYPE")
	private String skillType;

	@Column(name = "TRAINING_TYPE")
	private String trainingType;

	@Column(name = "START_DATE", nullable = false)
	private Date startDate;

	@Column(name = "END_DATE", nullable = false)
	private Date endDate;

	@Column(name = "LOCATION", nullable = false)
	private String location;

	@Column(name = "GOOD_GRADE_THRESHOLD")
	private Short goodGradeThreshold;

	@Column(name = "BORDERLINE_GRADE_THRESHOLD")
	private Short borderlineGradeThreshold;

	// Bi-directional mapping -- to avoid recursion, make DTO to send to UI

	@OneToMany(mappedBy = "batch", fetch=FetchType.EAGER, cascade = CascadeType.REMOVE)
	@JsonManagedReference(value = "traineeAndBatch")
	private Set<Trainee> trainees;

	@OneToMany(mappedBy = "batch", fetch=FetchType.EAGER)
	@JsonManagedReference(value = "batchAndWeeks")
	private Set<Week> weeks;

	/*
        Default Constructor
         */
	public Batch() {}

	/*
	Constructor with ID
	 */
	public Batch(long batchId, String trainingName, Trainer trainer, Trainer coTrainer, String skillType,
				 String trainingType, Date startDate, Date endDate, String location, Short goodGradeThreshold,
				 Short borderlineGradeThreshold, Set<Trainee> trainees, Set<Week> weeks) {
		this.batchId = batchId;
		this.trainingName = trainingName;
		this.trainer = trainer;
		this.coTrainer = coTrainer;
		this.skillType = skillType;
		this.trainingType = trainingType;
		this.startDate = startDate;
		this.endDate = endDate;
		this.location = location;
		this.goodGradeThreshold = goodGradeThreshold;
		this.borderlineGradeThreshold = borderlineGradeThreshold;
		this.trainees = trainees;
		this.weeks = weeks;
	}

	/*
	Constructor with no ID
	 */
	public Batch(String trainingName, Trainer trainer, Trainer coTrainer, String skillType, String trainingType,
				 Date startDate, Date endDate, String location, Short goodGradeThreshold, Short borderlineGradeThreshold,
				 Set<Trainee> trainees, Set<Week> weeks) {
		this.trainingName = trainingName;
		this.trainer = trainer;
		this.coTrainer = coTrainer;
		this.skillType = skillType;
		this.trainingType = trainingType;
		this.startDate = startDate;
		this.endDate = endDate;
		this.location = location;
		this.goodGradeThreshold = goodGradeThreshold;
		this.borderlineGradeThreshold = borderlineGradeThreshold;
		this.trainees = trainees;
		this.weeks = weeks;
	}



	/*
	Setters and Getters
	 */
	public long getBatchId() {
		return batchId;
	}
	public void setBatchId(long batchId) {
		this.batchId = batchId;
	}
	public String getTrainingName() {
		return trainingName;
	}
	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}
	public Trainer getTrainer() {
		return trainer;
	}
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
	public Trainer getCoTrainer() {
		return coTrainer;
	}
	public void setCoTrainer(Trainer coTrainer) {
		this.coTrainer = coTrainer;
	}
	public String getSkillType() {
		return skillType;
	}
	public void setSkillType(String skillType) {
		this.skillType = skillType;
	}
	public String getTrainingType() {
		return trainingType;
	}
	public void setTrainingType(String trainingType) {
		this.trainingType = trainingType;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {this.location = location;}
	public short getGoodGradeThreshold() {
		return goodGradeThreshold;
	}
	public void setGoodGradeThreshold(Short goodGradeThreshold) {
		this.goodGradeThreshold = goodGradeThreshold;
	}
	public short getBorderlineGradeThreshold() {
		return borderlineGradeThreshold;
	}
	public void setBorderlineGradeThreshold(Short borderlineGradeThreshold) {this.borderlineGradeThreshold = borderlineGradeThreshold;}
	public Set<Trainee> getTrainees() {
		return trainees;
	}
	public void setTrainees(Set<Trainee> trainees) {
		this.trainees = trainees;
	}
	public Set<Week> getWeeks() {
		return weeks;
	}
	public void setWeeks(Set<Week> weeks) {
		this.weeks = weeks;
	}

	@Override
	public String toString() {
		return "Batch{" +
				"batchId=" + batchId +
				", trainingName='" + trainingName + '\'' +
				", trainer=" + trainer.getName() +
				", skillType='" + skillType + '\'' +
				", trainingType='" + trainingType + '\'' +
				", startDate=" + startDate +
				", endDate=" + endDate +
				", location='" + location + '\'' +
				", goodGradeThreshold=" + goodGradeThreshold +
				", borderlineGradeThreshold=" + borderlineGradeThreshold +
				'}';
	}
}