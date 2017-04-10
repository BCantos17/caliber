package com.revature.caliber.assessments.data;

import com.revature.caliber.assessments.beans.Category;
import com.revature.caliber.assessments.beans.Grade;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface GradeDAO {

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

	//Aggregate Functions
	HashMap<Integer, Double> avgGradesOfTrainees();
	
	Map<Long, Double> avgGradesOfAssessments();

	Map<Set<Category>, Double> gradeByCategory(int traineeId);
	
	Map<Long, Double> gradeByWeek(int traineeId);

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