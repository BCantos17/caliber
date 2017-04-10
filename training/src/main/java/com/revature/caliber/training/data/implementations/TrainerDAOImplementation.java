package com.revature.caliber.training.data.implementations;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.caliber.training.beans.Trainer;
import com.revature.caliber.training.data.TrainerDAO;

/**
 * Implementation for trainer DAO crud methods
 * 
 */
@Repository
public class TrainerDAOImplementation implements TrainerDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = {
			Exception.class })
	public void createTrainer(Trainer trainer) {
		sessionFactory.getCurrentSession().save(trainer);
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = {
			Exception.class })
	public Trainer getTrainer(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Trainer.class);
		criteria.add(Restrictions.eq("trainerId", id));
		return (Trainer) criteria.uniqueResult();
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = {
			Exception.class })
	public Trainer getTrainer(String email) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Trainer.class);
		criteria.add(Restrictions.eq("email", email));
		return (Trainer) criteria.uniqueResult();
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = {
			Exception.class })
	public Set<Trainer> getAllTrainers() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Trainer.class);
		return new HashSet<>(criteria.list());
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = {
			Exception.class })
	public void updateTrainer(Trainer trainer) {
		sessionFactory.getCurrentSession().saveOrUpdate(trainer);
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = {
			Exception.class })
	public void deleteTrainer(Trainer trainer) {
		sessionFactory.getCurrentSession().delete(trainer);
	}
}
