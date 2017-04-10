package com.revature.caliber.training.service;

import java.util.List;

import com.revature.caliber.training.beans.Trainee;

/**
 * Service for trainee (just delegation to facade) methods are the same as in
 * TraineeDAO
 * 
 * @see com.revature.caliber.training.data.TraineeDAO
 */
public interface TraineeService {
	long createTrainee(Trainee trainee);

	void updateTrainee(Trainee trainee);

	Trainee getTrainee(Integer id);

	Trainee getTrainee(String email);

	List<Trainee> getTraineesInBatch(Integer batchId);

	void deleteTrainee(Trainee trainee);

	List<Trainee> getTraineesByTrainer(Long trainerId);
}
