package com.revature.caliber.data.implementations;

import com.revature.caliber.training.beans.Tier;
import com.revature.caliber.training.beans.Trainer;
import com.revature.caliber.training.data.TrainerDAO;
import org.apache.log4j.Logger;
import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Test for TrainerDAOImplementation.
 */
public class TrainerDAOImplementationTest {

	private static AbstractApplicationContext context;
	private static Logger logger;
	private static Trainer trainer = null;

	@BeforeClass
	public static void preClass() {
		context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/beans.xml");
		logger = Logger.getRootLogger();
		logger.debug("\n--- TRAINER DAO IMPLEMENTATION TEST START ---\n");
	}

	public static void populateData() {
		Tier tier = new Tier();
		tier.setTierId((short) 1);
		trainer = new Trainer();
		trainer.setName("Bob Miller");
		trainer.setTitle("Trainer at QC");
		trainer.setEmail("bmiller@revature.com");
		trainer.setSalesforceAccount("salesforceAccountEXAMPLE");
		trainer.setSalesforceAuthenticationToken("salesforceAuthenticationTokenEXAMPLE");
		trainer.setSalesforceRefreshToken("salesforceRefreshTokenEXAMPLE");
		trainer.setTier(tier);
	}

	@Before
	public void before() {
		populateData();
	}

	public static void deleteData() {
		TrainerDAO trainerDao = (TrainerDAO) context.getBean(TrainerDAO.class);
		trainerDao.deleteTrainer(trainer);
	}

	@After
	public void after() {
		deleteData();
	}

	@AfterClass
	public static void afterClass() {
	    context.registerShutdownHook();
		logger.debug("\n--- TRAINER DAO IMPLEMENTATION TEST END ---\n");
	}

	@Test
	public void createTrainerTest() {
		logger.debug("   Create trainer test.");
		TrainerDAO trainerDao = (TrainerDAO) context.getBean(TrainerDAO.class);

		trainerDao.createTrainer(trainer);
		assertTrue(true);

		logger.debug("     trainer created");
	}

	@Test
	public void getTrainerGetByIdTest() {
		logger.debug("   Get trainer by id test.");

		TrainerDAO trainerDao = (TrainerDAO) context.getBean(TrainerDAO.class);

		trainerDao.createTrainer(trainer);
		assertNotNull(trainer);

		int id = trainer.getTrainerId();

		Trainer findingTrainer = trainerDao.getTrainer(id);
		assertNotNull(findingTrainer);
		assertEquals(id, findingTrainer.getTrainerId());

		logger.debug("     trainer that I got:" + findingTrainer);
		logger.debug("       trainer id: " + findingTrainer.getTrainerId());
	}

	@Test
	public void getTrainerGetByEmailTest() {
		logger.debug("   Get trainer by email test.");

		TrainerDAO trainerDao = (TrainerDAO) context.getBean(TrainerDAO.class);

		trainerDao.createTrainer(trainer);
		assertNotNull(trainer);

		Trainer findingTrainer = trainerDao.getTrainer("bmiller@revature.com");
		assertNotNull(findingTrainer);
		assertEquals("bmiller@revature.com", findingTrainer.getEmail());

		logger.debug("     trainer that I got:" + trainer);
		logger.debug("       trainer email: " + trainer.getEmail());
	}

	@Test
	public void getAllTrainersTest() {
		logger.debug("   Get all trainers test.");

		TrainerDAO trainerDao = (TrainerDAO) context.getBean(TrainerDAO.class);

		Set<Trainer> trainers = trainerDao.getAllTrainers();

		assertNotNull(trainers);
		logger.debug("     trainers that I got " + trainers);
		logger.debug("     their size(should be at least 1): " + trainers.size());
	}

	@Test
	public void updateTrainerTest() {
		logger.debug("   Update trainer test.");

		TrainerDAO trainerDao = (TrainerDAO) context.getBean(TrainerDAO.class);

		trainerDao.createTrainer(trainer);
		assertNotNull(trainer);

		String newName = "Lila Miller";
		trainer.setName(newName);

		int id = trainer.getTrainerId();
		trainerDao.updateTrainer(trainer);
		logger.debug("     updated trainer");
		Trainer updatedTrainer = trainerDao.getTrainer(id);
		assertNotNull(updatedTrainer);
		assertEquals(id, updatedTrainer.getTrainerId());

		logger.debug("     checking trainer:");
		logger.debug("       trainer that I got: " + updatedTrainer);
		logger.debug("       its id: " + updatedTrainer.getTrainerId());
	}
	
	@After
	public void close() {
		((AbstractApplicationContext) context).registerShutdownHook();
	}
}