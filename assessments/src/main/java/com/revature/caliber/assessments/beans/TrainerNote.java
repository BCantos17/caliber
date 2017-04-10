package com.revature.caliber.assessments.beans;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name="CALIBER_TRAINER_NOTE")
public class TrainerNote extends Note{
	
	/**
	 * The trainer who made the comment
	 */
	@Column(name="TRAINER_ID")
	private int trainer;
	
	/**
	 * The week that the trainer made the evaluation 
	 */
	@Column(name="WEEK_ID", nullable=false)
	private int week;

	public TrainerNote() {
		super();
	}
	
	public TrainerNote(String content, boolean sugarCoated) {
		super(content, sugarCoated);
	}

	public int getTrainer() {
		return trainer;
	}

	public void setTrainer(int trainer) {
		this.trainer = trainer;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}


}
