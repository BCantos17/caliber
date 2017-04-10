package com.revature.caliber.assessments.data;

import java.util.Set;

import com.revature.caliber.assessments.beans.TrainerNote;

public interface TrainerNoteDAO {

	/**
	 * create a trainer note
	 * @param note
	 */
	void createTrainerNote(TrainerNote note);

	/**
	 * Get note by trainerNote id
	 * @param trainerNoteId
	 * @return
	 */
	TrainerNote getTrainerNoteById(Integer trainerNoteId);

	/**
	 * get note by trainer id and week id
	 * @param trainerId
	 * @param weekId
	 * @return
	 */
	TrainerNote getTrainerNoteForTrainerWeek(Integer trainerId, Integer weekId);

	/**
	 * get note by trainer id
	 * @param trainerId
	 * @return
	 */
	Set<TrainerNote> getTrainerNotesByTrainer(Integer trainerId);

	/**
	 * get trainer note by week id
	 * @param weekId
	 * @return
	 */
	Set<TrainerNote> getTrainerNotesByWeek(Integer weekId);

	/**
	 * update note
	 * @param note
	 */
	void updateTrainerNote(TrainerNote note);

	/**
	 * delete note
	 * @param note
	 */
	void deleteTrainerNote(TrainerNote note);
}
