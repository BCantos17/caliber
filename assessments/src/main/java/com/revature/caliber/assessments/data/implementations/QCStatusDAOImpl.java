package com.revature.caliber.assessments.data.implementations;

import com.revature.caliber.assessments.beans.Assessment;
import com.revature.caliber.assessments.beans.QCStatus;
import com.revature.caliber.assessments.data.QCStatusDAO;
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

/**
 * Implementations for QCStatus DAO CRUD methods Methods are self-explanatory
 */
@Repository(value = "qcStatusDAO")
public class QCStatusDAOImpl implements QCStatusDAO {

    SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public Set<QCStatus> getAllStatus() {
        return new HashSet<>(sessionFactory.getCurrentSession()
                .createQuery("from com.revature.caliber.assessments.beans.QCStatus").list());
    }

	@Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public Set<Assessment> getAssessmentByStatus(String status) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(QCStatus.class);
		criteria.add(Restrictions.eq("status", status));
        QCStatus s = (QCStatus) criteria.uniqueResult();
        return s.getAssessments();
    }
}
