package com.revature.caliber.assessments.data.implementations;

import com.revature.caliber.assessments.beans.*;
import com.revature.caliber.assessments.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;


/**
 * Our implementation of the Facade interface
 */

@Component(value = "assessmentFacadeImplementation")
public class FacadeImplementation implements Facade {

    //  DI via Spring setter injection
    private AssessmentDAO assessmentDAO;
    private BatchNoteDAO batchNoteDAO;
    private CategoryDAO categoryDAO;
    private GradeDAO gradeDAO;
    private NoteDAO noteDAO;
    private QCNoteDAO qcNoteDAO;
    private QCStatusDAO qcStatusDAO;
    private TrainerNoteDAO trainerNoteDAO;

    //  Spring setter based DI
    @Autowired
    public void setAssessmentDAO(AssessmentDAO assessmentDAO) {
        this.assessmentDAO = assessmentDAO;
    }

    @Autowired
    public void setBatchNoteDAO(BatchNoteDAO batchNoteDAO) {
        this.batchNoteDAO = batchNoteDAO;
    }

    @Autowired
    public void setCategoryDAO(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @Autowired
    public void setGradeDAO(GradeDAO gradeDAO) {
        this.gradeDAO = gradeDAO;
    }

    @Autowired
    public void setNoteDAO(NoteDAO noteDAO) {
        this.noteDAO = noteDAO;
    }

    @Autowired
    public void setQcNoteDAO(QCNoteDAO qcNoteDAO) {
        this.qcNoteDAO = qcNoteDAO;
    }

    @Autowired
    public void setQcStatusDAO(QCStatusDAO qcStatusDAO) {
        this.qcStatusDAO = qcStatusDAO;
    }

    @Autowired
    public void setTrainerNoteDAO(TrainerNoteDAO trainerNoteDAO) {
        this.trainerNoteDAO = trainerNoteDAO;
    }

//  Assessment
    // Get
    @Override
    public Set<Assessment> getAllAssessments() {
        return assessmentDAO.getAll();
    }

    @Override
    public Assessment getAssessmentById(long id) {
        return assessmentDAO.getById(id);
    }

    @Override
    public Set<Assessment> getAssessmentsByWeekId(long id) {
        return assessmentDAO.getByWeekId(id);
    }

    //Create
    @Override
    public long insertAssessment(Assessment assessment) {
        return assessmentDAO.insert(assessment);
    }

    //Update
    @Override
    public void updateAssessment(Assessment assessment) {
        assessmentDAO.update(assessment);
    }

    //Delete
    @Override
    public void deleteAssessment(Assessment assessment) {
        assessmentDAO.delete(assessment);
    }

//  BatchNote

    //BatchNote Facade Methods
    @Override
    public void makeBatchNote(BatchNote batchNote) {
        batchNoteDAO.createBatchNote(batchNote);
    }

    @Override
    public List<BatchNote> allBatchNotesInWeek(int weekId) {
        return batchNoteDAO.allBatchNotesByWeek(weekId);
    }

    @Override
    public List<BatchNote> allBatchNotes(int batchId) {
        return batchNoteDAO.allBatchNotes(batchId);
    }
    
    @Override
    public void updateBatchNote(BatchNote batchNote){
    	batchNoteDAO.updateBatchNote(batchNote);
    }
    
    @Override
    public void deleteBatchNote(BatchNote batchNote){
    	batchNoteDAO.deleteBatchNote(batchNote);
    }

    @Override
    public BatchNote getBatchNoteById(int batchNoteId) {
    	return batchNoteDAO.getBatchNoteById(batchNoteId);
    }
    
    @Override
    public List<BatchNote> getBatchesNotesListInWeek(int batchId, int weekId) {
        return batchNoteDAO.getBatchesNotesListInWeek(batchId, weekId);
    }
    
    
// Grade


    //    Category
    @Override
    public Set<Category> getAllCategories() {
        return categoryDAO.getAll();
    }

    @Override
    public Category getCategoryById(int id) {
        return categoryDAO.getById(id);
    }

    // Grade
    //Gets
    @Override
    public List<Grade> getAllGrades() {
        return gradeDAO.getAllGrades();
    }

    @Override
    public Grade getGradeByGradeId(long gradeId) {
        return gradeDAO.getGradeByGradeId(gradeId);
    }

    @Override
    public List<Grade> getGradesByTraineeId(int traineeId) {
        return gradeDAO.getGradesByTraineeId(traineeId);
    }

    @Override
    public List<Grade> getGradesByAssessment(long assessmentId) {
        return gradeDAO.getGradesByAssessment(assessmentId);
    }

    //Insert
    @Override
    public Long insertGrade(Grade grade) {return gradeDAO.insertGrade(grade);}

    //Delete
    @Override
    public void deleteGrade(Grade grade) {
        gradeDAO.deleteGrade(grade);

    }

    //Update
    @Override
    public void updateGrade(Grade grade) {
        gradeDAO.updateGrade(grade);
    }

    //TrainerNote
    public void createTrainerNote(TrainerNote note) {
        trainerNoteDAO.createTrainerNote(note);
    }

    public TrainerNote getTrainerNoteById(Integer trainerNoteId) {
        return trainerNoteDAO.getTrainerNoteById(trainerNoteId);
    }

    public TrainerNote getTrainerNoteForTrainerWeek(Integer trainerId, Integer weekId) {
        return trainerNoteDAO.getTrainerNoteForTrainerWeek(trainerId, weekId);
    }

    public Set<TrainerNote> getTrainerNotesByTrainer(Integer trainerId) {
        return trainerNoteDAO.getTrainerNotesByTrainer(trainerId);
    }

    public Set<TrainerNote> getTrainerNotesByWeek(Integer weekId) {
        return trainerNoteDAO.getTrainerNotesByWeek(weekId);
    }

    public void updateTrainerNote(TrainerNote note) {
        trainerNoteDAO.updateTrainerNote(note);
    }

    public void deleteTrainerNote(TrainerNote note) {
        trainerNoteDAO.deleteTrainerNote(note);
    }

    //QCNote
    @Override
    public void createQCNote(QCNote note) {
        qcNoteDAO.createQCNote(note);
    }

    @Override
    public QCNote getQCNoteById(Integer qcNoteId) { return qcNoteDAO.getQCNoteById(qcNoteId); }

    @Override
    public QCNote getQCNoteForTraineeWeek(Integer traineeId, Integer weekId) {
        return qcNoteDAO.getQCNoteForTraineeWeek(traineeId, weekId);
    }

    @Override
    public List<QCNote> getQCNotesByTrainee(Integer traineeId) {
        return qcNoteDAO.getQCNotesByTrainee(traineeId);
    }

    @Override
    public List<QCNote> getQCNotesByWeek(Integer weekId) {
        return qcNoteDAO.getQCNotesByWeek(weekId);
    }

    @Override
    public void updateQCNote(QCNote note) {
        qcNoteDAO.updateQCNote(note);
    }

    @Override
    public void deleteQCNote(QCNote note) {
        qcNoteDAO.deleteQCNote(note);
    }
    //end QCNote

    //Note Facade Methods
    @Override
    public Note getNote(String note) {
        return noteDAO.getNote(note);
    }

    @Override
    public List<Note> getAllNotes() {
        return noteDAO.getAllNotes();
    }


    
    //QCStatus
	@Override
	public Set<QCStatus> getAllStatus() {
		return qcStatusDAO.getAllStatus();
	}

	@Override
	public Set<Assessment> getAssessmentByStatus(String status) {
		return qcStatusDAO.getAssessmentByStatus(status);
	}


}
