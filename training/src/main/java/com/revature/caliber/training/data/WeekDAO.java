package com.revature.caliber.training.data;

import java.util.List;
import com.revature.caliber.training.beans.Week;

/**
 * DAO interface for Week Object
 */
public interface WeekDAO {

	/**
	 * Get a list of all weeks
	 * 
	 * @return list of Week objects
	 */
	List<Week> getAllWeeks();

	/**
	 * Get a list of weeks from a specific Training Batch
	 * 
	 * @param batchId
	 *            integer
	 * @return list of Week objects
	 */
	List<Week> getWeekByBatchId(int batchId);

	/**
	 * Get a list of weeks that based on a given weekNumber
	 * 
	 * @param weekNumber
	 *            integer
	 * @return list of Week objects
	 */
	List<Week> getWeekByWeekNumber(int weekNumber);

	/**
	 * Create a new Week
	 * 
	 * @param Week
	 *            object
	 */
	Long createWeek(Week newWeek);

}
