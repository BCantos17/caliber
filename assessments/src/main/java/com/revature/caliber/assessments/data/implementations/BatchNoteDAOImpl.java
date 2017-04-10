package com.revature.caliber.assessments.data.implementations;

import com.revature.caliber.assessments.beans.BatchNote;
import com.revature.caliber.assessments.data.BatchNoteDAO;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository(value = "batchNoteDAO")
public class BatchNoteDAOImpl implements BatchNoteDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    //Create BatchNote
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = {
            Exception.class})
    public void createBatchNote(BatchNote batchNote) {
        sessionFactory.getCurrentSession().save(batchNote);
    }

    //Get a List of BatchNotes for a batch within a week pertaining to a single Batch
    //If two trainers have separate feedback
    @SuppressWarnings("unchecked")
	@Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = {
            Exception.class})
    public List<BatchNote> getBatchesNotesListInWeek(int batchId, int weekId) {
        return (List<BatchNote>) sessionFactory.getCurrentSession().createCriteria(BatchNote.class)
                .add(Restrictions.eq("batch", batchId))
                .add(Restrictions.eq("week", weekId)).list();
    }
    
    
    //List all BatchNotes within a given week
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = {
            Exception.class})
    @SuppressWarnings("unchecked")
    public List<BatchNote> allBatchNotesByWeek(int weekId) {
        return (List<BatchNote>) sessionFactory.getCurrentSession().createCriteria(BatchNote.class)
                .add(Restrictions.eq("week", weekId)).list();
    }

    //Update a BatchNote
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = {
            Exception.class})
    public void updateBatchNote(BatchNote batchNote) {
        sessionFactory.getCurrentSession().update(batchNote);
    }


    //List all batchNotes for a specific batch for the duration of Training
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = {
            Exception.class})
	public List<BatchNote> allBatchNotes(int batchId) {
		 return (List<BatchNote>) sessionFactory.getCurrentSession().createCriteria(BatchNote.class)
	             .add(Restrictions.eq("batch", batchId)).list();
	}

	//Delete a BatchNote
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = {
            Exception.class})
	public void deleteBatchNote(BatchNote batchNote) {
		sessionFactory.getCurrentSession().delete(batchNote);
	}

	//Get a BatchNote by a specific ID
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = {
            Exception.class})
	public BatchNote getBatchNoteById(int batchNoteId) {
		return (BatchNote) sessionFactory.getCurrentSession().get(BatchNote.class, batchNoteId);
	}
    
}
