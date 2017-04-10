package com.revature.caliber.assessments.beans;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity(name="CALIBER_QC_NOTE")
public class QCNote extends Note{

	@Column(name="TRAINEE_ID")
	private int trainee;
	@Column(name="WEEK_ID")
	private int week;
	
	public QCNote(int trainee, int week) {
		super();
		this.trainee = trainee;
		this.week = week;
	}

	public QCNote() {
		super();
	}

	public QCNote(String content, boolean sugarCoated) {
		super(content, sugarCoated);
	}

	public int getTrainee() {
		return trainee;
	}

	public void setTrainee(int trainee) {
		this.trainee = trainee;
	}

	public int getWeek() {
		return week;
	}

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
