package com.revature.caliber.assessments.web.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.caliber.assessments.beans.Assessment;
import com.revature.caliber.assessments.beans.QCStatus;
import com.revature.caliber.assessments.service.BusinessDelegate;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.DELETE, RequestMethod.POST, RequestMethod.GET,
		RequestMethod.PUT }, allowedHeaders = { "X-PINGOTHER", "Content-Type" })
public class QCStatusController {

	private BusinessDelegate delegate;

	@Autowired
	public void setDelegate(BusinessDelegate delegate) {
		this.delegate = delegate;
	}

	/**
	 * Fetch all QCStatus
	 */
	@RequestMapping(value = "/qcstatus/all", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Set<QCStatus>> getAllWeek() {

		ResponseEntity<Set<QCStatus>> returnEntity;

		try {
			Set<QCStatus> result = delegate.getAllStatus();

			if (result == null) {
				returnEntity = new ResponseEntity<Set<QCStatus>>(result, HttpStatus.NOT_FOUND);
			} else {
				returnEntity = new ResponseEntity<Set<QCStatus>>(result, HttpStatus.OK);
			}
		} catch (RuntimeException e) {
			returnEntity = new ResponseEntity<Set<QCStatus>>(HttpStatus.BAD_REQUEST);
		}
		return returnEntity;
	}
	
	
	/**
	 * Fetch all the weeks from a training batch
	 */
	@RequestMapping(value = "/qcstatus/assessment/{status}", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Set<Assessment>> getWeekByBatchId(@PathVariable("status") String status) {
		ResponseEntity<Set<Assessment>> returnEntity;

		try {
			Set<Assessment> result = delegate.getAssessmentByStatus(status);
			
			if (result == null) {
				returnEntity = new ResponseEntity<Set<Assessment>>(result, HttpStatus.NOT_FOUND);
			} else {
				returnEntity = new ResponseEntity<Set<Assessment>>(result, HttpStatus.OK);
			}
		} catch (RuntimeException e) {
			returnEntity = new ResponseEntity<Set<Assessment>>(HttpStatus.BAD_REQUEST);
		}
		return returnEntity;
	}
}
