package com.revature.caliber.assessments.data.implementations;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.revature.caliber.assessments.beans.BatchNote;
import com.revature.caliber.assessments.data.BatchNoteDAO;



public class BatchNoteDAOImplTest {

	private static AbstractApplicationContext ctxt;
	private static BatchNoteDAO batchNoteDAO;
	private static SessionFactory sf;
	static Logger logger;
	private static int id = 31106;
	private static int batchId = 6300;
	private static int weekId = 1;
	
	@BeforeClass
	public static void preClass () {
		ctxt = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/beans.xml");
		logger = Logger.getRootLogger();
		logger.debug("Starting BatchNoteTest");
		sf = ctxt.getBean(SessionFactory.class);
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
		noteq.setInteger(0, id);
		noteq.setString(1, "content");
		noteq.setString(2, "sugar");
		noteq.executeUpdate();

		sql = "INSERT INTO CALIBER_BATCH_NOTE (BATCH_ID, WEEK_ID, NOTE_ID) " +
				"VALUES(?, ?, ?)";

		Query batchNote = session.createSQLQuery(sql);

		batchNote.setInteger(0, batchId);
		batchNote.setInteger(1, weekId);
		batchNote.setInteger(2, id);
		batchNote.executeUpdate();

		tx.commit();
		session.close();
	}


	@AfterClass
	public static void cleanUp() {

		BatchNote batchNote = ctxt.getBean(BatchNoteDAO.class).getBatchNoteById(id);
		if (batchNote != null) {
			batchNoteDAO.deleteBatchNote(batchNote);
			batchNote = batchNoteDAO.getBatchNoteById(id);
			assertNull(batchNote);
		}
		System.out.println("CleanUp BatchNote was fine");
		logger.debug("Ending AssessmentServiceTest");
	}
	
	@Test
	//@Ignore
	public void createBatchNoteTest() {	
		logger.debug("Starting createBatchNoteTest....");
		BatchNote newBatchNote = new BatchNote();

		newBatchNote.setBatch(batchId);
		newBatchNote.setWeek(weekId);
		newBatchNote.setContent("This batch has a hard time understanding Spring.");
		newBatchNote.setSugarCoatedContent("Very good on all topics but still can improve.");
		ctxt.getBean(BatchNoteDAO.class).createBatchNote(newBatchNote);

		assertNotNull(newBatchNote);
		logger.debug("BatchNote was successfully created");
		
		System.out.println("Get Create BatchNote was fine");
		logger.debug("Ending create batch note");
	}
	
	
	@Test
	//@Ignore
	public void getBatchNoteById(){
		logger.debug("Starting getBatchNoteByID....");
		BatchNote batchNote = ctxt.getBean(BatchNoteDAO.class).getBatchNoteById(id);
		assertNotNull(batchNote);
		System.out.println("Get BatchNote by NoteID was fine " + batchNote);
		logger.debug("Get BatchNote by ID was successfully");
		
	}
	
	@Test
	//@Ignore
	public void getBatchesNotesInWeekTest() {
		logger.debug("Starting getBatchesNotesInTest....");
		List<BatchNote> batchesNotesInWeek = ctxt.getBean(BatchNoteDAO.class).getBatchesNotesListInWeek(batchId, weekId);
		assertNotNull(batchesNotesInWeek);
		System.out.println("Get List of Batches' Notes in Week was fine: " + batchesNotesInWeek.toString());
		logger.debug("Get the List of BatchNotes for a specific batch within a week: " + batchesNotesInWeek);
	}
	
	/* TODO need to change by accepting BatchNote object */
	@Test
	//@Ignore
	public void getAllBatchNotesTest() {
		logger.debug("Starting getAllBatchNotesTest....");
	
		List<BatchNote> batchNotes = ctxt.getBean(BatchNoteDAO.class).allBatchNotes(batchId);
		System.out.println("batchNotes: " + batchNotes);
		assertNotNull(batchNotes);
		System.out.println("Get All BatchNotes was fine: " + batchNotes.toString());
		logger.debug("All of Batch " + batchId + "'s batchNotes: " + batchNotes.toString());
		
	}

	@Test
	//@Ignore
	public void getAllBatchNotesforWeekTest() {
		
		logger.debug("Starting getAllBatchNotesForWeekTest....");
		
		List<BatchNote> batchNotesForWeek = ctxt.getBean(BatchNoteDAO.class).allBatchNotesByWeek(weekId);

		assertNotNull(batchNotesForWeek);
		System.out.println("Get All BatchNotes From Every Batch for Week: " + batchNotesForWeek.toString());
		logger.debug("All of BatchNotes for all batches within week " + weekId + ": " + batchNotesForWeek);
	}

	@Test
	//@Ignore
	public void updateBatchNoteTest() {
		
		logger.debug("Starting updatingBatchNoteTest");
		
		String stringCoated = "This is the Sugar Coated Comments";
		String content = "These are the unfiltered comments of the QC board";

		BatchNote batchNote = ctxt.getBean(BatchNoteDAO.class).getBatchNoteById(id);

		batchNote.setContent(content);
		batchNote.setSugarCoatedContent(stringCoated);
		ctxt.getBean(BatchNoteDAO.class).updateBatchNote(batchNote);

		assertNotNull(batchNote);
		System.out.println("Update BatchNoteTest was fine");
		logger.debug("Update BatchNote with new contents.");
	}

	@Test
	public void deleteBatchNote(){
		logger.debug("Starting deleteBatchNoteTest....");
		BatchNote batchNote = ctxt.getBean(BatchNoteDAO.class).getBatchNoteById(id);
		ctxt.getBean(BatchNoteDAO.class).deleteBatchNote(batchNote);

		assertNotNull(batchNote);
		System.out.println("Delete BatchNoteTest was fine");
		logger.debug("BatchNote was deleted");
	}
	
	@After
	public void close() {
		((AbstractApplicationContext) ctxt).registerShutdownHook();
	}

}
