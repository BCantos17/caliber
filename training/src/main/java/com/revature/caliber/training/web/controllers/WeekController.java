package com.revature.caliber.training.web.controllers;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;

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

import com.revature.caliber.training.beans.Week;
import com.revature.caliber.training.service.BusinessDelegate;


@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.DELETE, RequestMethod.POST, RequestMethod.GET,
		RequestMethod.PUT }, allowedHeaders = { "X-PINGOTHER", "Content-Type" })
public class WeekController {

	private BusinessDelegate businessDelegate;

	@Autowired
	public void setBusinessDelegate(BusinessDelegate businessDelegate) {
		this.businessDelegate = businessDelegate;
	}

	/**
	 * Fetch all the weeks
	 */
	@RequestMapping(value = "/week/all", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Week>> getAllWeek() {

		ResponseEntity<List<Week>> returnEntity;

		try {
			List<Week> result = businessDelegate.getAllWeeks();

			if (result == null) {
				returnEntity = new ResponseEntity<List<Week>>(result, HttpStatus.NOT_FOUND);
			} else {
				returnEntity = new ResponseEntity<List<Week>>(result, HttpStatus.OK);
			}
		} catch (RuntimeException e) {
			returnEntity = new ResponseEntity<List<Week>>(HttpStatus.BAD_REQUEST);
		}
		return returnEntity;
	}

	
	/**
	 * Fetch all the weeks from a training batch
	 */
	@RequestMapping(value = "/week/batchid/{batchId}", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Week>> getWeekByBatchId(@PathVariable("batchId") int batchId) {
		ResponseEntity<List<Week>> returnEntity;

		try {
			List<Week> result = businessDelegate.getWeekByBatchId(batchId);
			
			if (result == null) {
				returnEntity = new ResponseEntity<List<Week>>(result, HttpStatus.NOT_FOUND);
			} else {
				returnEntity = new ResponseEntity<List<Week>>(result, HttpStatus.OK);
			}
		} catch (RuntimeException e) {
			returnEntity = new ResponseEntity<List<Week>>(HttpStatus.BAD_REQUEST);
		}
		return returnEntity;
	}
	
	
	/**
	 * Fetch a specific week from all batches
	 * @param weeknumber
	 * @return
	 */
	@RequestMapping(value = "/week/weeknumber/{weeknumber}", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Week>> getWeekByWeekNumber(@PathVariable("weeknumber") int weeknumber) {
		ResponseEntity<List<Week>> returnEntity;

		try {
			List<Week> result = businessDelegate.getWeekByWeekNumber(weeknumber);

			if (result == null) {
				returnEntity = new ResponseEntity<List<Week>>(result, HttpStatus.NOT_FOUND);
			} else {
				returnEntity = new ResponseEntity<List<Week>>(result, HttpStatus.OK);
			}
		} catch (RuntimeException e) {
			returnEntity = new ResponseEntity<List<Week>>(HttpStatus.BAD_REQUEST);
		}
		return returnEntity;
	}
	
	
	/**
	 * Create a new week for a batch
	 * @param week
	 * @return
	 */
    @RequestMapping(value = "/week/new",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> createWeek( @RequestBody @Valid Week week ) {
        ResponseEntity<Long> returnEntity;
        try {
            returnEntity =  new ResponseEntity<>(businessDelegate.createWeek(week), HttpStatus.CREATED);
        }
        catch (RuntimeException e) {
            returnEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return returnEntity;
    }
}
