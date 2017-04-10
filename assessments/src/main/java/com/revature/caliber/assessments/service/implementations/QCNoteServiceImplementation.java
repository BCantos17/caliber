package com.revature.caliber.assessments.service.implementations;

import com.revature.caliber.assessments.beans.QCNote;
import com.revature.caliber.assessments.data.Facade;
import com.revature.caliber.assessments.service.QCNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Just delegation
 * @author Ilya
 */
@Component
public class QCNoteServiceImplementation implements QCNoteService {

    private Facade facade;
    @Autowired
    public void setFacade(Facade facade) { this.facade = facade; }

    @Override
    public void createQCNote(QCNote note) { facade.createQCNote(note); }

    @Override
    public QCNote getQCNoteById(Integer qcNoteId) { return facade.getQCNoteById(qcNoteId); }

    @Override
    public QCNote getQCNoteForTraineeWeek(Integer traineeId, Integer weekId) { return facade.getQCNoteForTraineeWeek(traineeId, weekId); }

    @Override
    public List<QCNote> getQCNotesByTrainee(Integer traineeId) { return facade.getQCNotesByTrainee(traineeId); }

    @Override
    public List<QCNote> getQCNotesByWeek(Integer weekId) { return facade.getQCNotesByWeek(weekId); }

    @Override
    public void updateQCNote(QCNote note) { facade.updateQCNote(note); }

    @Override
    public void deleteQCNote(QCNote note) { facade.deleteQCNote(note); }
}
