package com.revature.caliber.training.web.controllers;

import com.revature.caliber.training.beans.Trainer;
import com.revature.caliber.training.service.BusinessDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Trainer Controller
 */

@RestController
@CrossOrigin(origins = { "*" }, methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE }, allowedHeaders = { "X-PINGOTHER", "Content-Type" }, maxAge = 10)
public class TrainerController {

	private BusinessDelegate businessDelegate;

	@Autowired
	public void setBusinessDelegate(BusinessDelegate businessDelegate) {
		this.businessDelegate = businessDelegate;
	}

	/**
	 * Creates a new trainer by making a PUT request to the URL
	 * 
	 * @param: trainer
	 *             to put
	 * @return: Response with appropriate status
	 */
	@RequestMapping(value = "trainers/new", 
					method = RequestMethod.POST, 
					consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Serializable> createTrainer(@RequestBody @Valid Trainer trainer) {
		ResponseEntity<Serializable> returnEntity;
		try {
			businessDelegate.createTrainer(trainer);
			returnEntity = new ResponseEntity<Serializable>(HttpStatus.CREATED);
		} catch (RuntimeException e) {
			returnEntity = new ResponseEntity<Serializable>(HttpStatus.BAD_REQUEST);
		}
		return returnEntity;
	}

	/**
     * Get a trainer by id by making a GET request to the URL
     * @param: id as part of URL
     * @return: Response with trainer object and/or appropriate status
     */
	@RequestMapping(value = "/trainers/byid/{identifier}", 
					method = RequestMethod.GET, 
					produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Trainer> getTrainerById(@PathVariable("identifier") int id) {
		ResponseEntity<Trainer> returnEntity;
		try {
			Trainer result = businessDelegate.getTrainer(id);

			if (result == null) {
				returnEntity = new ResponseEntity<Trainer>(result, HttpStatus.NOT_FOUND);
			} else {
				returnEntity = new ResponseEntity<Trainer>(result, HttpStatus.OK);
			}
		} catch (RuntimeException e) {
			returnEntity = new ResponseEntity<Trainer>(HttpStatus.BAD_REQUEST);
		}
		return returnEntity;
	}

	/**
     * Get a list of trainers by email by making a GET request to the URL
     * @param: email as part of URL
     * @return Response with trainer object and/or status
     */
	@RequestMapping(value = "trainers/byemail/{identifier}/", 
					method = RequestMethod.GET, 
					produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Trainer> getTrainerByEmail(@PathVariable("identifier") String email) {
		Trainer result = businessDelegate.getTrainer(email);
		return new ResponseEntity<Trainer>(result, corsHeaders(),
			HttpStatus.OK);
	}

	/**
	 * Get a list of all trainers by making a GET request to the URL
	 * 
	 * @return Response with list of trainer objects and/or status
	 */
	@RequestMapping(value = "trainers/all", 
					method = RequestMethod.GET, 
					produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Set<Trainer>> getAllTrainers() {
		ResponseEntity<Set<Trainer>> returnEntity;
		try {
			Set<Trainer> result = businessDelegate.getAllTrainers();

			if (result == null) {
				returnEntity = new ResponseEntity<Set<Trainer>>(result, HttpStatus.NOT_FOUND);
			} else {
				returnEntity = new ResponseEntity<Set<Trainer>>(result, HttpStatus.OK);
			}
		} catch (RuntimeException e) {
			returnEntity = new ResponseEntity<Set<Trainer>>(HttpStatus.BAD_REQUEST);
		}
		return returnEntity;
	}

	/**
	 * Update a trainer by making a POST request to the URL
	 * 
	 * @param: trainer
	 *             to update
	 * @return: Response with appropriate status
	 */
	@RequestMapping(value = "trainers/update", 
					method = RequestMethod.POST, 
					consumes = MediaType.APPLICATION_JSON_VALUE, 
					produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Serializable> updateTrainer(@RequestBody @Valid Trainer trainer) {
		ResponseEntity<Serializable> returnEntity;
		try {
			businessDelegate.updateTrainer(trainer);
			returnEntity = new ResponseEntity<Serializable>(HttpStatus.OK);
		} catch (RuntimeException e) {
			returnEntity = new ResponseEntity<Serializable>(HttpStatus.BAD_REQUEST);
		}
		return returnEntity;
	}


	public MultiValueMap<String, String> corsHeaders(){
		MultiValueMap<String, String> headers =
				new LinkedMultiValueMap<String, String>();
		headers.put("Access-Control-Allow-Origin",
				Arrays.asList(new String[]{"*"}));
		headers.put("Access-Control-Allow-Methods",
				Arrays.asList(new String[]{"POST", "GET", "OPTIONS"}));
		headers.put("Access-Control-Allow-Headers",
				Arrays.asList(new String[]{"X-PINGOTHER", "Content-Type"}));
		headers.put("Access-Control-Max-Age",
				Arrays.asList(new String[]{"10"}));
		return headers;
	}
}
