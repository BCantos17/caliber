package com.revature.caliber.training.service;

import java.util.List;
import java.util.Set;

import com.revature.caliber.training.beans.Trainer;

public interface TrainerService {
	void createTrainer(Trainer trainer);

	Trainer getTrainer(Integer id);

	Trainer getTrainer(String email);

	Set<Trainer> getAllTrainers();

	void updateTrainer(Trainer trainer);
}
