package com.revature.caliber.gateway.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.caliber.gateway.services.AssessmentService;
import com.revature.caliber.gateway.services.ServiceLocator;
import com.revature.caliber.gateway.services.TrainingService;

/**
 * The type Service locator.
 */
@Component
public class ServiceLocatorImpl implements ServiceLocator {

    private TrainingService trainingService;

    private AssessmentService assessmentService;

    @Override
    public TrainingService getTrainingService() {
        return trainingService;
    }

    @Override
    public AssessmentService getAssessmentService() {
        return assessmentService;
    }

    /**
     * Sets training service.
     *
     * @param trainingService the training service
     */
//////////SETTERS//////////////
    @Autowired
    public void setTrainingService(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    /**
     * Sets assessment service.
     *
     * @param assessmentService the assessment service
     */
    @Autowired
    public void setAssessmentService(AssessmentService assessmentService) {
        this.assessmentService = assessmentService;
    }
}
