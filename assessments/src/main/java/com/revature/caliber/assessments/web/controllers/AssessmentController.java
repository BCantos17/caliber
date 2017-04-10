package com.revature.caliber.assessments.web.controllers;

import com.revature.caliber.assessments.beans.Assessment;
import com.revature.caliber.assessments.service.BusinessDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Controller for Assessments, will perform actions to the DB depending on the uri endpoint accessed
 */
@RestController    // infers @ResponseBody on all methods && @Controller
@CrossOrigin(origins = {"*"},
        methods = { RequestMethod.GET,
                    RequestMethod.POST,
                    RequestMethod.PUT,
                    RequestMethod.DELETE},
        allowedHeaders = {"X-PINGOTHER", "Content-Type"},
        maxAge = 10)
public class AssessmentController {

    /**
     * Business delegate object to call methods on
     */
    private BusinessDelegate delegate;

    /**
     * Spring setter based Dependency Injection
     * @param delegate the BusinessDelegate to be injected
     */
    @Autowired
    public void setDelegate(BusinessDelegate delegate) {
        this.delegate = delegate;
    }

//    Get
    // getAllAssessments
    /**
     * Returns a set of all Assessments
     * @return a ResponseEntity containing a Set of Assessments and a HttpStatus
     */
    @RequestMapping(
            value = "/assessment/all",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<Assessment>> getAll() {
        Set<Assessment> assessments = delegate.getAllAssessments();
        if (assessments.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(assessments, HttpStatus.OK);
    }

    // getAssessmentById
    /**
     * Returns an Assessment with the specified ID,
     * sends a HTTP NOT FOUND status if not found
     * @param id the Assessment ID
     * @return the Assessment with the specified ID
     */
    @RequestMapping(
            value = "/assessment/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Assessment> getById(@PathVariable("id") long id) {
        Assessment assessment = delegate.getAssessmentById(id);
        if (assessment == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(assessment, HttpStatus.OK);
    }

    // getAssessmentsByWeekId
    /**
     * Returns an Assessment with specified Week Id,
     * sends a HTTP NOT FOUND status if nothing is found
     * @param id the Week ID
     * @return ResponseEntity containing a set of Assessments and a HttpStatus
     */
    @RequestMapping(
            value = "/assessment/week/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<Assessment>> getByWeekId(@PathVariable("id") long id) {
        Set<Assessment> assessments = delegate.getAssessmentsByWeekId(id);
        if (assessments.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(assessments, HttpStatus.OK);
    }

//    Create
    /**
     * Creates a new Assessment in the database
     * @param assessment the Assessment to be inserted
     * @return ResponseEntity with HttpStatus indicating success
     */
    //POST is used over PUT since we are not specifying specific assessment url
    @RequestMapping(
            value = "/assessment/new",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> createAssessment(@RequestBody Assessment assessment) {
        long assessmentId = delegate.insertAssessment(assessment);
        return new ResponseEntity(assessmentId, HttpStatus.CREATED);
    }

//    Update
    /**
     * Updates an Assessment in the database with supplied
     * @param assessment the Assessment with data to update matching Assessment in database
     * @return ResponseEntity with HttpStatus indicating update status
     */
    @RequestMapping(
            value = "/assessment/update",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateAssessment(@RequestBody Assessment assessment) {
        delegate.updateAssessment(assessment);
        return new ResponseEntity(HttpStatus.OK);
    }

//    Delete
    /**
     * Deletes Assessment in database matching supplied Assessment
     * @param assessment the Assessment to be deleted
     * @return ResponseEntity with HttpStatus indicating deletion status
     */
    @RequestMapping(
            value = "/assessment/delete",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteAssessment(@RequestBody Assessment assessment) {
        delegate.deleteAssessment(assessment);
        return new ResponseEntity(HttpStatus.OK);
    }
}
