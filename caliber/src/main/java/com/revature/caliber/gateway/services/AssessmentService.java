package com.revature.caliber.gateway.services;

import com.revature.caliber.assessment.beans.*;
import com.revature.caliber.beans.*;
import com.revature.caliber.beans.Assessment;
import com.revature.caliber.beans.BatchNote;
import com.revature.caliber.beans.Category;
import com.revature.caliber.beans.QCNote;
import com.revature.caliber.beans.TrainerNote;

import java.util.List;
import java.util.Set;

public interface AssessmentService {

    /**
     * Inserts Assessment
     *
     * @param assessment an Assessment to be inserted
     */
    long createAssessment(com.revature.caliber.assessment.beans.Assessment assessment);

    /**
     * Updates Assessment
     *
     * @param assessment an Assessment to be updated
     */
    void updateAssessment(com.revature.caliber.assessment.beans.Assessment assessment);

    /**
     * Deletes Assessment
     *
     * @param assessment and Assessment to delete
     */
    void deleteAssessment(com.revature.caliber.assessment.beans.Assessment assessment);

    /**
     * Get all assessments
     *
     */
    List<com.revature.caliber.assessment.beans.Assessment> getAllAssessments();



    /**
     * Get assessments by week id
     *
     */
    List<com.revature.caliber.assessment.beans.Assessment> getAssessmentsByWeekId(long weekId);

    /**
     * Returns a list of grades of a specific assessment based on assessmentId
     * as an input
     *
     * @param assessmentId - The id of the assessment
     */
    List<com.revature.caliber.assessment.beans.Grade> getGradesByAssessment(Integer assessmentId);


    /**
     * Inserts a new Grade into database
     */
    Long insertGrade(com.revature.caliber.assessment.beans.Grade grade);

    /**
     * Updates a grade
     */
    void updateGrade(com.revature.caliber.assessment.beans.Grade grade);

	/**
	 * Get all grades
	 */
	List<com.revature.caliber.assessment.beans.Grade> getAllGrades();

	/**
	 * Create a batchNote
	 */
	void createBatchNote(BatchNote batchNote);

    /**
     * Get the batch note within a given week corresponding to a specific batch
     */
    BatchNote weeklyBatchNote(int batchId, int weekId);

    /**
     * Get a list of all BatchNotes within a given week provided that multiple
     * batches are training simultaneously
     */
    List<BatchNote> allBatchNotesInWeek(int weekId);

    /**
     * Get a list of all BatchNotes for a particular Batch
     */
    List<BatchNote> allBatchNotes(int batchId);

    /**
     * Update a BatchNote
     */
    void updateBatchNote(BatchNote batchNote);

    /**
     * Delete a BatchNote
     */
    void deleteBatchNote(BatchNote batchNote);

    void createQCNote(QCNote note);

    QCNote getQCNoteById(Integer qcNoteId);

    QCNote getQCNoteForTraineeWeek(Integer traineeId, Integer weekId);

    List<QCNote> getQCNotesByTrainee(Integer traineeId);

    List<QCNote> getQCNotesByWeek(Integer weekId);

    void updateQCNote(QCNote note);

    void deleteQCNote(QCNote note);

    void createTrainerNote(TrainerNote note);

    TrainerNote getTrainerNoteById(Integer trainerNoteId);

    TrainerNote getTrainerNoteForTrainerWeek(Integer trainerId, Integer weekId);

    Set<TrainerNote> getTrainerNotesByTrainer(Integer trainerId);

    Set<TrainerNote> getTrainerNotesByWeek(Integer weekId);

    void updateTrainerNote(TrainerNote note);

    void deleteTrainerNote(TrainerNote note);


    /**
     * Returns Set of all Categories
     *
     * @return Set of all Categories
     */
    Set<Category> getAllCategories();


    List<com.revature.caliber.assessment.beans.Grade> getGradesByTraineeId(int id);

}
