package com.revature.caliber.initial;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.BeforeClass;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.revature.caliber.gateway.ApiGateway;

/**
 * Integration test of ApiGateway, ServiceLocator, 
 * Service Implementation classes.
 */
public class ApiGatewayTest {

	private static AbstractApplicationContext context;

	@BeforeClass
	public static void setup(){
		context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/beans.xml");
	}
	
	@Test
	public void beansWired(){
		assertNotNull(context.getBean(ApiGateway.class));
	}
	
	@After
	public void close() {
		((AbstractApplicationContext) context).registerShutdownHook();
	}
	
}
