package com.revature.caliber.assessments.data;

import java.util.Set;

import com.revature.caliber.assessments.beans.Assessment;
import com.revature.caliber.assessments.beans.QCStatus;

/**
 * DAO interface for QCStatus Object
 */
public interface QCStatusDAO {
	
	/**
	 * Get a list of QCStatus Objects
	 * @return
	 */
	public Set<QCStatus> getAllStatus();
	
	/**
	 * Get a list of Assessment Objects for a specific status
	 * @param status String
	 * @return List of Assessment Objects
	 */
	public Set<Assessment> getAssessmentByStatus(String status);
	
}
