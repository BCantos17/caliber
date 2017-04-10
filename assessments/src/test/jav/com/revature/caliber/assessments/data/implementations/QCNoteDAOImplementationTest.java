package com.revature.caliber.assessments.data.implementations;

import com.revature.caliber.assessments.beans.QCNote;
import com.revature.caliber.assessments.data.QCNoteDAO;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Tests for QCNote DAO.
 * Uses regular sql to check the correctness of hibernate mappings and dao methods
 * (I do not use hibernate to check hibernate)
 * I tried to make tests as transient as possible
 *
 * Ignored the test since DAO is completed
 */
@Ignore
public class QCNoteDAOImplementationTest {
    private static ApplicationContext context;
    private static SessionFactory sf;
    private static final Logger logger = LoggerFactory.getLogger(QCNoteDAOImplementationTest.class);

    private static int newQCNoteId;
    private static int weekId = 2828;
    private static int traineeId = 2828;

    /* Helper method so that I don't have to copy-paste code.
     * It does not change any static values, it just finds free id for note in db
     * and inserts a new note for it.
     * Then it inserts new QCNote into db using SQL.
     * Has to be used between
     * Transaction tx = session.beginTransaction();
     * and
     * tx.commit();
     * to guarantee that no record is inserted while searching
    */
    private static int findFreeNoteIdAndCreateQCNote(Session session, Integer weekId, Integer traineeId, String content) {
        String sql;
        int id;

        sql = "SELECT NOTE_ID FROM CALIBER_NOTE";

        Query q = session.createSQLQuery(sql);

        List<BigDecimal> list = q.list();
        list.sort(BigDecimal::compareTo);

        id = 1;

        for (BigDecimal objId : list) {
            if (objId.intValue() == id) { id++; }
        }

        int resultNum = 0;

        sql = "INSERT INTO CALIBER_NOTE(NOTE_ID, NOTE_CONTENT, NOTE_SUGAR)" +
                " VALUES (?, ?, ?)";

        Query noteq = session.createSQLQuery(sql);
        noteq.setInteger(0, id);
        noteq.setString(1, content);
        noteq.setString(2, "sugar: " + content);

        resultNum = noteq.executeUpdate();

        if (resultNum != 1) {
            fail("Failed to create test Note");
        }

        sql = "INSERT INTO CALIBER_QC_NOTE (TRAINEE_ID, WEEK_ID, NOTE_ID) " +
                "VALUES(?, ?, ?)";

        Query qcnoteq = session.createSQLQuery(sql);
        qcnoteq.setInteger(0, traineeId);
        qcnoteq.setInteger(1, weekId);
        qcnoteq.setInteger(2, id);

        resultNum = qcnoteq.executeUpdate();

        if (resultNum != 1) {
            fail("Failed to create test QCNote");
        }

        return id;
    }

    /*
     * Another helper method to delete note by id.
     * Returns the number of rows affected by the query
     */
    private static int deleteQCNoteById(Session session, Integer id) {
        String sql;
        Query q;
        int rowsAffected = 0;

        sql = "DELETE FROM CALIBER_QC_NOTE WHERE NOTE_ID = ?";
        q = session.createSQLQuery(sql);
        q.setInteger(0, id);
        rowsAffected += q.executeUpdate();

        sql = "DELETE FROM CALIBER_NOTE WHERE NOTE_ID = ?";
        q = session.createSQLQuery(sql);
        q.setInteger(0, id);
        rowsAffected += q.executeUpdate();

        return rowsAffected;
    }



    @BeforeClass
    public static void preClass () {
        context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/beans.xml");

        logger.info("\n--- QCNOTE DAO IMPLEMENTATION TEST START ---\n");
        logger.info(" > Creating test db data (preClass)");

        //create transient SQL test data
        sf = (SessionFactory) context.getBean("sessionFactory");
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        newQCNoteId = findFreeNoteIdAndCreateQCNote(session, weekId, traineeId, "test content");

        tx.commit();
        session.close();

        logger.info("    .. created a note with id " + newQCNoteId);
    }

    @AfterClass
    public static void afterClass() {
        logger.info(" > Deleting data created in preClass (afterClass)");

        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        int rowsAffected = deleteQCNoteById(session, newQCNoteId);

        tx.commit();
        session.close();

        logger.info("    .. data successfully deleted, rows affected: " + rowsAffected);

        logger.info("\n--- QCNOTE DAO IMPLEMENTATION TEST END ---\n");
    }

    @Test
    public void testCreate(){
        logger.info(" > Create QCNote test");
        QCNoteDAO dao = context.getBean(QCNoteDAO.class);

        QCNote note = new QCNote();
        note.setContent("Some test content (QCNote DAO Test)");
        note.setSugarCoatedContent("Some sugar content");
        note.setTrainee(2829);
        note.setWeek(2829);

        dao.createQCNote(note);

        //Test if it was created
        String sql;
        Session session = sf.openSession();
        sql = "SELECT NOTE_ID, NOTE_CONTENT FROM CALIBER_NOTE" +
                " WHERE NOTE_CONTENT = ?";
        Query q = session.createSQLQuery(sql);
        q.setString(0, "Some test content (QCNote DAO Test)");
        Object[] result = (Object[]) q.uniqueResult();
        assertEquals(note.getNoteId(), ((BigDecimal) result[0]).intValue());
        assertEquals(note.getContent(), result[1]);

        logger.info("    .. note with content \"" + result[1] + "\" was successfully created");

        logger.info("    .. cleanup process");
        //cleanup
        Transaction tx = session.beginTransaction();

        int rowsDeleted = deleteQCNoteById(session, ((BigDecimal) result[0]).intValue());

        tx.commit();
        logger.info("    .. cleanup completed, rows deleted: " + rowsDeleted);
        session.close();

        logger.info("    -- test of creating QCNote completed.");
    }

    @Test
    public void testGetById() {
        logger.info(" > Get QCNote by id test");
        QCNoteDAO dao = context.getBean(QCNoteDAO.class);
        QCNote note = dao.getQCNoteById(newQCNoteId);
        assertNotNull(note);
        assertEquals(newQCNoteId, note.getNoteId());
        logger.info("    .. got qc note with id: " + note.getNoteId() + ", and content: \"" + note.getContent() + "\"");
        logger.info("    -- test of getting QCNote by id completed.");
    }

    @Test
    public void testGetByBothIds() {
        logger.info(" > Get QCNote by both ids (week, trainee) test");
        QCNoteDAO dao = context.getBean(QCNoteDAO.class);
        QCNote note = dao.getQCNoteForTraineeWeek(traineeId, weekId);
        assertNotNull(note);
        assertEquals(newQCNoteId, note.getNoteId());
        logger.info("    .. got note with id: " + note.getNoteId());
        logger.info("    -- test of getting QCNote by week and trainee ids completed.");
    }

    @Test
    public void testGetByTrainee() {
        logger.info(" > Get QCNote by trainee test");
        QCNoteDAO dao = context.getBean(QCNoteDAO.class);
        List<QCNote> list = dao.getQCNotesByTrainee(traineeId);
        assertNotEquals(0, list.size());
        logger.info("    .. list size: " + list.size() + " (expected > 0)");
        logger.info("    -- test of getting QCNote by trainee completed.");
    }

    @Test
    public void testGetByWeek() {
        logger.info(" > Get QCNote by week test");
        QCNoteDAO dao = context.getBean(QCNoteDAO.class);
        List<QCNote> list = dao.getQCNotesByWeek(weekId);
        assertNotEquals(0, list.size());
        logger.info("    .. list size: " + list.size() + " (expected > 0)");
        logger.info("    -- test of getting QCNote by week completed");
    }

    @Test
    public void testUpdateNote() {
        logger.info(" > Update QCNote test.");

        //first, create a test note
        int id, weekId = 6565, traineeId = 6565;
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        id = findFreeNoteIdAndCreateQCNote(session, weekId, traineeId, "some content here (another test).");

        tx.commit();

        //Test itself
        QCNoteDAO dao = context.getBean(QCNoteDAO.class);

        QCNote note = dao.getQCNoteById(id);
        assertNotNull(note);
        note.setTrainee(8282);

        dao.updateQCNote(note);

        note = dao.getQCNoteById(id);
        assertNotNull(note);
        assertNotEquals(traineeId, note.getTrainee());
        logger.info("    .. successfully changed trainee id from " + traineeId + " to " + note.getTrainee());

        logger.info("    .. cleanup process");
        tx = session.beginTransaction();

        int rowsDeleted = deleteQCNoteById(session, id);

        tx.commit();
        logger.info("    .. cleanup completed, rows deleted: " + rowsDeleted);
        session.close();

        logger.info("    -- test of updating QCNote completed.");
    }

    @Test
    public void testDeleteNote() {
        logger.info(" > Delete QCNote test.");

        //create a test note first
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        int id = findFreeNoteIdAndCreateQCNote(session, 9797, 9797, "super content");

        tx.commit();
        logger.info("    .. test note with id " + id + " was created");

        //now get that note from db as an object
        String sql = "SELECT CALIBER_NOTE.NOTE_ID, NOTE_CONTENT, NOTE_SUGAR, TRAINEE_ID, WEEK_ID FROM CALIBER_NOTE" +
                " INNER JOIN CALIBER_QC_NOTE ON CALIBER_NOTE.NOTE_ID = CALIBER_QC_NOTE.NOTE_ID" +
                " WHERE CALIBER_NOTE.NOTE_ID = ?";
        Query q = session.createSQLQuery(sql);
        q.setInteger(0, id);
        Object[] result = (Object[]) q.uniqueResult();
        QCNote note = new QCNote();
        note.setNoteId(((BigDecimal)result[0]).intValue());
        note.setContent((String)result[1]);
        note.setSugarCoatedContent((String)result[2]);
        note.setTrainee(((BigDecimal)result[3]).intValue());
        note.setWeek(((BigDecimal)result[4]).intValue());

        logger.info("    .. trying to delete the note");
        QCNoteDAO dao = context.getBean(QCNoteDAO.class);

        dao.deleteQCNote(note);

        //test if it was deleted
        Criteria criteria = session.createCriteria(QCNote.class);
        criteria.add(Restrictions.eq("content", "Some test content 2(QCNote DAO Test)"));
        note = (QCNote) criteria.uniqueResult();

        //manual cleanup
        if (note != null) {
            logger.info("    .. test failed, note was note deleted, doing manual cleanup");
            int rowsAffected = deleteQCNoteById(session, id);
            logger.info("    .. manual cleanup completed, rows affected: " + rowsAffected);
        }

        session.close();

        assertNull(note);

        logger.info("    .. note was successfully deleted");
        logger.info("    -- test of deleting a note completed.");
    }
    
	@After
	public void close() {
		((AbstractApplicationContext) context).registerShutdownHook();
	}
}
