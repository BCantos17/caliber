package com.revature.caliber.beans.exceptions;

/**
 * Custom exception for Assessment Service Grade functionality
 */
public class AssessmentServiceOperationException extends RuntimeException {

    /**
     * Instantiates a new Assessment service operation exception.
     */
    public AssessmentServiceOperationException() {
        super();
    }

    /**
     * Instantiates a new Assessment service operation exception.
     *
     * @param message the message
     */
    public AssessmentServiceOperationException(String message) {
        super(message);
    }
}
