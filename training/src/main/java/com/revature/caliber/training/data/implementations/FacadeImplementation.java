package com.revature.caliber.training.data.implementations;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.caliber.training.beans.Batch;
import com.revature.caliber.training.beans.Category;
import com.revature.caliber.training.beans.Trainee;
import com.revature.caliber.training.beans.Trainer;
import com.revature.caliber.training.beans.Week;
import com.revature.caliber.training.data.BatchDAO;
import com.revature.caliber.training.data.CategoryDAO;
import com.revature.caliber.training.data.Facade;
import com.revature.caliber.training.data.TierDAO;
import com.revature.caliber.training.data.TraineeDAO;
import com.revature.caliber.training.data.TrainerDAO;
import com.revature.caliber.training.data.WeekDAO;

/**
 * Our implementation of Facade interface.
 */

@Component
public class FacadeImplementation implements Facade {

	TraineeDAO traineeDAO;
	BatchDAO batchDAO;
	CategoryDAO categoryDAO;
	TierDAO tierDAO;
	TrainerDAO trainerDAO;
	WeekDAO weekDAO;

	@Autowired
	public void setTrainerDAO(TrainerDAO trainerDAO) {
		this.trainerDAO = trainerDAO;
	}

	@Autowired
	public void setTierDAO(TierDAO tierDAO) {
		this.tierDAO = tierDAO;
	}

	@Autowired
	public void setWeekDAO(WeekDAO weekDAO) {
		this.weekDAO = weekDAO;
	}

	@Autowired
	public void setTraineeDAO(TraineeDAO traineeDAO) {
		this.traineeDAO = traineeDAO;
	}

	@Autowired
	public void setBatchDAO(BatchDAO batchDAO) {
		this.batchDAO = batchDAO;
	}

	@Autowired
	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	// Trainee
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public long createTrainee(Trainee trainee) {
		return traineeDAO.createTrainee(trainee);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void updateTrainee(Trainee trainee) {
		traineeDAO.updateTrainee(trainee);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Trainee getTrainee(Integer id) {
		return traineeDAO.getTrainee(id);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Trainee getTrainee(String email) { return traineeDAO.getTrainee(email); }

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public List<Trainee> getTraineesInBatch(Integer batchId) {
		return traineeDAO.getTraineesInBatch(batchId);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void deleteTrainee(Trainee trainee) {
		traineeDAO.deleteTrainee(trainee);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public List<Trainee> getTraineesByTrainer(Long trainerId) { return traineeDAO.getTraineesByTrainer(trainerId); }
	// end of trainee

	// Batch

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Long createBatch(Batch batch) {
		return batchDAO.createBatch(batch);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Set<Batch> getAllBatch() { return batchDAO.getAllBatch(); }

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Set<Batch> getTrainerBatch(Integer id) {
		return batchDAO.getTrainerBatch(id);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public List<Batch> getCurrentBatch() {
		return batchDAO.getCurrentBatch();
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public List<Batch> getCurrentBatch(Integer id) {
		return batchDAO.getCurrentBatch(id);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Batch getBatch(Integer id) {
		return batchDAO.getBatch(id);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void updateBatch(Batch batch) {
		batchDAO.updateBatch(batch);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void deleteBatch(Batch batch) {
		batchDAO.deleteBatch(batch);
	}
	// end batch

	// Category
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Category getCategory(int categoryId) {
		return categoryDAO.getCategory(categoryId);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public List<Category> getAllCategories() {
		return categoryDAO.getAllCategories();
	}
	// End Category

	// Trainer
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void createTrainer(Trainer trainer) {
		trainerDAO.createTrainer(trainer);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Trainer getTrainer(Integer id) {
		return trainerDAO.getTrainer(id);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Trainer getTrainer(String email) {
		return trainerDAO.getTrainer(email);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Set<Trainer> getAllTrainers() {
		return trainerDAO.getAllTrainers();
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void updateTrainer(Trainer trainer) {
		trainerDAO.updateTrainer(trainer);
	}
	// End Trainer

	//Week
    @Transactional (propagation = Propagation.REQUIRES_NEW)
	public List<Week> getAllWeeks() { return weekDAO.getAllWeeks(); }

    @Transactional (propagation = Propagation.REQUIRES_NEW)
	public List<Week> getWeekByBatchId(int batchId) { return weekDAO.getWeekByBatchId(batchId); }

    @Transactional (propagation = Propagation.REQUIRES_NEW)
	public List<Week> getWeekByWeekNumber(int weekNumber) { return weekDAO.getWeekByWeekNumber(weekNumber); }

    @Transactional (propagation = Propagation.REQUIRES_NEW)
	public Long createWeek(Week newWeek) { return weekDAO.createWeek(newWeek); }
    //End Week
}
