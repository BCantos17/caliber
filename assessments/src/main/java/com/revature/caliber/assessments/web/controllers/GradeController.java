package com.revature.caliber.assessments.web.controllers;

import com.revature.caliber.assessments.beans.Grade;
import com.revature.caliber.assessments.service.BusinessDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

@RestController
@CrossOrigin(origins = { "*" }, 
				methods = { RequestMethod.GET, 
							RequestMethod.POST, 
							RequestMethod.PUT,
							RequestMethod.DELETE }, 
				allowedHeaders = { "X-PINGOTHER", "Content-Type" },
				maxAge = 10)
public class GradeController {
	
	private BusinessDelegate delegate;

	@Autowired
	public void setDelegate(BusinessDelegate delegate) {
		this.delegate = delegate;
	}
	
	@RequestMapping(value="/grades/all",
					method=RequestMethod.GET,
					produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Grade>> getAllGrades(){
		List<Grade> grades = delegate.getAllGrades();
		if(grades == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(grades, HttpStatus.OK);
		}
		
	}
	
	@RequestMapping(value="/grades/{gradeId}",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Grade> getGradesById(@PathVariable (value="gradeId") int gradeId){
		Grade grade = delegate.getGradeByGradeId(gradeId);
		if(grade == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			return new ResponseEntity<>(grade,HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/grades/trainee/{traineeId}",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Grade>> getGradesByTraineeId(@PathVariable (value="traineeId") int traineeId){
		List<Grade> grades = delegate.getGradesByTraineeId(traineeId);
		if(grades == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			return new ResponseEntity<>(grades,HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/grades/assessment/{assessmentId}",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Grade>> getGradesByAssessmentId(@PathVariable (value="assessmentId") int assessmentId){
		List<Grade> grades = delegate.getGradesByAssessment(assessmentId);
		if(grades == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			return new ResponseEntity<>(grades,HttpStatus.OK);
		}
	}

	@RequestMapping (value = "/grades/create",
					method = RequestMethod.PUT,
					consumes = MediaType.APPLICATION_JSON_VALUE,
					produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Long> createGrade(@RequestBody @Valid Grade grade) {
		ResponseEntity<Long> returnEntity;
		try {
			returnEntity = new ResponseEntity<>(delegate.insertGrade(grade), HttpStatus.OK);
		}
		catch (RuntimeException e) {
			returnEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return returnEntity;
	}

	@RequestMapping (value = "/grades/update",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Serializable> updateGrade(@RequestBody @Valid Grade grade) {
		ResponseEntity<Serializable> returnEntity;

		try {
			delegate.updateGrade(grade);
			returnEntity = new ResponseEntity<>(HttpStatus.OK);
		}
		catch (RuntimeException e) {
			returnEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return returnEntity;
	}


}
