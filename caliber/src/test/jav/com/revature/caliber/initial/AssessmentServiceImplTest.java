package com.revature.caliber.initial;

import com.revature.caliber.gateway.services.AssessmentService;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.List;

public class AssessmentServiceImplTest {
	   private static ApplicationContext context;

	   private static AssessmentService assessmentService;
	   
	   @Before
	   public void setUp() throws Exception {
	       context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/beans.xml");
	       assessmentService = context.getBean(AssessmentService.class);

	   }   
	   
	   @Test
	   @Ignore
	   public void getGradesByAssessment(){
		   List<com.revature.caliber.assessment.beans.Grade> grades = assessmentService.getGradesByAssessment(1);
		   System.out.println("assess grades" + grades);
	   }
	   
	   @Test
	   @Ignore
	   public void getGradesByTrainee(){
		   List<com.revature.caliber.assessment.beans.Grade> grades = assessmentService.getGradesByTraineeId(1);
		   for (com.revature.caliber.assessment.beans.Grade grade : grades) {
			   System.out.println("Grade #"+ grade.getGradeId() + ": " + grade.getScore());
		   }
	   }

	@After
	public void close() {
		((AbstractApplicationContext) context).registerShutdownHook();
	}
}
