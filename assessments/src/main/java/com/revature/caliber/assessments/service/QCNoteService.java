package com.revature.caliber.assessments.service;

import com.revature.caliber.assessments.beans.QCNote;

import java.util.List;

/**
 * Just delegation of the methods.
 */
public interface QCNoteService {

    void createQCNote(QCNote note);
    QCNote getQCNoteById(Integer qcNoteId);
    QCNote getQCNoteForTraineeWeek(Integer traineeId, Integer weekId);
    List<QCNote> getQCNotesByTrainee(Integer traineeId);
    List<QCNote> getQCNotesByWeek(Integer weekId);
    void updateQCNote(QCNote note);
    void deleteQCNote(QCNote note);

}
