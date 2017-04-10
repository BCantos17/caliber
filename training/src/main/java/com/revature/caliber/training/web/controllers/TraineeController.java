package com.revature.caliber.training.web.controllers;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.caliber.training.beans.Trainee;
import com.revature.caliber.training.service.BusinessDelegate;

/**
 * Trainee Controller
 */

@RestController
@CrossOrigin(origins = { "*" }, methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE, RequestMethod.OPTIONS }, allowedHeaders = { "X-PINGOTHER", "Content-Type" }, maxAge = 10)
public class TraineeController {

	private BusinessDelegate businessDelegate;

	@Autowired
	public void setBusinessDelegate(BusinessDelegate businessDelegate) {
		this.businessDelegate = businessDelegate;
	}

	private static Logger logger = LoggerFactory.getLogger(TraineeController.class);

	/**
	 * Create a new trainee by making a PUT request to the URL
	 * 
	 * @param trainee
	 *            trainee to put
	 * @return Response with appropriate status
	 */
	@RequestMapping(
	        value = "trainees/new",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Long> createTrainee(@RequestBody @Valid Trainee trainee) {
		ResponseEntity<Long> returnEntity;
		try {
			long traineeId = businessDelegate.createTrainee(trainee);
			returnEntity = new ResponseEntity<>(traineeId, HttpStatus.CREATED);
		} catch (RuntimeException e) {
            logger.error("Error while creating trainee: " + trainee, e);
			returnEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return returnEntity;
	}
	/**
	 * Create a new trainees by making a PUT request to the URL
	 *
	 * @param trainees
	 *            trainees to put
	 * @return Response with appropriate status
	 */
	@RequestMapping(
	        value = "trainees/bulk",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Long> createTrainee(@RequestBody @Valid Trainee[] trainees) {
		ResponseEntity<Long> returnEntity;
		try {
			for (Trainee trainee:trainees) {
				businessDelegate.createTrainee(trainee);
			}
			returnEntity = new ResponseEntity<>(HttpStatus.CREATED);
		} catch (RuntimeException e) {
			returnEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return returnEntity;
	}

	/**
	 * Update a trainee by making a POST request to the URL
	 * 
	 * @param trainee
	 *            trainee to update (with updated fields)
	 * @return Response with appropriate status
	 */
	@RequestMapping(value = "trainees/update",
                    method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Serializable> updateTrainee(@RequestBody @Valid Trainee trainee) {
		ResponseEntity<Serializable> returnEntity;

		try {
			businessDelegate.updateTrainee(trainee);
			returnEntity = new ResponseEntity<>(HttpStatus.OK);
		} catch (RuntimeException e) {
            logger.error("Error while updating trainee: " + trainee, e);
			returnEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return returnEntity;
	}

	/**
	 * Delete a trainee by making a DELETE request to the URL
	 * 
	 * @param trainee
	 *            trainee to delete
	 * @return Response with appropriate status
	 */
	@RequestMapping(value = "trainees/delete",
                    method = RequestMethod.DELETE,
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Serializable> deleteTrainee(@RequestBody @Valid Trainee trainee) {
		ResponseEntity<Serializable> returnEntity;

		try {
			businessDelegate.deleteTrainee(trainee);
			returnEntity = new ResponseEntity<>(HttpStatus.OK);
		} catch (RuntimeException e) {
            logger.error("Error while deleting trainee: " + trainee, e);
			returnEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return returnEntity;
	}

	/**
	 * Get a trainee by id by making a GET request to the URL
	 * 
	 * @param id
	 *            id as part of URL
	 * @return Response with trainee object and/or appropriate status
	 */
	@RequestMapping(value = "trainees/byid/{identifier}",
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Trainee> getTraineeById(@PathVariable("identifier") int id) {
		ResponseEntity<Trainee> returnEntity;

		try {
			Trainee result = businessDelegate.getTrainee(id);

			if (result == null) {
				returnEntity = new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
			} else {
				returnEntity = new ResponseEntity<>(result, HttpStatus.OK);
			}
		} catch (RuntimeException e) {
            logger.error("Error while getting trainee with id: " + id, e);
			returnEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return returnEntity;
	}

	/**
	 * Get trainee by name by making a GET request to the URL
	 * 
	 * @param email
	 *            email as part of URL
	 * @return Response with trainee object and/or status
	 */
	@RequestMapping(value = "trainees/byemail/{identifier}",
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Trainee> getTraineeByName(@PathVariable("identifier") String email) {
		email = email.replace("_dot_", ".");
		System.out.println(email);
		ResponseEntity<Trainee> returnEntity;

		try {
			Trainee result = businessDelegate.getTrainee(email);

			if (result == null) {
				returnEntity = new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
			} else {
				returnEntity = new ResponseEntity<>(result, HttpStatus.OK);
			}
		} catch (RuntimeException e) {
            logger.error("Error while getting trainee with name: \"" + email + "\"", e);
			returnEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return returnEntity;
	}

	/**
	 * Get a list of trainees in a batch by making a GET request to the URL
	 * 
	 * @param batchId
	 *            id as part of URL
	 * @return Response with list of trainee objects and/or status
	 */
	@RequestMapping(value = "trainees/bybatch/{identifier}",
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Trainee>> getTraineesForBatch(@PathVariable("identifier") int batchId) {
		ResponseEntity<List<Trainee>> returnEntity;

		try {
			List<Trainee> result = businessDelegate.getTraineesInBatch(batchId);

			if (result == null) {
				returnEntity = new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
			} else {
				returnEntity = new ResponseEntity<>(result, HttpStatus.OK);
			}
		} catch (RuntimeException e) {
            logger.error("Error while getting trainees with batchId: " + batchId, e);
			returnEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return returnEntity;
	}

	/**
	 * Get a list of trainees by trainer by making a GET request to the URL
	 *
	 * @param trainerId
	 *            id as part of URL
	 * @return Response with list of trainee objects and/or status
	 */
	@RequestMapping(value = "trainees/bytrainer/{identifier}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Trainee>> getTraineesByTrainer(@PathVariable("identifier") long trainerId) {
		ResponseEntity<List<Trainee>> returnEntity;

		try {
			List<Trainee> result = businessDelegate.getTraineesByTrainer(trainerId);

			if (result == null) {
				returnEntity = new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
			} else {
				returnEntity = new ResponseEntity<>(result, HttpStatus.OK);
			}
		} catch (RuntimeException e) {
			logger.error("Error while getting trainees by trainerId: " + trainerId, e);
			returnEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return returnEntity;
	}
}