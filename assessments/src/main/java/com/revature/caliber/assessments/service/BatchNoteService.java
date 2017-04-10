package com.revature.caliber.assessments.service;

import java.util.List;

import com.revature.caliber.assessments.beans.BatchNote;

public interface BatchNoteService {

	void createBatchNote(BatchNote batchNote);
	
	List<BatchNote> getBatchesNotesListInWeek(int batchId, int weekId);	
	
	List<BatchNote> allBatchNotesInWeek(int weekId);
	
	List<BatchNote> allBatchNotes(int batchId);
	
	void updateBatchNote(BatchNote batchNote);
	
	void deleteBatchNote(BatchNote batchNote);
	
	BatchNote getBatchNoteById(int batchNoteId);
    	
}
