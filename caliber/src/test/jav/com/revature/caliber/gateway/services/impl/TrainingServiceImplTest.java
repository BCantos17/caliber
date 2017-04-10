package com.revature.caliber.gateway.services.impl;

import com.revature.caliber.beans.Batch;
import com.revature.caliber.beans.Week;
import com.revature.caliber.gateway.services.TrainingService;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.List;

public class TrainingServiceImplTest {

    private static ApplicationContext context;
    private static TrainingService trainingService;

    @Before
    public void setUp() throws Exception {
        context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/beans.xml");
        trainingService = context.getBean(TrainingService.class);
    }

    @Test
    @Ignore
    public void getWeekByBatch() throws Exception {
        List<com.revature.caliber.beans.Week> week = trainingService.getWeekByBatch(1);
        for(int i=0;i<week.size();i++){
            System.out.println(week.get(i).getWeekNumber());
        }

    }

    @Test
    @Ignore
    public void allBatch() throws Exception {
        //Goes to - > training/batch/current/1
        ApplicationContext context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/beans.xml");
        TrainingServiceImpl ts = (TrainingServiceImpl) context.getBean("trainingService");
        ts.setHostname("http://localhost:");
        ts.setPortNumber("9001");
        System.err.println( ts.allBatch());
    }

    @Test
    @Ignore
    public void currentBatch() throws Exception {
        //Goes to - > training/batch/current/1
        ApplicationContext context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/beans.xml");
        TrainingServiceImpl ts = (TrainingServiceImpl) context.getBean("trainingService");
        ts.setHostname("http://localhost:");
        ts.setPortNumber("8080");
        System.err.println( ts.currentBatches(1));
    }

    @Test
    @Ignore
    public void getBatch() throws Exception {
        //Goes to - > training/batch/byId/3
        ApplicationContext context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/beans.xml");
        TrainingServiceImpl ts = (TrainingServiceImpl) context.getBean("trainingService");
        ts.setHostname("http://localhost:");
        ts.setPortNumber("8080");
        Batch batch = ts.getBatch(3);
        System.err.println(batch.toString());
    }


    @Test
    @Ignore
    public void updateBatch() throws Exception {
        //Goes to - > training/batch/update ... needs json body
        ApplicationContext context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/beans.xml");
        TrainingServiceImpl ts = (TrainingServiceImpl) context.getBean("trainingService");
        ts.setHostname("http://localhost:");
        ts.setPortNumber("8080");
        Batch batch = ts.getBatch(1);
        System.err.println(batch.toString());
        batch.setTrainingName("angular4");
        ts.updateBatch(batch);
        System.out.println("Updated batch -> " + ts.getBatch(1));
    }

    
    
	@Test
	@Ignore
	public void getAllWeekTest(){
		
		TrainingServiceImpl training = new TrainingServiceImpl();
		List<Week> weeks = training.getAllWeek();
		System.out.println(weeks);
	}
	
	@Test
	@Ignore
	public void addNewWeekTest(){
		Week newWeek = new Week();
		newWeek.setWeekNumber(2099);
		TrainingServiceImpl training = new TrainingServiceImpl();
		training.createWeek(newWeek);
	}
	
	@After
	public void close() {
		((AbstractApplicationContext) context).registerShutdownHook();
	}
}
