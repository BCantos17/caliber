package com.revature.caliber.gateway.impl;

import com.revature.caliber.gateway.ApiGateway;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class ApiGatewayImplTest {

    private static ApplicationContext context;
    private static ApiGateway apiGateway;

    @Before
    public void setUp() throws Exception {
        context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/beans.xml");
        apiGateway = context.getBean(ApiGateway.class);
    }
    
    @Test
    @Ignore
    public void getAggregatedGradesForTrainee() throws Exception {
        HashMap<String, Double[]> grades = apiGateway.getTechGradeDataForTrainee(1);
        for (String grade : grades.keySet()) {
            System.out.print(grade + " -> [");
            for (Double d : grades.get(grade)) {
                System.out.print(d + ", ");
            }
            System.out.println("]");
        }

    }
    
    @Ignore
    @Test
    public void testo(){
    	HashMap<String, Double []> hey = apiGateway.getTechGradeDataForBatch(1);
    }

    @Test
    @Ignore
    public void getWeekAggregatedGradesForTrainee() throws Exception {
        HashMap<String, Double[]> grades = apiGateway.getWeekGradeDataForTrainee(1);

        for (String grade : grades.keySet()) {
            System.out.print(grade + " -> [");
            for (Double d : grades.get(grade)) {
                System.out.print(d + ", ");
            }
            System.out.println("]");
        }

    }
    
    @Test
    @Ignore
    public void getTraineeGradeDataForTrainer(){
    	Map<String, Double[]> grades = apiGateway.getTraineeGradeDataForTrainer(1);
        for (String grade : grades.keySet()) {
            System.out.print(grade + " -> [");
            for (Double d : grades.get(grade)) {
                System.out.print(d + ", ");
            }
            System.out.println("]");
        }
    }

    @Ignore
    @Test
    public void getTechGradeDataForBatch(){
    	Map<String, Double[]> grades = apiGateway.getTechGradeDataForBatch(1);
        for (String grade : grades.keySet()) {
            System.out.print(grade + " -> [");
            for (Double d : grades.get(grade)) {
                System.out.print(d + ", ");
            }
            System.out.println("]");
        }

    }

    @Test
    @Ignore
    public void getGradesForBatchWeekly() throws Exception {
        HashMap<String, Double[]> grades = apiGateway.getGradesForBatchWeekly(1);

        for (String grade : grades.keySet()) {
            System.out.print(grade + " -> [");
            for (Double d : grades.get(grade)) {
                System.out.print(d + ", ");
            }
            System.out.println("]");
        }
    }

    @Test
    @Ignore
    public void getTechGradeAllBatch() throws Exception {
        HashMap<String,HashMap<String,Double[]>> grades = apiGateway.getTechGradeAllBatch();

        for(String batch : grades.keySet()){
            System.out.println(batch + " -> [");

            for(String tech : grades.get(batch).keySet()){
                System.out.println(tech + " -> [");
                for(Double d: grades.get(batch).get(tech)){
                    System.out.println(d + ", ");
                }
                System.out.println("]");
            }
            System.out.println("]");
        }


    }


    @After
    public void  close(){
    	((AbstractApplicationContext)context).registerShutdownHook();
    }

}