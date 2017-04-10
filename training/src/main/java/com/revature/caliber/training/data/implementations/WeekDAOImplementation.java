package com.revature.caliber.training.data.implementations;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.caliber.training.beans.Week;
import com.revature.caliber.training.data.WeekDAO;

/**
 * Implementations for Week DAO CRUD methods Methods are self-explanatory
 */
@Repository
public class WeekDAOImplementation implements WeekDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public List<Week> getAllWeeks() {
		return sessionFactory.getCurrentSession().createQuery("from com.revature.caliber.training.beans.Week").list();
	}

	@SuppressWarnings("unchecked")
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public List<Week> getWeekByBatchId(int batchId) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Week.class);
		criteria.add(Restrictions.eq("batch.batchId", batchId));
		return criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Long createWeek(Week newWeek) {
		return (long) sessionFactory.getCurrentSession().save(newWeek);
	}

	@SuppressWarnings("unchecked")
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public List<Week> getWeekByWeekNumber(int weekNumber) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Week.class);
		criteria.add(Restrictions.eq("weekNumber", weekNumber));
		return criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	}

}
