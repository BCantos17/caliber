package com.revature.caliber.initial;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ApplicationContextTest {

	@Test
	public void context() {
		try {
			AbstractApplicationContext ctxt = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/beans.xml");
			DataSource ds = (DataSource) ctxt.getBean("dataSource");
			Connection conn = ds.getConnection();
			System.out.println("Connection " + conn);
			Assert.assertNotNull(conn);
			ctxt.close();
		} catch (SQLException e) {}
	}
}
