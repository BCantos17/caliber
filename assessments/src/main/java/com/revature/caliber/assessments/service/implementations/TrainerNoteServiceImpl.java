package com.revature.caliber.assessments.service.implementations;

import com.revature.caliber.assessments.beans.TrainerNote;
import com.revature.caliber.assessments.data.Facade;
import com.revature.caliber.assessments.service.TrainerNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service(value = "trainerNoteService")
public class TrainerNoteServiceImpl implements TrainerNoteService {


    private Facade facade;

    @Autowired
    public void setFacade(Facade facade) {
        this.facade = facade;
    }

    public void createTrainerNote(TrainerNote note) {
        facade.createTrainerNote(note);
    }

    public TrainerNote getTrainerNoteById(Integer trainerNoteId) {
        return facade.getTrainerNoteById(trainerNoteId);
    }

    public TrainerNote getTrainerNoteForTrainerWeek(Integer trainerId, Integer weekId) {
        return facade.getTrainerNoteForTrainerWeek(trainerId, weekId);
    }

    public Set<TrainerNote> getTrainerNotesByTrainer(Integer trainerId) {
        return facade.getTrainerNotesByTrainer(trainerId);
    }

    public Set<TrainerNote> getTrainerNotesByWeek(Integer weekId) {
        return facade.getTrainerNotesByWeek(weekId);
    }

    public void updateTrainerNote(TrainerNote note) {
        facade.updateTrainerNote(note);
    }

    public void deleteTrainerNote(TrainerNote note) {
        facade.deleteTrainerNote(note);
    }
}
