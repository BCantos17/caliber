package com.revature.caliber.controllers;

import com.revature.caliber.assessment.beans.*;
import com.revature.caliber.beans.*;
import com.revature.caliber.beans.Assessment;
import com.revature.caliber.beans.BatchNote;
import com.revature.caliber.beans.Grade;
import com.revature.caliber.beans.Note;
import com.revature.caliber.gateway.ApiGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * The type Qc batch controller.
 */
@RestController
@RequestMapping("/qc")
public class QCBatchController {

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
     * Gets all batches.
     *
     * @return the all batches
     */
    @RequestMapping(value = "/batch/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Batch>> getAllBatches() {
        return new ResponseEntity<>(apiGateway.getCurrentBatches(), HttpStatus.OK);

    }

    /**
     * Create grade response entity.
     *
     * @param grade the grade
     * @return the response entity
     */
    @RequestMapping(value = "/grade/create",
                    method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createGrade(@RequestBody com.revature.caliber.assessment.beans.Grade grade) {
        return new ResponseEntity(apiGateway.insertGrade(grade), HttpStatus.OK);
    }

    /**
     * Update grade response entity.
     *
     * @param grade the grade
     * @return the response entity
     */
    @RequestMapping(value = "/grade/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
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
    public ResponseEntity createAssessment(@RequestBody com.revature.caliber.assessment.beans.Assessment assessment) {
        apiGateway.createAssessment(assessment);
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Delete assessment response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @RequestMapping(value = "assessment/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
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
     * Gets all assessments.
     *
     * @return the all assessments
     */
    @RequestMapping(value = "/assessment/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<com.revature.caliber.assessment.beans.Assessment>> getAllAssessments() {
        return new ResponseEntity<>(apiGateway.getAllAssessments(), HttpStatus.OK);
    }

    /**
     * Update assessment note response entity.
     *
     * @param note the note
     * @return the response entity
     */
    @RequestMapping(value = "assessment/note/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
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
