package com.revature.caliber.assessments.data.implementations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Set;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.revature.caliber.assessments.beans.TrainerNote;
import com.revature.caliber.assessments.data.TrainerNoteDAO;

public class TrainerNoteDAOImplTest {

	private static AbstractApplicationContext context;
	private static TrainerNoteDAO trainerNoteDAO;
	private static SessionFactory sf;
	static Logger logger;
	private static int id = 3050;
	private static int trainerId = 5;
	private static int weekId = 123;
	
	@BeforeClass
	public static void preClass () {
		context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/beans.xml");
		logger = Logger.getRootLogger();
		trainerNoteDAO = context.getBean(TrainerNoteDAO.class);
		logger.debug("Starting TrainerNoteTest");
		sf = context.getBean(SessionFactory.class);
		populateTable();
	}

	/**
	 * Populates table with Assessment used for testing
	 */
	private static void populateTable() {

		String sql = "INSERT INTO CALIBER_NOTE(NOTE_ID, NOTE_CONTENT, NOTE_SUGAR)" +
				" VALUES (?, ?, ?)";

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		Query noteq = session.createSQLQuery(sql);
		noteq.setInteger(0, 3050);
		noteq.setString(1, "content");
		noteq.setString(2, "sugar");
		noteq.executeUpdate();

		sql = "INSERT INTO CALIBER_TRAINER_NOTE (TRAINER_ID, WEEK_ID, NOTE_ID) " +
				"VALUES(?, ?, ?)";

		Query trainerNote = session.createSQLQuery(sql);

		trainerNote.setInteger(0, trainerId);
		trainerNote.setInteger(1, weekId);
		trainerNote.setInteger(2, id);
		trainerNote.executeUpdate();

		tx.commit();
		session.close();
	}


	@AfterClass
	public static void cleanUp() {

		int trainerNoteId = 3050;

		TrainerNote trainerNote = trainerNoteDAO.getTrainerNoteById(trainerNoteId);

		if (trainerNote != null) {
			trainerNoteDAO.deleteTrainerNote(trainerNote);
			trainerNote = trainerNoteDAO.getTrainerNoteById(trainerNoteId);
			assertNull(trainerNote);
		}

		logger.debug("Ending AssessmentServiceTest");

		((ConfigurableApplicationContext) context).close();
	}

	@Test
	public void createTrainerNoteTest(){
		logger.debug("Starting create trainer note");

		String note = "Testing content: this is content 12";
		String sugarNote = "Testing sugar note";

		TrainerNote trainerNote = new TrainerNote();
		trainerNote.setTrainer(45);
		trainerNote.setWeek(6690);
		trainerNote.setContent(note);
		trainerNote.setSugarCoatedContent(sugarNote);

		trainerNoteDAO.createTrainerNote(trainerNote);

		//Test if it was created
		Session session = ((SessionFactory) context.getBean("sessionFactory")).openSession();
		Criteria criteria = session.createCriteria(TrainerNote.class);
		criteria.add(Restrictions.eq("content", "Testing content: this is content 12"));
		TrainerNote newnote = (TrainerNote) criteria.uniqueResult();
		assertEquals(trainerNote.getNoteId(), newnote.getNoteId());
		assertEquals(trainerNote.getContent(), newnote.getContent());

		//cleanup
		Transaction tx = session.beginTransaction();
		session.delete(newnote);
		tx.commit();
		session.close();

		logger.debug("Ending create trainer note");
	}

	@Test
	public void getTrainerNoteById(){
		int noteId = 3050;
		logger.debug("Starting getTrainerNoteById = " + noteId);

		TrainerNote trainerNote = trainerNoteDAO.getTrainerNoteById(noteId);
		assertNotNull(trainerNote);

		logger.debug("Ending getTrainerNoteById");
	}

	@Test
	public void getTrainerNoteByTrainerWeek(){
		logger.debug("Starting getTrainerNoteByTrainerWeek = " + trainerId + " " + weekId);

		TrainerNote trainerNote = trainerNoteDAO.getTrainerNoteForTrainerWeek(trainerId, weekId);
		assertNotNull(trainerNote);

		logger.debug("Ending getTrainerNoteByTrainerWeek ");
	}

	@Test
	public void getTrainerNoteByTrainer(){
		logger.debug("Starting getTrainerNoteByTrainer = " + trainerId);

		Set<TrainerNote> trainerNote = trainerNoteDAO.getTrainerNotesByTrainer(trainerId);
		assertNotNull(trainerNote);

		logger.debug("Ending getTrainerNoteByTrainer");
	}

	@Test
	public void getTrainerNoteByWeek(){
		logger.debug("Starting getTrainerNoteByWeek = " + weekId);

		Set<TrainerNote> trainerNote = trainerNoteDAO.getTrainerNotesByTrainer(weekId);
		assertNotNull(trainerNote);

		logger.debug("Ending getTrainerNoteByWeek");
	}

	@Test
	public void updateTrainerNote(){
		int id = 3050;
		logger.debug("Starting updateTrainerNote = " + id);

		TrainerNote trainerNote = trainerNoteDAO.getTrainerNoteById(id);
		trainerNote.setContent("Updated content");
		trainerNoteDAO.updateTrainerNote(trainerNote);
		assertNotNull(trainerNote);

		logger.debug("Ending updateTrainerNote");
	}

	@Test
	public void deleteTrainerNote(){
		logger.debug("Starting deleteTrainerNote = " + id);

		TrainerNote trainerNote = trainerNoteDAO.getTrainerNoteById(id);
		trainerNoteDAO.deleteTrainerNote(trainerNote);
		assertNotNull(trainerNote);

		logger.debug("Ending updateTrainerNote");

	}
	
	@After
	public void close() {
		((AbstractApplicationContext) context).registerShutdownHook();
	}
	
}	
