package com.revature.caliber.assessments.data.implementations;

import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.revature.caliber.assessments.beans.Assessment;
import com.revature.caliber.assessments.beans.QCStatus;
import com.revature.caliber.assessments.data.QCStatusDAO;

public class QCStatusDAOImplTest {

	private static ApplicationContext context;
	
	@BeforeClass
	public static void preClass() {
		
		context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/beans.xml");
	}

	@Test
	public void getAllQCStatusTest() {
		Set<QCStatus> setOfStatus = (HashSet<QCStatus>) context.getBean(QCStatusDAO.class).getAllStatus();
		assertNotNull(setOfStatus);
	}

	@Test
	public void getAssessmentByStatusTest() {
		String status = "good";
		Set<Assessment> setOfAssessment = context.getBean(QCStatusDAO.class).getAssessmentByStatus(status);
		assertNotNull(setOfAssessment);
	}
	
	@After
	public void close() {
		((AbstractApplicationContext) context).registerShutdownHook();
	}
	
}
