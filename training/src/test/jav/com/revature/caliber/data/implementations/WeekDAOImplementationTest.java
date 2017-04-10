package com.revature.caliber.data.implementations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.revature.caliber.training.beans.Week;
import com.revature.caliber.training.data.WeekDAO;

public class WeekDAOImplementationTest {

	private static ApplicationContext context;
	private static SessionFactory sf;
	private static Logger logger;

	@BeforeClass
	public static void preClass() {
		context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/beans.xml");
		sf = context.getBean(SessionFactory.class);

		logger = Logger.getRootLogger();
		logger.debug("\n--- WEEK DAO IMPLEMENTATION TEST START ---\n");
	}

	@Test
	public void getWeekByWeekNumberTest() {
		logger.debug("Getting Week records for specific week Test");
		WeekDAO dao = context.getBean(WeekDAO.class);

		List<Week> listOfWeeks = new ArrayList<Week>();

		logger.debug(" fetching all week records where batch weekNumber = 1 \n");
		listOfWeeks = dao.getWeekByWeekNumber(1);

		assertEquals(1, listOfWeeks.get(0).getWeekNumber());
		logger.debug(" successfully fetched week records where weekNumber = 1  \n");
	}

	@Test
	public void getWeekByBatchIdTest() {
		logger.debug("Getting Week records for specific batch Test");
		WeekDAO dao = context.getBean(WeekDAO.class);

		List<Week> listOfWeeks = new ArrayList<Week>();

		logger.debug(" fetching all week records where batch id = 1 \n");
		listOfWeeks = dao.getWeekByBatchId(1);

		assertNotNull(listOfWeeks);;
		logger.debug(" successfully fetched all week records  \n");

	}

	@Test
	public void getAllWeekTest() {
		logger.debug("Getting all Week records Test. \n");
		WeekDAO dao = context.getBean(WeekDAO.class);

		List<Week> listOfWeeks = new ArrayList<Week>();

		logger.debug(" fetching all week records \n");
		listOfWeeks = dao.getAllWeeks();

		assertNotNull(listOfWeeks);
		logger.debug(" successfully fetched all week records  \n");
	}

	@Test
	public void createWeekTest() {
		logger.debug("Creating a new Week Test. \n");
		WeekDAO dao = context.getBean(WeekDAO.class);

		logger.debug(" creating test object");
		Week newWeek = new Week();
		newWeek.setBatch(null);
		newWeek.setWeekNumber(999);
		newWeek.setTopics(null);

		logger.debug(" inserting test object into DB \n");
		dao.createWeek(newWeek);
		assertTrue(true);

		logger.debug(" succesfully inserted test object into DB \n");

		logger.debug(" deleting test object from DB \n");
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		String sql = "";
		Query q;

		sql = "DELETE FROM CALIBER_WEEK WHERE WEEK_NUMBER = ?";
		q = session.createSQLQuery(sql);

		q.setInteger(0, 999);
		q.executeUpdate();

		tx.commit();
		session.close();
	}
	
	@After
	public void close() {
		((AbstractApplicationContext) context).registerShutdownHook();
	}

}
