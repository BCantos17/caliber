package com.revature.caliber.assessments.data;

import com.revature.caliber.assessments.beans.QCNote;

import java.util.List;

/**
 * DAO for qcnote
 * @author Ilya
 */
public interface QCNoteDAO {

    /**
     * Create a new note
     * @param note note to create
     */
    void createQCNote(QCNote note);

    /**
     * Get note by id.
     * @param QCNoteId id of a note to get
     * @return QCNote object
     */
    QCNote getQCNoteById(Integer qcNoteId);

    /**
     * Get QCNote for a pair of trainee and week ids
     * @param traineeId id of a trainee
     * @param weekId id of a week
     * @return QCNote object
     */
    QCNote getQCNoteForTraineeWeek(Integer traineeId, Integer weekId);

    /**
     * Get all notes for a trainee
     * @param traineeId id of a trainee
     * @return list of notes for that id
     */
    List<QCNote> getQCNotesByTrainee(Integer traineeId);

    /**
     * Get all notes for a week
     * @param weekId
     * @return
     */
    List<QCNote> getQCNotesByWeek(Integer weekId);

    /**
     * Update the note's information
     * @param note note to update
     */
    void updateQCNote(QCNote note);

    /**
     * Delete a note
     * @param note note to delete
     */
    void deleteQCNote(QCNote note);
}
