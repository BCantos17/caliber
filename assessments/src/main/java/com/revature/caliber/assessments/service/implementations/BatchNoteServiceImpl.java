package com.revature.caliber.assessments.service.implementations;

import com.revature.caliber.assessments.beans.BatchNote;
import com.revature.caliber.assessments.data.Facade;
import com.revature.caliber.assessments.service.BatchNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Batch note service.
 */
@Service(value = "batchNoteService")
class BatchNoteServiceImpl implements BatchNoteService {

    private Facade facade;

    /**
     * Sets facade.
     *
     * @param facade the facade
     */
    @Autowired
    public void setFacade(Facade facade) {
        this.facade = facade;
    }

    @Override
    public void createBatchNote(BatchNote batchNote) {
        facade.makeBatchNote(batchNote);
    }

    @Override
    public List<BatchNote> allBatchNotesInWeek(int weekId) {
        return facade.allBatchNotesInWeek(weekId);
    }

    @Override
    public void updateBatchNote(BatchNote batchNote) {
        facade.updateBatchNote(batchNote);

    }

    @Override
    public List<BatchNote> allBatchNotes(int batchId) {
        return facade.allBatchNotes(batchId);
    }

    @Override
    public void deleteBatchNote(BatchNote batchNote) {
        facade.deleteBatchNote(batchNote);

    }

    @Override
    public List<BatchNote> getBatchesNotesListInWeek(int batchId, int weekId) {
        return facade.getBatchesNotesListInWeek(batchId, weekId);
    }

    @Override
    public BatchNote getBatchNoteById(int batchNoteId) {
        return facade.getBatchNoteById(batchNoteId);
    }

}
