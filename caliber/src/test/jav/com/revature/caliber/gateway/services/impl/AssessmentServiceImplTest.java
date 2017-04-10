package com.revature.caliber.gateway.services.impl;

import com.revature.caliber.gateway.services.AssessmentService;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.List;

/**
 * Created by Shehar on 1/26/2017.
 */
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
    public void getAllGrades() throws Exception {
        List<com.revature.caliber.assessment.beans.Grade> grades = assessmentService.getAllGrades();
        for(int i=0;i<grades.size();i++){
            System.out.println(grades.get(i));
        }
    }

    @Test
    @Ignore
    public void getGradesByTraineeId() throws Exception {
        List<com.revature.caliber.assessment.beans.Grade> grades = assessmentService.getGradesByTraineeId(1);
        for(int i=0;i<grades.size();i++){
            System.out.println(grades.get(i).toString());
        }
    }
    
	@After
	public void close() {
		((AbstractApplicationContext) context).registerShutdownHook();
	}


}