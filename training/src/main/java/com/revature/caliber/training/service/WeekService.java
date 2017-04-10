package com.revature.caliber.training.service;

import java.util.List;

import com.revature.caliber.training.beans.Week;

/**
 * Service for Week (just delegation to facade)
 * methods are the same as in WeekDAO
 * @see com.revature.caliber.training.data.TraineeDAO
 */
public interface WeekService {
	
	List<Week> getAllWeeks();
	List<Week> getWeekByBatchId(int batchId);
	List<Week> getWeekByWeekNumber(int weekNumber);
	Long createWeek(Week newWeek);
	
}