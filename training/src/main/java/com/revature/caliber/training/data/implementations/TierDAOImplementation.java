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

import com.revature.caliber.training.beans.Tier;
import com.revature.caliber.training.beans.Trainer;
import com.revature.caliber.training.data.TierDAO;

@Repository
public class TierDAOImplementation implements TierDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * Creates a new tier
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = {
			Exception.class })
	public void createTier(Tier tier) {
		sessionFactory.getCurrentSession().save(tier);
	}

	/**
	 * Returns the tier associated with a specific id where id is a <b>short</b>
	 * .
	 */
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Tier getTier(short id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Tier.class);
		criteria.add(Restrictions.eq("tierId", id));
		return (Tier) criteria.uniqueResult();
	}

	/**
	 * Returns the tier associated with a specific name
	 */
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Tier getTier(String name) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Tier.class);
		criteria.add(Restrictions.eq("tier", name));
		return (Tier) criteria.uniqueResult();
	}

	/**
	 * Gets a list of all tiers
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public List<Tier> getAllTiers() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Tier.class);

		return criteria.list();
	}

	/**
	 * Updates a tier
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void updateTier(Tier tier) {
		sessionFactory.getCurrentSession().saveOrUpdate(tier);
	}

	/**
	 * Deletes a tier
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteTier(Tier tier) {
		sessionFactory.getCurrentSession().delete(tier);
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = {
			Exception.class })
	public List<Trainer> getTrainersInTier(short tierId) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Trainer.class);
		criteria.add(Restrictions.eq("tier.tierId", tierId));
		return criteria.list();
	}
}
