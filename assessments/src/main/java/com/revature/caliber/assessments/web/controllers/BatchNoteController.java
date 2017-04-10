package com.revature.caliber.assessments.web.controllers;

import java.util.List;

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

import com.revature.caliber.assessments.beans.BatchNote;
import com.revature.caliber.assessments.beans.TrainerNote;
import com.revature.caliber.assessments.service.BusinessDelegate;

@RestController
@CrossOrigin(origins = { "*" },
        methods = { RequestMethod.GET,
                RequestMethod.POST,
                RequestMethod.PUT,
                RequestMethod.DELETE },
        allowedHeaders = { "X-PINGOTHER", "Content-Type" },
        maxAge = 10)
public class BatchNoteController {
	private BusinessDelegate delegate;
	
	 @Autowired
	    public void setDelegate(BusinessDelegate delegate) {
	        this.delegate = delegate;
	    }
	
	//Create BatchNote
    @RequestMapping(
            value = "/batchNote/new",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BatchNote> createAssessment(@RequestBody BatchNote batchNote) {
        delegate.makeBatchNote(batchNote);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    //Update a BatchNote
    @RequestMapping(
            value = "/batchNote/update",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BatchNote> updateTrainerNote(@RequestBody TrainerNote trainerNote) {
        delegate.updateTrainerNote(trainerNote);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //Delete a BatchNote
    @RequestMapping(
            value = "/batchNote/delete",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BatchNote> deleteAssessment(@RequestBody BatchNote batchNote) {
        delegate.deleteBatchNote(batchNote);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    //List of all BatchNotes for a single batch 
    @RequestMapping(
            value = "/batchNote/batch{batchId}/all",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BatchNote>> allBatchNotes (@PathVariable("batchId") int batchId) {
        List<BatchNote> batchNote = delegate.allBatchNotes(batchId);
        if (batchNote == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(batchNote, HttpStatus.OK);
    }
    
    //List all Batches' BatchNotes for a given week
    @RequestMapping(
            value = "/batchNote/week{weekId}/all",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BatchNote>> allBatchNotesWithinWeek (@PathVariable("weekId") int weekId) {
        List<BatchNote> batchNote = delegate.allBatchNotes(weekId);
        if (batchNote == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(batchNote, HttpStatus.OK);
    }
      
 
	  @RequestMapping(
	            value = "/batchNote/byId/{id}",
	            method = RequestMethod.GET,
	            produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<BatchNote> getBatchNoteById (@PathVariable("id") int id) {
	        BatchNote batchNote = delegate.getBatchNoteById(id);
	        if (batchNote == null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<>(batchNote, HttpStatus.OK);
	    }
    
    
    @RequestMapping(
            value = "/batchNote/batch{batchId}/weekId{weekId}/all",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BatchNote>> getBatchesNoteListInWeek(@PathVariable("batchId") int batchId, @PathVariable("weekId") int weekId) {
    	List<BatchNote> batchNote = delegate.getBatchesNotesListInWeek(batchId, weekId);
          if (batchNote == null) {
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
          return new ResponseEntity<>(batchNote, HttpStatus.OK);
    	
    }
    
}
