package com.revature.caliber.training.data;

import java.util.List;

import com.revature.caliber.training.beans.Trainee;

/**
 * DAO interface for trainee object
 */
public interface TraineeDAO {

	/**
	 * Creates new trainee
	 * 
	 * @param trainee
	 *            trainee to create
	 */
	long createTrainee(Trainee trainee);

	/**
	 * Update trainee's info
	 * 
	 * @param trainee
	 *            trainee to update (with new info)
	 */
	void updateTrainee(Trainee trainee);

	/**
	 * Get trainee by id.
	 * 
	 * @param id
	 *            id of trainee to get
	 * @return Trainee object, or null if trainee with id doesn't exist
	 */
	Trainee getTrainee(Integer id);

	/**
	 * Get trainee by full name
	 * 
	 * @param email
	 *            email of trainee to get
	 * @return Trainee object or null if trainee with name doesn't exist
	 */
	Trainee getTrainee(String email);

	/**
	 * Get list of trainees for a certain batch
	 * 
	 * @param batchId
	 *            id of the batch
	 * @return list of trainees or an empty list if there is no batch (null?)
	 */
	List<Trainee> getTraineesInBatch(Integer batchId);

	/**
	 * Delete a trainee
	 * 
	 * @param trainee
	 *            trainee to delete
	 */
	void deleteTrainee(Trainee trainee);

	/**
	 * Get all trainees that were trained by a trainer with trainerId
	 * @param trainerId id of that trainer
	 * @return list of trainees
	 */
	List<Trainee> getTraineesByTrainer(Long trainerId);
}
