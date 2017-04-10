package com.revature.caliber.training.data.implementations;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.caliber.training.beans.Batch;
import com.revature.caliber.training.data.BatchDAO;

@Repository
public class BatchDAOImplementation implements BatchDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional(isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED, rollbackFor = {
			Exception.class })
	public long createBatch(Batch batch) {return (long) sessionFactory.getCurrentSession().save(batch);}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = {
			Exception.class })
	public Set<Batch> getAllBatch() {
		return new HashSet<>(sessionFactory.getCurrentSession().createCriteria(Batch.class).list());
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = {
			Exception.class })
	public Set<Batch> getTrainerBatch(Integer id) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Batch.class);
		criteria.add(Restrictions.eq("trainer.trainerId", id));
		return new HashSet<>(criteria.list());
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = {
			Exception.class })
	public List<Batch> getCurrentBatch() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Batch.class);
		criteria.add(Restrictions.le("startDate", new Date()));
		criteria.add(Restrictions.ge("endDate", new Date()));
		return criteria.list();
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = {
			Exception.class })
	public List<Batch> getCurrentBatch(Integer id) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Batch.class);
		criteria.add(Restrictions.eq("trainer.trainerId", id));
		criteria.add(Restrictions.le("startDate", new Date()));
		criteria.add(Restrictions.ge("endDate", new Date()));
		return criteria.list();
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = {
			Exception.class })
	public Batch getBatch(Integer id) {
		return (Batch) sessionFactory.getCurrentSession().get(Batch.class, id);
	}

	@Transactional(isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED, rollbackFor = {
			Exception.class })
	public void updateBatch(Batch batch) {
		sessionFactory.getCurrentSession().saveOrUpdate(batch);
	}

	@Transactional(isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED, rollbackFor = {
			Exception.class })
	public void deleteBatch(Batch batch) {
		sessionFactory.getCurrentSession().delete(batch);
	}
}
