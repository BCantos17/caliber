package com.revature.caliber.assessments.web.controllers;

import com.revature.caliber.assessments.beans.QCNote;
import com.revature.caliber.assessments.service.BusinessDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

/**
 * QCNote Controller
 */
@RestController
@CrossOrigin(origins = {"*"},
            methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS},
            allowedHeaders = {"X-PINGOTHER", "Content-Type"},
            maxAge = 10)
public class QCNoteController {

    private BusinessDelegate businessDelegate;
    @Autowired
    public void setBusinessDelegate(BusinessDelegate businessDelegate) { this.businessDelegate = businessDelegate; }

    private static Logger logger = LoggerFactory.getLogger(QCNoteController.class);

    /**
     * Create a new note by making a PUT request to the URL
     * @param note note to put
     * @return Response with appropriate status
     */
    @RequestMapping(value = "qcnotes/new",
                    method = RequestMethod.PUT,
                    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
                    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Serializable> createQCNote(@RequestBody @Valid QCNote note) {
        ResponseEntity<Serializable> returnEntity;
        try {
            businessDelegate.createQCNote(note);
            returnEntity =  new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch (RuntimeException e) {
            logger.error("Error while creating note: " + note, e);
            returnEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return returnEntity;
    }

    /**
     * Update a note
     * @param note note to update
     * @return Response with appropriate status
     */
    @RequestMapping(value = "qcnotes/update",
                    method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
                    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Serializable> updateQCNote(@RequestBody @Valid QCNote note) {
        ResponseEntity<Serializable> returnEntity;
        try{
            businessDelegate.updateQCNote(note);
            returnEntity = new ResponseEntity<>(HttpStatus.OK);
        }
        catch (RuntimeException e) {
            logger.error("Error while updating note: " + note, e);
            returnEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return returnEntity;
    }

    @RequestMapping(value = "qcnotes/delete",
                    method = RequestMethod.DELETE,
                    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
                    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Serializable> deleteQCNote(@RequestBody @Valid QCNote note) {
        ResponseEntity<Serializable> returnEntity;
        try {
            businessDelegate.deleteQCNote(note);
            returnEntity = new ResponseEntity<>(HttpStatus.OK);
        }
        catch (RuntimeException e) {
            logger.error("Error while deleting note: " + note, e);
            returnEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return returnEntity;
    }

    @RequestMapping(value = "qcnotes/byid/{identifier}",
                    method = RequestMethod.GET,
                    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
                    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<QCNote> getQCNoteById(@PathVariable("identifier") int id) {
        ResponseEntity<QCNote> returnEntity;
        try {
            QCNote result = businessDelegate.getQCNoteById(id);
            if (result == null) {
                returnEntity = new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
            }
            else {
                returnEntity = new ResponseEntity<>(result, HttpStatus.OK);
            }
        }
        catch (RuntimeException e) {
            logger.error("Error while getting note by id: " + id, e);
            returnEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return returnEntity;
    }

    @RequestMapping(value = "qcnotes/byweekandtrainee/{week},{trainee}",
                    method = RequestMethod.GET,
                    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
                    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<QCNote> getQCNoteByWeekTrainee(@PathVariable("week") int weekId, @PathVariable("trainee") int traineeId) {
        ResponseEntity<QCNote> returnEntity;
        try {
            QCNote result = businessDelegate.getQCNoteForTraineeWeek(traineeId, weekId);
            if (result == null) {
                returnEntity = new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
            }
            else {
                returnEntity = new ResponseEntity<>(result, HttpStatus.OK);
            }
        }
        catch (RuntimeException e) {
            logger.error("Error while getting note by week " + weekId + ", and trainee " + traineeId, e);
            returnEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return returnEntity;
    }

    @RequestMapping(value = "qcnotes/bytraineeid/{identifier}",
                    method = RequestMethod.GET,
                    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
                    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<QCNote>> getQCNotesByTrainee(@PathVariable("identifier") int traineeId) {
        ResponseEntity<List<QCNote>> returnEntity;
        try {
            List<QCNote> result = businessDelegate.getQCNotesByTrainee(traineeId);
            if (result == null) {
                returnEntity = new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
            }
            else {
                returnEntity = new ResponseEntity<>(result, HttpStatus.OK);
            }
        }
        catch (RuntimeException e) {
            logger.error("Error while getting notes by trainee " + traineeId, e);
            returnEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return returnEntity;
    }

    @RequestMapping(value = "qcnotes/byweekid/{identifier}",
                    method = RequestMethod.GET,
                    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
                    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<QCNote>> getQCNotesByWeek(@PathVariable("identifier") int weekId) {
        ResponseEntity<List<QCNote>> returnEntity;
        try {
            List<QCNote> result = businessDelegate.getQCNotesByWeek(weekId);
            if (result == null) {
                returnEntity = new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
            }
            else {
                returnEntity = new ResponseEntity<>(result, HttpStatus.OK);
            }
        }
        catch (RuntimeException e) {
            logger.error("Error while getting note by week " + weekId, e);
            returnEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return returnEntity;
    }

}
