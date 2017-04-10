package com.revature.caliber.data.implementations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.revature.caliber.training.beans.Batch;
import com.revature.caliber.training.beans.Trainee;
import com.revature.caliber.training.data.TraineeDAO;

/**
 * Test for TraineeDAOImplementation.
 * Ignored test since DAO is completed
 * @author Ilya
 */
@Ignore
public class TraineeDAOImplementationTest {

	private static ApplicationContext context;
	private static SessionFactory sf;
	private static final Logger logger = LoggerFactory.getLogger(TraineeDAOImplementationTest.class);

	private static int newTierId;
	private static int newTrainerId;
	private static int newBatchId;
	private static int newTraineeId;

	/*
	 * Helper method to find a free id in db and create a test trainee with it.
	 * Has to be used between
	 * Transaction tx = session.beginTransaction()
	 * and
	 * tx.commit();
	 * Also execute only after new batch with newBatchId was created (variable is set up).
	 */
	private static int findFreeTraineeIdAnCreateTrainee(Session session, String name, String email) {

        String sql;
        int id;
        int resultNum;

        int resultId;

        sql = "SELECT TRAINEE_ID from CALIBER_TRAINEE";
        Query q = session.createSQLQuery(sql);

        List<BigDecimal> list = q.list();
        list.sort(BigDecimal::compareTo);

        id = 1;
        for (BigDecimal objId : list) {
            if (objId.intValue() == id) { id++; }
        }

        resultId = id;

        sql = "INSERT INTO CALIBER_TRAINEE(TRAINEE_ID, TRAINEE_EMAIL, TRAINEE_NAME, TRAINING_STATUS, BATCH_ID) "
                + "VALUES(?, ?, ?, ?, ?)";
        Query traineeq = session.createSQLQuery(sql);
        traineeq.setInteger(0, resultId);
        traineeq.setString(1, email);
        traineeq.setString(2, name);
        traineeq.setString(3, "new_status");
        traineeq.setInteger(4, newBatchId);

        resultNum = traineeq.executeUpdate();

        if (resultNum != 1) {
            fail("Failed to create test Batch");
        }

        return resultId;
    }

    /*
     * Another helper method to delete data from db.
     * Also has to be used after transaction opening.
     * Returns the number of rows affected.
     */
    private static int deleteTrainee(Session session, int traineeId) {

        int rowsAffected;

        String sql;
        Query q;

        sql = "DELETE FROM CALIBER_TRAINEE WHERE TRAINEE_ID = ?";
        q = session.createSQLQuery(sql);
        q.setInteger(0, traineeId);
        rowsAffected = q.executeUpdate();

        return rowsAffected;
    }


	@BeforeClass
	public static void preClass() {
		context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/beans.xml");

        logger.info("\n--- TRAINEE DAO IMPLEMENTATION TEST START ---\n");
        logger.info(" > Creating test db data (preClass)");

		// create transient SQL test data
		sf = (SessionFactory) context.getBean("sessionFactory");
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

        String sql;
        int id;
        int resultNum;

        sql = "SELECT TIER_ID from CALIBER_TIER";
        Query q = session.createSQLQuery(sql);

        List<BigDecimal> list = q.list();
        list.sort(BigDecimal::compareTo);

        id = 1;
        for (BigDecimal objId : list) {
            if (objId.intValue() == id) { id++; }
        }

        newTierId = id;

        sql = "INSERT INTO CALIBER_TIER(TIER_ID, RANKING, TIER) VALUES(?, ?, ?)";
        Query tierq = session.createSQLQuery(sql);
        tierq.setInteger(0, newTierId);
        tierq.setInteger(1, 999);
        tierq.setString(2, "Test tier (TraineeDAO Test)");

        resultNum = tierq.executeUpdate();

        if (resultNum != 1) {
            fail("Failed to create test tier");
        }

        sql = "SELECT TRAINER_ID from CALIBER_TRAINER";
        q = session.createSQLQuery(sql);

        list = q.list();
        list.sort(BigDecimal::compareTo);

        id = 1;
        for (BigDecimal objId : list) {
            if (objId.intValue() == id) { id++; }
        }

        newTrainerId = id;

        sql = "INSERT INTO CALIBER_TRAINER(TRAINER_ID, EMAIL, NAME, SF_ACCOUNT, SF_AUTHENTICATION_TOKEN, SF_REFRESH_TOKEN, TITLE, TIER) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        Query trainerq = session.createSQLQuery(sql);
        trainerq.setInteger(0, newTrainerId);
        trainerq.setString(1, "email");
        trainerq.setString(2, "Test trainee (TraineeDAO Test)");
        trainerq.setString(3, "sf_account");
        trainerq.setString(4, "sf_auth_token");
        trainerq.setString(5, "sf_refr_token");
        trainerq.setString(6, "title");
        trainerq.setInteger(7, newTierId);

        resultNum = trainerq.executeUpdate();

        if (resultNum != 1) {
            fail("Failed to create test Trainer");
        }

        sql = "SELECT BATCH_ID from CALIBER_BATCH";
        q = session.createSQLQuery(sql);

        list = q.list();
        list.sort(BigDecimal::compareTo);

        id = 1;
        for (BigDecimal objId : list) {
            if (objId.intValue() == id) { id++; }
        }

        newBatchId = id;

        sql = "INSERT INTO CALIBER_BATCH(BATCH_ID, BORDERLINE_GRADE_THRESHOLD, END_DATE, GOOD_GRADE_THRESHOLD, LOCATION, SKILL_TYPE, START_DATE, TRAINING_NAME, TRAINING_TYPE, TRAINER_ID)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Query batchq = session.createSQLQuery(sql);
        batchq.setInteger(0, newBatchId);
        batchq.setInteger(1, 10);
        batchq.setString(2, "13-NOV-13");
        batchq.setInteger(3, 11);
        batchq.setString(4, "test location");
        batchq.setString(5, "test skill_type");
        batchq.setString(6, "15-NOV-13");
        batchq.setString(7, "Test batch (TraineeDAO test)");
        batchq.setString(8, "type");
        batchq.setInteger(9, newTrainerId);

        resultNum = batchq.executeUpdate();

        if (resultNum != 1) {
            fail("Failed to create test Batch");
        }

        newTraineeId = findFreeTraineeIdAnCreateTrainee(session, "Some test trainee(Trainee DAO Test)", "testemail");

		tx.commit();
		session.close();
		// end of creating data
        logger.info("    .. data created, tierId " + newTierId + ", batchId " + newBatchId +
                ", trainerId " + newTrainerId + ", traineeId " + newTraineeId);

	}

	@AfterClass
	public static void afterClass() {

        logger.info(" > Deleting created data (afterClass)");
		// Delete created data
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

        int rowsAffected = 0;
        rowsAffected += deleteTrainee(session, newTraineeId);

        String sql;
        Query q;

        sql = "DELETE FROM CALIBER_BATCH WHERE BATCH_ID = ?";
        q = session.createSQLQuery(sql);
        q.setInteger(0, newBatchId);
        rowsAffected += q.executeUpdate();

        sql = "DELETE FROM CALIBER_TRAINER WHERE TRAINER_ID = ?";
        q = session.createSQLQuery(sql);
        q.setInteger(0, newTrainerId);
        rowsAffected += q.executeUpdate();

        sql = "DELETE FROM CALIBER_TIER WHERE TIER_ID = ?";
        q = session.createSQLQuery(sql);
        q.setInteger(0, newTrainerId);
        rowsAffected += q.executeUpdate();

		tx.commit();
		session.close();
		// end delete of data
        logger.info("    .. data was deleted, rows affected: " + rowsAffected);

		logger.info("\n--- TRAINEE DAO IMPLEMENTATION TEST END ---\n");
	}

	@Test
	public void createTraineeTest() {
		logger.info(" > Create trainee test.");

		TraineeDAO dao = context.getBean(TraineeDAO.class);

		Batch batch = new Batch();
		batch.setBatchId(newBatchId);

		Trainee trainee = new Trainee();
		trainee.setTraineeId(1);
		trainee.setName("Super Mario Bros (Trainee DAO Test)");
		trainee.setEmail("tismario@mario.io");
		trainee.setTrainingStatus("Super Dope");
		trainee.setBatch(batch);

		dao.createTrainee(trainee);

        //check if trainee was created
        Session session = sf.openSession();
        String sql = "SELECT TRAINEE_ID, TRAINEE_NAME, TRAINEE_EMAIL FROM CALIBER_TRAINEE" +
                " WHERE TRAINEE_NAME = ?";
        Query q = session.createSQLQuery(sql);
        q.setString(0, "Super Mario Bros (Trainee DAO Test)");

        Object[] result = (Object[]) q.uniqueResult();
        assertEquals(trainee.getName(), result[1]);
        assertEquals(trainee.getEmail(), result[2]);


		logger.info("    .. trainee was successfully created with id " + ((BigDecimal)result[0]).intValue()
            + ", name \"" + result[1] + "\", and email \"" + result[2] + "\"");

		logger.info("    .. doing cleanup");
		Transaction tx = session.beginTransaction();
		int rowsAffected = deleteTrainee(session, ((BigDecimal)result[0]).intValue());
		tx.commit();
		session.close();
        logger.info("    .. cleanup complete, rows affected:" + rowsAffected);
		logger.info("    -- creating trainee test completed.");
	}

	@Test
	public void getTraineeTestGetById() {
		logger.info(" > Get trainee by id test.");

		TraineeDAO dao = context.getBean(TraineeDAO.class);

		logger.info("    .. using id " + newTraineeId);
		Trainee trainee = dao.getTrainee(newTraineeId);

		assertNotNull(trainee);
		assertEquals(newTraineeId, trainee.getTraineeId());

		logger.info("    .. trainee received with id: " + trainee.getTraineeId());
		logger.info("    -- getting trainee by id test completed.");
	}

	@Test
	public void getTraineeTestGetByEmail() {
		logger.info(" > Get trainee by email test.");
		logger.info("    .. trying to get previously created trainee \"testemail\"");

		TraineeDAO dao = context.getBean(TraineeDAO.class);

		Trainee trainee = dao.getTrainee("testemail");

		assertNotNull(trainee);
		assertEquals("testemail", trainee.getEmail());

		logger.info("    .. received trainee with name: " + trainee.getName());
		logger.info("    -- getting trainee by name test completed.");
	}

	@Test
	public void getTraineesInBatchTest() {
		logger.info(" > Get trainees in a batch test.");
		logger.info("    .. trying to get all trainees for the batch with id: " + newBatchId);

		TraineeDAO dao = context.getBean(TraineeDAO.class);

		List<Trainee> trainees = dao.getTraineesInBatch(newBatchId);

		assertNotNull(trainees);
		assertNotEquals(0, trainees.size());


		logger.info("    .. got some trainees, list size: " + trainees.size() + " (expected > 0)");
		logger.info("    -- getting trainees by batch test completed.");
	}

	@Test
	public void updateTraineeTest() {
		logger.info(" > Update trainee test.");

		logger.info("    .. creating a test trainee");
		Session session  = sf.openSession();
		Transaction tx = session.beginTransaction();
		int id = findFreeTraineeIdAnCreateTrainee(session, "Some other test trainee(yup).", "someotheremail");
		tx.commit();

		logger.info("    .. trainee created with id " + id);

		TraineeDAO dao = context.getBean(TraineeDAO.class);

		Trainee trainee = dao.getTrainee(id);
		assertNotNull(trainee);

		String oldName = trainee.getName();
		String newName = "Trololo lolo lolo";
		trainee.setName(newName);

		dao.updateTrainee(trainee);

		logger.info("    .. updated trainee, get it again and check.");

		trainee = dao.getTrainee(id);
		assertNotNull(trainee);
		assertEquals(newName, trainee.getName());
		assertNotEquals(oldName, trainee.getName());

		logger.info("    .. trainee's name successfully changed from \"" + oldName + "\" to \"" + trainee.getName() + "\"");
		logger.info("    .. cleanup");
		tx = session.beginTransaction();
		int rowsAffected = deleteTrainee(session, id);
		tx.commit();
		session.close();

		logger.info("    .. cleanup completed, rows affected: " + rowsAffected);
		logger.info("    -- updating trainee test completed.");
	}

	@Test
	public void deleteTraineeTest() {
		logger.info(" > Delete trainee test.");
		logger.info("    .. creating trainee to delete");

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		int id = findFreeTraineeIdAnCreateTrainee(session, "Test trainee that will be deleted.", "deleteemail");
		tx.commit();

		logger.info("    .. trainee was created with id " + id);

		TraineeDAO dao = context.getBean(TraineeDAO.class);

		Trainee trainee = dao.getTrainee(id);
		assertNotNull(trainee);

		dao.deleteTrainee(trainee);

		trainee = dao.getTrainee(id);
		assertNull(trainee);

		logger.info("    .. trainee with id [" + id + "] was deleted");
		logger.info("    -- deleting trainee test completed.");
	}
	
	@After
	public void close() {
		((AbstractApplicationContext) context).registerShutdownHook();
	}

}