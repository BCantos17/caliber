package com.revature.caliber.assessments.service.implementations;

import com.revature.caliber.assessments.beans.*;
import com.revature.caliber.assessments.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * The type Business delegate.
 */
@Component(value = "delegate")
public class BusinessDelegateImpl implements BusinessDelegate {

    private AssessmentService assessmentService;
    private BatchNoteService batchNoteService;
    private CategoryService categoryService;
    private GradeService gradeService;
    private NoteService noteService;
    private QCNoteService qcNoteService;
    private QCStatusService qcStatusService;
    private TrainerNoteService trainerNoteService;

    /**
     * Sets assessment service.
     *
     * @param assessmentService the assessment service
     */
// Spring setter based DI
    @Autowired
    public void setAssessmentService(AssessmentService assessmentService) {
        this.assessmentService = assessmentService;
    }

    /**
     * Sets batch note service.
     *
     * @param batchNoteService the batch note service
     */
    @Autowired
    public void setBatchNoteService(BatchNoteService batchNoteService) {
        this.batchNoteService = batchNoteService;
    }

    /**
     * Sets category service.
     *
     * @param categoryService the category service
     */
    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * Sets grade service.
     *
     * @param gradeService the grade service
     */
    @Autowired
    public void setGradeService(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    /**
     * Sets note service.
     *
     * @param noteService the note service
     */
    @Autowired
    public void setNoteService(NoteService noteService) {
        this.noteService = noteService;

    }

    /**
     * Sets qc note service.
     *
     * @param qcNoteService the qc note service
     */
    @Autowired
    public void setQcNoteService(QCNoteService qcNoteService) {
        this.qcNoteService = qcNoteService;
    }

    /**
     * Sets qc status service.
     *
     * @param qcStatusService the qc status service
     */
    @Autowired
    public void setQcStatusService(QCStatusService qcStatusService) {
        this.qcStatusService = qcStatusService;
    }

    /**
     * Sets trainer note service.
     *
     * @param trainerNoteService the trainer note service
     */
    @Autowired
    public void setTrainerNoteService(TrainerNoteService trainerNoteService) {
        this.trainerNoteService = trainerNoteService;
    }

    // Assessment
    @Override
    public Set<Assessment> getAllAssessments() {
        return assessmentService.getAll();
    }

    @Override
    public Assessment getAssessmentById(long id) {
        return assessmentService.getById(id);
    }

    @Override
    public Set<Assessment> getAssessmentsByWeekId(long id) {
        return assessmentService.getByWeekId(id);
    }

    @Override
    public long insertAssessment(Assessment assessment) {
        return assessmentService.insert(assessment);
    }

    @Override
    public void updateAssessment(Assessment assessment) {
        assessmentService.update(assessment);
    }

    @Override
    public void deleteAssessment(Assessment assessment) {
        assessmentService.delete(assessment);
    }
    // End Assessment

    // Grade
    @Override
    public List<Grade> getAllGrades() {
        return gradeService.getAllGrades();
    }

    @Override
    public Grade getGradeByGradeId(long gradeId) {
        return gradeService.getGradeByGradeId(gradeId);
    }

    @Override
    public List<Grade> getGradesByTraineeId(int traineeId) {
        return gradeService.getGradesByTraineeId(traineeId);
    }

    @Override
    public List<Grade> getGradesByAssessment(long assessmentId) {
        return gradeService.getGradesByAssessment(assessmentId);
    }

    @Override
    public Long insertGrade(Grade grade) {
        return gradeService.insertGrade(grade);
    }

    @Override
    public void deleteGrade(Grade grade) {
        gradeService.deleteGrade(grade);
    }

    @Override
    public void updateGrade(Grade grade) {
        gradeService.updateGrade(grade);
    }
    // End Grade

    // QC Note -------------------
    @Override
    public void createQCNote(QCNote note) {
        qcNoteService.createQCNote(note);
    }

    @Override
    public QCNote getQCNoteById(Integer qcNoteId) {
        return qcNoteService.getQCNoteById(qcNoteId);
    }

    @Override
    public QCNote getQCNoteForTraineeWeek(Integer traineeId, Integer weekId) {
        return qcNoteService.getQCNoteForTraineeWeek(traineeId, weekId);
    }

    @Override
    public List<QCNote> getQCNotesByTrainee(Integer traineeId) {
        return qcNoteService.getQCNotesByTrainee(traineeId);
    }

    @Override
    public List<QCNote> getQCNotesByWeek(Integer weekId) {
        return qcNoteService.getQCNotesByWeek(weekId);
    }

    @Override
    public void updateQCNote(QCNote note) {
        qcNoteService.updateQCNote(note);
    }

    @Override
    public void deleteQCNote(QCNote note) {
        qcNoteService.deleteQCNote(note);
    }
    // end QCNote ---------------------

    // Trainer Note
    @Override
    public void createTrainerNote(TrainerNote note) {
        trainerNoteService.createTrainerNote(note);
    }

    public TrainerNote getTrainerNoteById(Integer trainerNoteId) {
        return trainerNoteService.getTrainerNoteById(trainerNoteId);
    }

    public TrainerNote getTrainerNoteForTrainerWeek(Integer trainerId, Integer weekId) {
        return trainerNoteService.getTrainerNoteForTrainerWeek(trainerId, weekId);
    }

    public Set<TrainerNote> getTrainerNotesByTrainer(Integer trainerId) {
        return trainerNoteService.getTrainerNotesByTrainer(trainerId);
    }

    public Set<TrainerNote> getTrainerNotesByWeek(Integer weekId) {
        return trainerNoteService.getTrainerNotesByWeek(weekId);
    }

    public void updateTrainerNote(TrainerNote note) {
        trainerNoteService.updateTrainerNote(note);
    }

    public void deleteTrainerNote(TrainerNote note) {
        trainerNoteService.deleteTrainerNote(note);
    }
    // end trainer note

    // BatchNote

    @Override
    public void makeBatchNote(BatchNote batchNote) {
        batchNoteService.createBatchNote(batchNote);
    }

    @Override
    public List<BatchNote> getBatchesNotesListInWeek(int batchId, int weekId) {
        return batchNoteService.getBatchesNotesListInWeek(batchId, weekId);
    }

    @Override
    public BatchNote getBatchNoteById(int batchNoteId) {
        return batchNoteService.getBatchNoteById(batchNoteId);
    }

    @Override
    public List<BatchNote> allBatchNotes(int batchId) {
        return batchNoteService.allBatchNotes(batchId);
    }

    @Override
    public List<BatchNote> allBatchNotesInWeek(int weekId) {
        return batchNoteService.allBatchNotesInWeek(weekId);
    }

    @Override
    public void updateBatchNote(BatchNote batchNote) {
        batchNoteService.updateBatchNote(batchNote);
    }

    @Override
    public void deleteBatchNote(BatchNote batchNote) {
        batchNoteService.deleteBatchNote(batchNote);
    }
    // End BatchNote

    // Note
    @Override
    public Note getNote(String note) {
        return noteService.getNote(note);
    }

    @Override
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    // Category
    @Override
    public Set<Category> getAllCategories() {
        return categoryService.getAll();
    }

    @Override
    public Category getCategoryById(int id) {
        return categoryService.getById(id);
    }


    //QCStatus
    @Override
    public Set<QCStatus> getAllStatus() {
        return qcStatusService.getAllStatus();
    }

    @Override
    public Set<Assessment> getAssessmentByStatus(String status) {
        return qcStatusService.getAssessmentByStatus(status);
    }

}
