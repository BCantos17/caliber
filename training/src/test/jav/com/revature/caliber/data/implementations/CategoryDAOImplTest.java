package com.revature.caliber.data.implementations;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.revature.caliber.training.beans.Category;
import com.revature.caliber.training.data.CategoryDAO;
import com.revature.caliber.training.data.Facade;
import com.revature.caliber.training.service.BusinessDelegate;

public class CategoryDAOImplTest {

	private static ApplicationContext contxt;
	private static Logger logger;

    @BeforeClass
    public static void preClass () {
        contxt = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/beans.xml");
        logger = Logger.getRootLogger();
    }
	
	
    //Testing the CategoryDAOImplementation
    @Test
    public void getCategory(){
    	Category category = contxt.getBean(CategoryDAO.class).getCategory(1);
    	logger.info(category + " Get individual category from DAO");
    }
    
    @Test
    public void getAllCategories(){
    	List<Category> categories = new ArrayList<Category>();
    	categories = contxt.getBean(CategoryDAO.class).getAllCategories();
    	logger.info(categories + " Get all categories from DAO");
    }
    
    //Testing the category methods in the Facade
    @Test
    public void getCategoryFacade(){
    	logger.info(contxt.getBean(Facade.class).getCategory(1) + " Get individual category using Facade");
    }
    
    @Test
    public void getAllCategoryFacade(){
    	logger.info(contxt.getBean(Facade.class).getAllCategories() + " Get all categories using Facade");
    }
   
    //Testing the category methods in the Business Delegate
    @Test
    public void getCategoryBDelegate(){
    	logger.info(contxt.getBean(BusinessDelegate.class).getCategory(1) + " Get all categories using Business Delegate");
    }
    
    @Test
    public void getAllCategoryBDelegate(){
    	logger.info(contxt.getBean(BusinessDelegate.class).getAllCategories() + " Get all categories using Business Delegate"); 	
    }
    
	@After
	public void close() {
		((AbstractApplicationContext) contxt).registerShutdownHook();
	}
}
