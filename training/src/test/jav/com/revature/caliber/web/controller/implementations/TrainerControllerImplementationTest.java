package com.revature.caliber.web.controller.implementations;

import com.revature.caliber.training.beans.Tier;
import com.revature.caliber.training.beans.Trainer;
import com.revature.caliber.training.data.TrainerDAO;
import com.revature.caliber.training.web.controllers.TrainerController;
import org.apache.log4j.Logger;
import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.http.HttpEntity;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertNotNull;

public class TrainerControllerImplementationTest {
	private static ApplicationContext context;
	private static Logger log;
	private static TrainerController controller;
	private static Trainer trainer = null;

	@BeforeClass
	public static void preClass() {
		context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/beans.xml");
		controller = context.getBean(TrainerController.class);
		log = Logger.getRootLogger();
		log.debug("\n--- TRAINER CONTROLLER IMPLEMENTATION TEST START ---\n");
	}

	public static void populateData() {
		Tier tier = new Tier();
		tier.setTierId((short) 1);
		trainer = new Trainer();
		trainer.setName("Bob Miller");
		trainer.setTitle("Trainer at QC");
		trainer.setEmail("bmiller@revatureeeee.com");
		trainer.setSalesforceAccount("salesforceAccountEXAMPLE");
		trainer.setSalesforceAuthenticationToken("salesforceAuthenticationTokenEXAMPLE");
		trainer.setSalesforceRefreshToken("salesforceRefreshTokenEXAMPLE");
		trainer.setTier(tier);
	}

	@Before
	public void before() {
		populateData();
	}

	@Test
	public void createTrainer() {
		log.debug("Create trainer test.");
		controller.createTrainer(trainer);
		log.debug("Trainer created");
	}

	@Test
	public void getTrainerById() {
		TrainerDAO trainerDao = (TrainerDAO) context.getBean(TrainerDAO.class);
		log.debug("Create trainer by id test.");

		trainerDao.createTrainer(trainer);
		HttpEntity<Trainer> entity = controller.getTrainerById(trainer.getTrainerId());
		Trainer findingTrainer = entity.getBody();

		log.debug("Trainer found by id: " + findingTrainer.getTrainerId());
	}

	@Test
	public void getTrainerByEmail() {
		TrainerDAO trainerDao = (TrainerDAO) context.getBean(TrainerDAO.class);
		log.debug("Create trainer by email test.");

		trainerDao.createTrainer(trainer);
		HttpEntity<Trainer> entity = controller.getTrainerByEmail(trainer.getEmail());
		Trainer findingTrainer = entity.getBody();

		assertNotNull(findingTrainer);
		log.debug("Trainer found by email: " + findingTrainer.getEmail());
	}

	@Test
	public void getAllTrainers() {
		TrainerDAO trainerDao = (TrainerDAO) context.getBean(TrainerDAO.class);
		log.debug("Get all trainers");

		trainerDao.createTrainer(trainer);
		HttpEntity<Set<Trainer>> entity = controller.getAllTrainers();
		Set<Trainer> trainers = entity.getBody();

		log.debug("Got all trainers: " + trainers);
	}

	@Test
	public void updateTrainer() {
		TrainerDAO trainerDao = (TrainerDAO) context.getBean(TrainerDAO.class);
		log.debug("Updating trainer");

		trainerDao.createTrainer(trainer);
		HttpEntity<Trainer> entity = controller.getTrainerById(trainer.getTrainerId());
		Trainer toUpdate = entity.getBody();
		toUpdate.setName("Leslie Miller");
		controller.updateTrainer(toUpdate);

		log.debug("updated batch");
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
	public static void close() {
		log.debug("\n--- TRAINER CONTROLLER IMPLEMENTATION TEST END ---\n");
		((AbstractApplicationContext) context).registerShutdownHook();
	}
}
