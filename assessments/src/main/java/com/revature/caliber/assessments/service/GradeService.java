package com.revature.caliber.assessments.service;

import java.util.List;

import com.revature.caliber.assessments.beans.Grade;

public interface GradeService {
	
	/**
	 * Returns a list of all grade entries
	 */
	List<Grade> getAllGrades();

	/**
	 * Returns a grade object given a specific gradeId
	 */
	Grade getGradeByGradeId(long gradeId);

	/**
	 * Returns a list of grades of a specific trainee based on traineeId as an
	 * input
	 * 
	 * @param traineeId
	 */
	List<Grade> getGradesByTraineeId(int traineeId);

	/**
	 * Returns a list of grades of a specific assessment based on assessmentId
	 * as an input
	 * 
	 * @param assessmentId
	 */
	List<Grade> getGradesByAssessment(long assessmentId);

	// Insert
	/**
	 * Inserts a new Grade into database
	 */
	Long insertGrade(Grade grade);

	// Delete
	/**
	 * Deletes a grade
	 */
	void deleteGrade(Grade grade);

	// Update
	/**
	 * Updates a grade
	 */
	void updateGrade(Grade grade);

}