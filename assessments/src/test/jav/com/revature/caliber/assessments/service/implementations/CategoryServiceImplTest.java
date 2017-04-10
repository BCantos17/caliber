package com.revature.caliber.assessments.service.implementations;

import com.revature.caliber.assessments.beans.Category;
import com.revature.caliber.assessments.service.CategoryService;
import org.apache.log4j.Logger;
import org.hibernate.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Set;

import static org.junit.Assert.*;

public class CategoryServiceImplTest {

    private static AbstractApplicationContext context;
    private static int categoryId;
    private static SessionFactory sessionFactory;
    private static Logger log;
    private static CategoryService categoryService;

    @BeforeClass
    public static void setUp() {
        // rootLogger is for debugging purposes
        log = Logger.getRootLogger();

        log.debug("Starting CategoryServiceTest");

        context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/beans.xml");

        //set service
        categoryService = (CategoryService) context.getBean("categoryService");

        //set session factory
        sessionFactory = (SessionFactory) context.getBean("sessionFactory");

        //hard coding id
        categoryId = 340504;

        //open session and create test data
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        String sql =    "insert into caliber_assessment_category (category_id, skill_category) " +
                            "values (:cat_id, :skill_cat)";
        session.createSQLQuery(sql)
                .setParameter("cat_id", categoryId)
                .setParameter("skill_cat", "Core Java")
                .executeUpdate();

        tx.commit();
        session.close();
    }

    @AfterClass
    public static void cleanUp() {
        //removes test data
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        String sql = "delete from caliber_assessment_category where category_id = :cat_id";
        session.createSQLQuery(sql)
                .setParameter("cat_id", categoryId)
                .executeUpdate();

        tx.commit();
        session.close();

        log.debug("Ending CategoryServiceTest");
    }

    @Test
    public void getAll() throws Exception {
        log.debug("Starting getAllCategoriesTest");

        Set<Category> categories = categoryService.getAll();
        assertFalse(categories.isEmpty());

        log.debug("Ending getAllCategoriesTest");
    }

    @Test
    public void getById() throws Exception {
        int id = categoryId;
        log.debug("Starting getCategoryByIdTest = " + id);

        Category category = categoryService.getById(id);
        assertNotNull(category);

        log.debug("Ending getCategoryById");
    }
    
	@After
	public void close() {
		((AbstractApplicationContext) context).registerShutdownHook();
	}
}