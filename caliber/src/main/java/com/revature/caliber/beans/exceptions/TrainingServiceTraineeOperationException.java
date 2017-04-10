package com.revature.caliber.beans.exceptions;

/**
 * Custom exception for Training Service Trainee functionality
 */
public class TrainingServiceTraineeOperationException extends RuntimeException {
    /**
     * Instantiates a new Training service trainee operation exception.
     */
    public TrainingServiceTraineeOperationException() {
        super();
    }

    /**
     * Instantiates a new Training service trainee operation exception.
     *
     * @param message the message
     */
    public TrainingServiceTraineeOperationException(String message) {
        super(message);
    }
}
