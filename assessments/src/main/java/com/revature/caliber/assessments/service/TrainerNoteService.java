package com.revature.caliber.assessments.service;

import java.util.Set;

import com.revature.caliber.assessments.beans.TrainerNote;

public interface TrainerNoteService {

	void createTrainerNote(TrainerNote note);
	TrainerNote getTrainerNoteById(Integer trainerNoteId);
	TrainerNote getTrainerNoteForTrainerWeek(Integer trainerId, Integer weekId);
	Set<TrainerNote> getTrainerNotesByTrainer(Integer trainerId);
	Set<TrainerNote> getTrainerNotesByWeek(Integer weekId);
	void updateTrainerNote(TrainerNote note);
	void deleteTrainerNote(TrainerNote note);
}
