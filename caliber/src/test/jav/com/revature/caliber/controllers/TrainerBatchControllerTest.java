package com.revature.caliber.controllers;

import com.revature.caliber.assessment.beans.Grade;
import com.revature.caliber.models.SalesforceUser;
import org.apache.http.client.utils.URIBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/applicationContext-security.xml",
        "file:src/main/webapp/WEB-INF/beans.xml"})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class TrainerBatchControllerTest {

    URIBuilder uriBuilder;
    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;
    private SalesforceUser salesforceUser;

    @Before
    public void setUp() throws Exception {
        uriBuilder = new URIBuilder();
        uriBuilder.setScheme("http")
                .setHost("localhost")
                .setPort(8080);
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
        salesforceUser = new SalesforceUser();
        salesforceUser.setRole("ROLE_TRAINER");
        salesforceUser.setCaliberId(7);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getAllBatches() throws Exception {
        uriBuilder.setPath("/caliber/trainer/batch/all");
        ResultActions actions = mockMvc.perform(get(uriBuilder
                .build())
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .with(user(salesforceUser)))
                .andDo(MockMvcResultHandlers.print());
        System.err.println(actions.toString());
    }

    @Test
    @WithMockUser(username = "testrevature@gmail.com", roles = "TRAINER")
    public void getCurrentBatch() throws Exception {
    }

    @Test
    public void createNewWeek() throws Exception {

    }

    @Test
    public void createGrade() throws Exception {


    }

    @Test
    public void updateGrade() throws Exception {

    }

    @Test
    public void createAssessment() throws Exception {

    }

    @Test
    public void deleteAssessment() throws Exception {

    }

    @Test
    public void updateAssessment() throws Exception {

    }

    @Test
    public void updateAssessmentNote() throws Exception {

    }

}