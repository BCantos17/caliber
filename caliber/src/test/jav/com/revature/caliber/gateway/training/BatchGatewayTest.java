package com.revature.caliber.gateway.training;

import com.revature.caliber.beans.Batch;
import com.revature.caliber.beans.Trainer;
import com.revature.caliber.gateway.services.TrainingService;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.List;
import java.util.Set;

public class BatchGatewayTest {
    private static ApplicationContext context;
    private static TrainingService trainingService;

    /**
     * Retrieve application context and get the TrainerBatchController bean
     */
    @BeforeClass
    public static void preClass() {
        context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/beans.xml");
        trainingService = context.getBean(TrainingService.class);
    }

    @AfterClass
    public static void post(){
        ((ConfigurableApplicationContext) context).close();
    }

    @Ignore
    @Test
    public void create(){

    }

    @Test
    @Ignore
    public void getAll(){
        Set<Batch> batches = trainingService.allBatch();
        System.out.println(batches);
    }

    @Test
    @Ignore
    public void getBatches(){
        List<Batch> batches = trainingService.getBatches(1);
        System.out.println(batches);
    }

    @Test
    @Ignore
    public void getById(){
        Batch batch = trainingService.getBatch(3);
        System.out.println(batch);
    }
    
	@After
	public void close() {
		((AbstractApplicationContext) context).registerShutdownHook();
	}
}
