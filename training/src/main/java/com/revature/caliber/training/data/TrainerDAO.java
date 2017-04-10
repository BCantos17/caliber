package com.revature.caliber.training.data;

import java.util.List;
import java.util.Set;

import com.revature.caliber.training.beans.Trainer;

/**
 * DAO interface for trainer object
 */
public interface TrainerDAO {

	/**
	 * Creates new trainer
	 * 
	 * @param trainer
	 *            trainer to create
	 */
	void createTrainer(Trainer trainer);

	/**
	 * Gets a trainer by id
	 * 
	 * @param id:
	 *            id of the trainer
	 * @return: Trainer object
	 */
	Trainer getTrainer(Integer id);

	/**
	 * Gets a trainer by email
	 * 
	 * @param email:
	 *            email of the trainer
	 * @return: Trainer object
	 */
	Trainer getTrainer(String email);

	/**
	 * Gets a list of all trainers
	 * 
	 * @return: a list of Trainer objects
	 */
	Set<Trainer> getAllTrainers();

	/**
	 * Updates a trainer
	 * 
	 * @param trainer:
	 *            the trainer object to update
	 */
	void updateTrainer(Trainer trainer);

	void deleteTrainer(Trainer trainer);
}
