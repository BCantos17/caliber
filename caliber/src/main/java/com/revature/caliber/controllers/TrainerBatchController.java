package com.revature.caliber.controllers;

import com.revature.caliber.assessment.beans.*;
import com.revature.caliber.beans.*;
import com.revature.caliber.beans.Assessment;
import com.revature.caliber.beans.BatchNote;
import com.revature.caliber.beans.Note;
import com.revature.caliber.gateway.ApiGateway;
import com.revature.caliber.models.SalesforceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * The type Trainer batch controller.
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/trainer")
public class TrainerBatchController {

    private ApiGateway apiGateway;

    /**
     * Sets api gateway.
     *
     * @param apiGateway the api gateway
     */
    @Autowired
    public void setApiGateway(ApiGateway apiGateway) {
        this.apiGateway = apiGateway;
    }

    /**
     * getAllBatches - REST API method, retrieves all batches belonging to the trainer
     *
     * @return in JSON, a set of batch objects
     */
    @RequestMapping(value = "/batch/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<Batch>> getAllBatches(Authentication authentication) {
        SalesforceUser salesforceUser = (SalesforceUser) authentication.getPrincipal();
        return new ResponseEntity<>(apiGateway.getBatches(salesforceUser.getCaliberId()), HttpStatus.OK);
    }

    /**
     * getCurrentBatch - REST API method, retrieves the current batch
     *
     * @return - in JSON, a batch object
     */
    @RequestMapping(value = "/batch/current", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Batch>> getCurrentBatch() {
        SalesforceUser salesforceUser = (SalesforceUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return new ResponseEntity<>(apiGateway.currentBatch(salesforceUser.getCaliberId()), HttpStatus.OK);
    }

    /**
     * Create new week response entity.
     *
     * @param week the week
     * @return the response entity
     */
    @RequestMapping(value = "/week/new", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createNewWeek(@RequestBody Week week) {
        return new ResponseEntity(apiGateway.createNewWeek(week), HttpStatus.CREATED);
    }

    /**
     * Create grade response entity.
     *
     * @param grade the grade
     * @return the response entity
     */
    @RequestMapping(value = "/grade/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createGrade(@RequestBody com.revature.caliber.assessment.beans.Grade grade) {
        return new ResponseEntity( apiGateway.insertGrade(grade), HttpStatus.CREATED);
    }

    /**
     * Update grade response entity.
     *
     * @param grade the grade
     * @return the response entity
     */
    @RequestMapping(value = "/grade/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateGrade(@RequestBody com.revature.caliber.assessment.beans.Grade grade) {
        apiGateway.updateGrade(grade);
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Create assessment response entity.
     *
     * @param assessment the assessment
     * @return the response entity
     */
    @RequestMapping(value = "/assessment/create",
                    method = RequestMethod.PUT,
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> createAssessment(@RequestBody com.revature.caliber.assessment.beans.Assessment assessment) {
        long assessmentId = apiGateway.createAssessment(assessment);
        return new ResponseEntity(assessmentId, HttpStatus.OK);
    }

    /**
     * Delete assessment response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @RequestMapping(value = "/assessment/delete/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteAssessment(@PathVariable int id) {
        com.revature.caliber.assessment.beans.Assessment assessment = new com.revature.caliber.assessment.beans.Assessment();
        assessment.setAssessmentId(id);
        apiGateway.deleteAssessment(assessment);
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Update assessment response entity.
     *
     * @param assessment the assessment
     * @return the response entity
     */
    @RequestMapping(value = "/assessment/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateAssessment(@RequestBody com.revature.caliber.assessment.beans.Assessment assessment) {
        apiGateway.updateAssessment(assessment);
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Update assessment response entity.
     *
     * @return the response entity
     */
    @RequestMapping(value = "/assessment/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<com.revature.caliber.assessment.beans.Assessment>> getAllAssessments() {
        List<com.revature.caliber.assessment.beans.Assessment> list = apiGateway.getAllAssessments();
        int i = 0;
        while (i < list.size()) {
            if (list.get(i).getWeeklyStatus() != null) {
                list.remove(i);
            }
            else {
                i++;
            }
        }
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/assessment/week/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<com.revature.caliber.assessment.beans.Assessment>> getAssessmentsByWeekId(@PathVariable long id){
        List<com.revature.caliber.assessment.beans.Assessment> list = apiGateway.getAssessmentsByWeekId(id);
        return new ResponseEntity(list,HttpStatus.OK);
    }

    /**
     * Update assessment note response entity.
     *
     * @param note the note
     * @return the response entity
     */
    @RequestMapping(value = "/assessment/note/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateAssessmentNote(@RequestBody Note note) {
        apiGateway.updateAssessmentNote(note);
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Create assessment note response entity.
     *
     * @param note the note
     * @return the response entity
     */
    @RequestMapping(value = "/assessment/note/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createAssessmentNote(@RequestBody Note note) {
        apiGateway.createAssessmentNote(note);
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Create batch note for assessment response entity.
     *
     * @param batchNote the batch note
     * @return the response entity
     */
    @RequestMapping(value = "/assessment/batch/note/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createBatchNoteForAssessment(@RequestBody BatchNote batchNote) {
        apiGateway.createBatchNote(batchNote);
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Update batch note for assessment response entity.
     *
     * @param batchNote the batch note
     * @return the response entity
     */
    @RequestMapping(value = "/assessment/batch/note/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateBatchNoteForAssessment(@RequestBody BatchNote batchNote) {
        apiGateway.updateBatchNote(batchNote);
        return new ResponseEntity(HttpStatus.OK);
    }

}
