package com.revature.caliber.controllers;

import com.revature.caliber.beans.Batch;
import com.revature.caliber.beans.Trainee;
import com.revature.caliber.gateway.ApiGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The type All controller.
 */
@RestController
@RequestMapping("/all")
public class AllController {

    private ApiGateway apiGateway;

    @Autowired
    public void setApiGateway(ApiGateway apiGateway) {
        this.apiGateway = apiGateway;
    }

    /**
     * Create batch response entity.
     *
     * @param batch the batch
     * @return the response entity
     */
    @RequestMapping(value = "/batch/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Long> createBatch(@RequestBody Batch batch) {
        Long id = apiGateway.createBatch(batch);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    /**
     * Update batch response entity.
     *
     * @param batch the batch
     * @return the response entity
     */
    @RequestMapping(value = "/batch/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity updateBatch(@RequestBody Batch batch) {
        apiGateway.updateBatch(batch);
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Delete batch response entity.
     *
     * @param id the id of the batch to delete
     * @return the response entity
     */
    @RequestMapping(value = "batch/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity deleteBatch(@PathVariable int id) {
        Batch batch = new Batch();
        batch.setBatchId(id);
        apiGateway.deleteBatch(batch);
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Create trainee response entity.
     *
     * @param trainee the trainee
     * @return the response entity
     */
    @RequestMapping(value = "/trainee/create", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity createTrainee(@RequestBody com.revature.caliber.training.beans.Trainee trainee) {
        long traineeId =  apiGateway.createTrainee(trainee);
        return new ResponseEntity(traineeId, HttpStatus.OK);
    }
    /**
     * Create trainees response entity.
     *
     * @param trainees the trainee
     * @return the response entity
     */
    @RequestMapping(value = "/trainees/create", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity createTrainees(@RequestBody com.revature.caliber.training.beans.Trainee [] trainees) {
        apiGateway.createTrainees(trainees);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    /**
     * Update trainee response entity.
     *
     * @param trainee the trainee
     * @return the response entity
     */
    @RequestMapping(value = "/trainee/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity updateTrainee(@RequestBody Trainee trainee) {
        apiGateway.updateTrainee(trainee);
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Delete trainee response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @RequestMapping(value = "/trainee/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity deleteTrainee(@PathVariable int id) {
        Trainee trainee = new Trainee();
        trainee.setTraineeId(id);
        apiGateway.deleteTrainee(trainee);
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Gets assessment grades by id.
     *
     * @param id the id
     * @return the assessment grades by id
     */
    @RequestMapping(value = "/grades/assessment/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<com.revature.caliber.assessment.beans.Grade>> getAssessmentGradesById(@PathVariable int id) {
        return new ResponseEntity<>(apiGateway.getAssessmentGradesById(id), HttpStatus.OK);
    }

    /**
     * Aggregate function - get values for trainee by tech
     *
     * @param traineeId
     * @return
     */
    @RequestMapping(value = "/agg/tech/trainee/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HashMap<String, Double[]>> aggregateTechTrainee(@PathVariable("id") int traineeId) {
        return new ResponseEntity<>(apiGateway.getTechGradeDataForTrainee(traineeId), HttpStatus.OK);
    }

    @RequestMapping(value = "/agg/week/trainee/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HashMap<String, Double[]>> aggregateWeekTrainee(@PathVariable("id") int traineeId) {
        return new ResponseEntity<>(apiGateway.getWeekGradeDataForTrainee(traineeId), HttpStatus.OK);
    }

    @RequestMapping(value = "/agg/tech/batch/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HashMap<String, Double[]>> aggregateTechBatch(@PathVariable("id") int batchId) {
        return new ResponseEntity<>(apiGateway.getTechGradeDataForBatch(batchId), HttpStatus.OK);
    }

    @RequestMapping(value = "/agg/week/batch/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HashMap<String, Double[]>> aggregateWeekBatch(@PathVariable("id") int batchId) {
        return new ResponseEntity<>(apiGateway.getGradesForBatchWeekly(batchId), HttpStatus.OK);
    }

    @RequestMapping(value = "/agg/batch/trainer/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Double[]>> aggregateTraineesTrainer(@PathVariable("id") int trainerId) {
        return new ResponseEntity<>(apiGateway.getTraineeGradeDataForTrainer(trainerId), HttpStatus.OK);
    }

    @RequestMapping(value = "/trainer/all",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<com.revature.caliber.training.beans.Trainer>> getAllTrainers() {
        return new ResponseEntity(apiGateway.getAllTrainers(), HttpStatus.OK);
    }

}
