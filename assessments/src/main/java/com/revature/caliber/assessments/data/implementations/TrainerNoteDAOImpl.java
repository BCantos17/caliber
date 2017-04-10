package com.revature.caliber.assessments.data.implementations;

import com.revature.caliber.assessments.beans.TrainerNote;
import com.revature.caliber.assessments.data.TrainerNoteDAO;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;


@Repository
public class TrainerNoteDAOImpl implements TrainerNoteDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRED,
            rollbackFor = {Exception.class})
    public void createTrainerNote(TrainerNote note) {
        sessionFactory.getCurrentSession().save(note);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRED,
            rollbackFor = {Exception.class})
    public TrainerNote getTrainerNoteById(Integer trainerNoteId) {
        return (TrainerNote) sessionFactory.getCurrentSession().get(TrainerNote.class, trainerNoteId);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRED,
            rollbackFor = {Exception.class})
    public TrainerNote getTrainerNoteForTrainerWeek(Integer trainerId, Integer weekId) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TrainerNote.class);
        criteria.add(Restrictions.eq("trainer", trainerId));
        criteria.add(Restrictions.eq("week", weekId));
        return (TrainerNote) criteria.setMaxResults(1).uniqueResult();
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRED,
            rollbackFor = {Exception.class})
    public Set<TrainerNote> getTrainerNotesByTrainer(Integer trainerId) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TrainerNote.class);
        criteria.add(Restrictions.eq("trainer", trainerId));
        return new HashSet<>(criteria.list());
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRED,
            rollbackFor = {Exception.class})
    public Set<TrainerNote> getTrainerNotesByWeek(Integer weekId) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TrainerNote.class);
        criteria.add(Restrictions.eq("week", weekId));
        return new HashSet<>(criteria.list());
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRED,
            rollbackFor = {Exception.class})
    public void updateTrainerNote(TrainerNote note) {
        sessionFactory.getCurrentSession().update(note);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRED,
            rollbackFor = {Exception.class})
    public void deleteTrainerNote(TrainerNote note) {
        sessionFactory.getCurrentSession().delete(note);
    }
}
