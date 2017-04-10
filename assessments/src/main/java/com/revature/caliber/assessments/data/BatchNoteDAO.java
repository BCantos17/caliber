package com.revature.caliber.assessments.data;

import java.util.List;

import com.revature.caliber.assessments.beans.BatchNote;
import com.revature.caliber.assessments.beans.TrainerNote;

public interface BatchNoteDAO {
	
	//Creates BatchNotes
	/**
	 * Creates BatchNotes for QC using both the batchID, and the weekID
	 * @param batchNote
	 **/
	void createBatchNote(BatchNote batchNote);
		
	/**
	 * Get note by batchNote Id
	 * @param batchNoteId
	 * @return
	 */
	BatchNote getBatchNoteById(int batchNoteId);
	
	//Get BatchNote List using both batchID, and the weekID  
	/**
	 * Create a List of all batchNotes for a specific batch within a week
	 * @param batchId, weekId
	 * @return list
	 * */
	List<BatchNote> getBatchesNotesListInWeek(int batchId, int weekId);	
	
	//Create a List of all BatchNotes
	/**
	 * Creates a List of BatchNotes for every Batch within weekID
	 * @param weekId
	 **/
	List<BatchNote> allBatchNotesByWeek(int weekId);
	
	//Create a List of BatchNotes
	/**
	 * Creates a List of BatchNotes for a specific Batch
	 * @param batchId
	 **/
	List<BatchNote> allBatchNotes(int batchId);
	
	//Update a BatchNote
	/**
	 * Update BatchNote
	 * @param batchNote
	 **/
	void updateBatchNote(BatchNote batchNote);
	
	//Delete a BatchNote
	/**
	 * Delete BatchNote
	 * @param batchNote
	 **/
	void deleteBatchNote(BatchNote batchNote);
}
