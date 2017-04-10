package com.revature.caliber.assessments.web.controllers;

import com.revature.caliber.assessments.beans.TrainerNote;
import com.revature.caliber.assessments.service.BusinessDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin(origins = { "*" },
        methods = { RequestMethod.GET,
                RequestMethod.POST,
                RequestMethod.PUT,
                RequestMethod.DELETE },
        allowedHeaders = { "X-PINGOTHER", "Content-Type" },
        maxAge = 10)
public class TrainerNoteController {
    private BusinessDelegate delegate;

    //Spring setter based DI
    @Autowired
    public void setDelegate(BusinessDelegate delegate) {
        this.delegate = delegate;
    }

    //Create
    @RequestMapping(
            value = "/trainerNote/new",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createAssessment(@RequestBody TrainerNote trainerNote) {
        delegate.createTrainerNote(trainerNote);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    // getTrainerNoteByid
    @RequestMapping(
            value = "/trainerNote/byID/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrainerNote> getTrainerNoteById (@PathVariable("id") int id) {
        TrainerNote trainerNote = delegate.getTrainerNoteById(id);
        if (trainerNote == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(trainerNote, HttpStatus.OK);
    }

    // getTrainerNoteForWeek
    @RequestMapping(
            value = "/trainerNote/byweekandtrainer/{week},{trainer}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrainerNote> getTrainerNoteForWeek (@PathVariable("trainer") int trainerId, @PathVariable("week") int weekId) {
        TrainerNote trainerNote = delegate.getTrainerNoteForTrainerWeek(trainerId, weekId);
        if (trainerNote == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(trainerNote, HttpStatus.OK);
    }

    // getTrainerNotesByTrainer
    @RequestMapping(
            value = "/trainerNote/byTrainerId/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<TrainerNote>> getTrainerNotesByTrainer (@PathVariable("id") int id) {
        Set<TrainerNote> trainerNote = delegate.getTrainerNotesByTrainer(id);
        if (trainerNote == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(trainerNote, HttpStatus.OK);
    }

    // getTrainerNotesByTrainer
    @RequestMapping(
            value = "/trainerNote/byWeekId/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<TrainerNote>> getTrainerNotesByWeek (@PathVariable("id") int id) {
        Set<TrainerNote> trainerNote = delegate.getTrainerNotesByWeek(id);
        if (trainerNote == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(trainerNote, HttpStatus.OK);
    }

    //Update
    @RequestMapping(
            value = "/trainerNote/update",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateTrainerNote(@RequestBody TrainerNote trainerNote) {
        delegate.updateTrainerNote(trainerNote);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "/trainerNote/delete",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteAssessment(@RequestBody TrainerNote trainerNote) {
        delegate.deleteTrainerNote(trainerNote);
        return new ResponseEntity(HttpStatus.OK);
    }
}
