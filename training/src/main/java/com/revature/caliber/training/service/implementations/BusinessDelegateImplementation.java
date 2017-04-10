package com.revature.caliber.training.service.implementations;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.caliber.training.beans.Batch;
import com.revature.caliber.training.beans.Category;
import com.revature.caliber.training.beans.Trainee;
import com.revature.caliber.training.beans.Trainer;
import com.revature.caliber.training.beans.Week;
import com.revature.caliber.training.service.BatchService;
import com.revature.caliber.training.service.BusinessDelegate;
import com.revature.caliber.training.service.CategoryService;
import com.revature.caliber.training.service.TraineeService;
import com.revature.caliber.training.service.TrainerService;
import com.revature.caliber.training.service.WeekService;

/**
 * Implementation for the Business Delegate
 */
@Component(value = "trainingBusinessDelegateImplementation")
public class BusinessDelegateImplementation implements BusinessDelegate {


    TraineeService traineeService;
    @Autowired
    public void setTraineeService(TraineeService traineeService) { this.traineeService = traineeService; }

    BatchService batchService;
    @Autowired
    public void setBatchService(BatchService batchService) {this.batchService = batchService;}
    
    TrainerService trainerService;
    @Autowired
    public void setTrainerService(TrainerService trainerService) {this.trainerService = trainerService;}
    
    CategoryService categoryService;
    @Autowired
    public void setCategoryService(CategoryService categoryService){this.categoryService = categoryService;}
    
    WeekService weekService;
    @Autowired
    public void setWeekService(WeekService weekService) { this.weekService = weekService; }



	// trainee
	public long createTrainee(Trainee trainee) {
		return traineeService.createTrainee(trainee);
	}

	public void updateTrainee(Trainee trainee) {
		traineeService.updateTrainee(trainee);
	}

	public Trainee getTrainee(Integer id) {
		return traineeService.getTrainee(id);
	}

	public Trainee getTrainee(String email) { return traineeService.getTrainee(email); }

	public List<Trainee> getTraineesInBatch(Integer batchId) {
		return traineeService.getTraineesInBatch(batchId);
	}

	public void deleteTrainee(Trainee trainee) {
		traineeService.deleteTrainee(trainee);
	}

	public List<Trainee> getTraineesByTrainer(Long trainerId) { return traineeService.getTraineesByTrainer(trainerId); }
	// end of trainee

	// batch
	public Long createBatch(Batch batch) {
		return batchService.createBatch(batch);
	}

	public Set<Batch> getAllBatch() {
		return batchService.getAllBatch();
	}

	public Set<Batch> getTrainerBatch(Integer id) {
		return batchService.getTrainerBatch(id);
	}

	public List<Batch> getCurrentBatch() {
		return batchService.getCurrentBatch();
	}

	public List<Batch> getCurrentBatch(Integer id) {
		return batchService.getCurrentBatch(id);
	}

	public Batch getBatch(Integer id) {
		return batchService.getBatch(id);
	}

	public void updateBatch(Batch batch) {
		batchService.updateBatch(batch);
	}

	public void deleteBatch(Batch batch) {
		batchService.deleteBatch(batch);
	}
	// end of batch

	// trainer
	public void createTrainer(Trainer trainer) {
		trainerService.createTrainer(trainer);
	}

	public Trainer getTrainer(Integer id) {
		return trainerService.getTrainer(id);
	}

	public Trainer getTrainer(String email) {
		return trainerService.getTrainer(email);
	}

	public Set<Trainer> getAllTrainers() {
		return trainerService.getAllTrainers();
	}

	public void updateTrainer(Trainer trainer) {
		trainerService.updateTrainer(trainer);
	}
	// end of trainer

	// category
	public Category getCategory(int categoryId) {
		return categoryService.getCategory(categoryId);
	}

	public List<Category> getAllCategories() {
		return categoryService.getAllCategories();
	}
	// end of category
	
	//Week
	public List<Week> getAllWeeks() { return weekService.getAllWeeks(); }
	public List<Week> getWeekByBatchId(int batchId) { return weekService.getWeekByBatchId(batchId); }
	public List<Week> getWeekByWeekNumber(int weekNumber) { return weekService.getWeekByWeekNumber(weekNumber); }
	public Long createWeek(Week newWeek) { return weekService.createWeek(newWeek); }

}
