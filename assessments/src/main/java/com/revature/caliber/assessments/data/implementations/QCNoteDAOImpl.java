package com.revature.caliber.assessments.data.implementations;


import com.revature.caliber.assessments.beans.QCNote;
import com.revature.caliber.assessments.data.QCNoteDAO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class QCNoteDAOImpl implements QCNoteDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRED,
            rollbackFor = {Exception.class})
    public void createQCNote(QCNote note) {
        Session session = sessionFactory.getCurrentSession();
        session.save(note);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,
                    propagation = Propagation.REQUIRED,
                    rollbackFor = {Exception.class})
    public QCNote getQCNoteById(Integer qcNoteId) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(QCNote.class);
        criteria.add(Restrictions.eq("noteId", qcNoteId));
        return (QCNote)criteria.uniqueResult();
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRED,
            rollbackFor = {Exception.class})
    public QCNote getQCNoteForTraineeWeek(Integer traineeId, Integer weekId) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(QCNote.class);
        criteria.add(Restrictions.eq("trainee", traineeId));
        criteria.add(Restrictions.eq("week", weekId));
        return (QCNote) criteria.setMaxResults(1).uniqueResult();
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRED,
            rollbackFor = {Exception.class})
    public List<QCNote> getQCNotesByTrainee(Integer traineeId) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(QCNote.class);
        criteria.add(Restrictions.eq("trainee", traineeId));
        return criteria.list();
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRED,
            rollbackFor = {Exception.class})
    public List<QCNote> getQCNotesByWeek(Integer weekId) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(QCNote.class);
        criteria.add(Restrictions.eq("week", weekId));
        return criteria.list();
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRED,
            rollbackFor = {Exception.class})
    public void updateQCNote(QCNote note) {
        Session session = sessionFactory.getCurrentSession();
        session.update(note);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRED,
            rollbackFor = {Exception.class})
    public void deleteQCNote(QCNote note) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(note);
    }
}
