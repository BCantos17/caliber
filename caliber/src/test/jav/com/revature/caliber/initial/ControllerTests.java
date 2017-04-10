package com.revature.caliber.initial;

import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.revature.caliber.beans.Batch;
import com.revature.caliber.beans.Trainee;
import com.revature.caliber.beans.Trainer;
import com.revature.caliber.beans.Week;
import com.revature.caliber.gateway.ApiGateway;
import com.revature.caliber.gateway.services.ServiceLocator;

public class ControllerTests {
 
    private static ApplicationContext context;
    private static ApiGateway apiGateway;

    @Before
    public void setUp() throws Exception {
        context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/beans.xml");
        apiGateway = context.getBean(ApiGateway.class);
    }
    
	@Test
	public void getAllWeeks(){
		List<Week> weeks = context.getBean(ServiceLocator.class).getTrainingService().getAllWeek();
		System.out.println("here are weeks: \n" +weeks);
		//Printed out with batch, topics, assessments, batchnotes, qcNotes, trainerNotes = null
	}
	
	@Test
	public void getTrainer(){
		Trainer trainer = context.getBean(ServiceLocator.class).getTrainingService().getTrainer(1);
		System.out.println("Trainer: " + trainer);
		//Prints out with batch = null
	}
	
	@Ignore
	@Test
	public void getAllTrainers(){
		List<Trainer> trainers = context.getBean(ServiceLocator.class).getTrainingService().getAllTrainers();
		System.out.println(trainers);//Prints out duplicates
	}
	
	@Ignore
	@Test
	public void getAllBatches(){
		Set<Batch> batches = context.getBean(ServiceLocator.class).getTrainingService().allBatch();
		System.out.println("batches: " + batches);
		//batches in trainer, trainees, weeks is null
	}
	
	@Ignore
	@Test
	public void getBatches(){
		List<Batch> batches = context.getBean(ServiceLocator.class).getTrainingService().getBatches(1);
		System.out.println("get batches: " + batches);
		//based on trainer id
	}
	
	@Ignore
	@Test
	public void getBatch(){
		Batch batches = context.getBean(ServiceLocator.class).getTrainingService().getBatch(1);
		System.out.println("get batches: " + batches);
		//based on trainer id
	}
	
	@Test
	public void getTrainee(){
		Trainee trainee = context.getBean(ServiceLocator.class).getTrainingService().getTrainee(1);
		System.out.println("get Trainee: " + trainee);
		//batch, grade, Notes = null
	}
	
	@Test
	public void getAllTraineesinBatch(){
		List<Trainee> trainees = context.getBean(ServiceLocator.class).getTrainingService().getTraineesInBatch(1);
		System.out.println("Trainees in batch " + trainees);
		//batch, grade, Notes = null 
	}
	
	//@Test
	
	@After
	public void close() {
		((AbstractApplicationContext) context).registerShutdownHook();
	}
}
