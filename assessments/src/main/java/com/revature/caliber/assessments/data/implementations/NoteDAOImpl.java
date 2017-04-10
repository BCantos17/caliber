package com.revature.caliber.assessments.data.implementations;

import com.revature.caliber.assessments.beans.Note;
import com.revature.caliber.assessments.data.NoteDAO;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository(value = "noteDAO")
public class NoteDAOImpl implements NoteDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Transactional(isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRED,
            rollbackFor = {Exception.class})
    public Note getNote(String note) {
        return (Note) sessionFactory.getCurrentSession().get(Note.class, note);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRED,
            rollbackFor = {Exception.class})
    public List<Note> getAllNotes() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Note.class);
        return criteria.list();
    }
}
