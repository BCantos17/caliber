package com.revature.caliber.training.service.implementations;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.caliber.training.beans.Trainer;
import com.revature.caliber.training.data.Facade;
import com.revature.caliber.training.service.TrainerService;

@Component
public class TrainerServiceImplementation implements TrainerService {

	Facade facade;

	@Autowired
	public void setFacade(Facade facade) {
		this.facade = facade;
	}

	@Override
	public void createTrainer(Trainer trainer) {
		facade.createTrainer(trainer);
	}

	@Override
	public Trainer getTrainer(Integer id) {
		return facade.getTrainer(id);
	}

	@Override
	public Trainer getTrainer(String email) {
		return facade.getTrainer(email);
	}

	@Override
	public Set<Trainer> getAllTrainers() {
		return facade.getAllTrainers();
	}

	@Override
	public void updateTrainer(Trainer trainer) {
		facade.updateTrainer(trainer);
	}

}
