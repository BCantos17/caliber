package com.revature.caliber.gateway.services;

/**
 * The interface Service locator.
 */
public interface ServiceLocator {

    /**
     * Return convenience object for interaction with
     * the training module. Includes REST end points
     * and delegates service calls.
     *
     * @return A convenience object for interaction with the training module.
     */
    TrainingService getTrainingService();

    /**
     * Gets assessment service.
     *
     * @return the assessment service
     */
    AssessmentService getAssessmentService();
    //TODO public ReportService getReportService();
    //TODO public SalesforceService getSalesforceService();

}
