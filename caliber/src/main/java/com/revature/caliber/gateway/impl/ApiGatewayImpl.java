package com.revature.caliber.gateway.impl;

import com.revature.caliber.assessment.beans.*;
import com.revature.caliber.assessment.beans.Assessment;
import com.revature.caliber.beans.*;
import com.revature.caliber.beans.BatchNote;
import com.revature.caliber.beans.Note;
import com.revature.caliber.beans.QCNote;
import com.revature.caliber.beans.TrainerNote;
import com.revature.caliber.gateway.ApiGateway;
import com.revature.caliber.gateway.services.ServiceLocator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * The type Api gateway.
 */
@Component
public class ApiGatewayImpl implements ApiGateway {


    private ServiceLocator serviceLocator;

    /**
     * Sets service locator.
     *
     * @param serviceLocator the service locator
     */
    @Autowired
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    /****************************Batch*******************************/
    public Long createBatch(Batch batch) {return serviceLocator.getTrainingService().createBatch(batch);}

    public Set<Batch> allBatch() {
        return serviceLocator.getTrainingService().allBatch();
    }

    public Set<Batch> getBatches(Integer id) {
        return serviceLocator.getTrainingService().getBatches(id);
    }

    public List<Batch> getCurrentBatches() {
        return serviceLocator.getTrainingService().currentBatches();
    }

    public List<Batch> currentBatch(Integer id) {
        return serviceLocator.getTrainingService().currentBatches(id);
    }

    public Batch getBatch(Integer id) {
        return serviceLocator.getTrainingService().getBatch(id);
    }

    public void updateBatch(Batch batch) {
        serviceLocator.getTrainingService().updateBatch(batch);
    }

    public void deleteBatch(Batch batch) {
        serviceLocator.getTrainingService().deleteBatch(batch);
    }

    /****************************Trainee*******************************/
    @Override
    public long createTrainee(com.revature.caliber.training.beans.Trainee trainee) {
        return serviceLocator.getTrainingService().createTrainee(trainee);
    }
    @Override
    public long createTrainees(com.revature.caliber.training.beans.Trainee[] trainees) {
        return serviceLocator.getTrainingService().createTrainees(trainees);
    }

    @Override
    public void updateTrainee(Trainee trainee) {
        serviceLocator.getTrainingService().updateTrainee(trainee);
    }

    @Override
    public Trainee getTrainee(Integer id) {
        return serviceLocator.getTrainingService().getTrainee(id);
    }

    @Override
    public Trainee getTrainee(String email) {
        return serviceLocator.getTrainingService().getTrainee(email);
    }

    @Override
    public List<Trainee> getTraineesInBatch(Integer batchId) {
        return serviceLocator.getTrainingService().getTraineesInBatch(batchId);
    }

    @Override
    public void deleteTrainee(Trainee trainee) {
        serviceLocator.getTrainingService().deleteTrainee(trainee);
    }

    /****************************Trainer*******************************/
    @Override
    public void createTrainer(Trainer trainer) {
        serviceLocator.getTrainingService().createTrainer(trainer);
    }

    @Override
    public Trainer getTrainer(Integer id) {
        return serviceLocator.getTrainingService().getTrainer(id);
    }

    @Override
    public Trainer getTrainer(String email) {
        return serviceLocator.getTrainingService().getTrainer(email);
    }

    @Override
    public List<Trainer> getAllTrainers() {
        return serviceLocator.getTrainingService().getAllTrainers();
    }

    @Override
    public void updateTrainer(Trainer trainer) {
        serviceLocator.getTrainingService().updateTrainer(trainer);
    }


    /**************************************Grade************************************/
    @Override
    public List<com.revature.caliber.assessment.beans.Grade> getGradesByAssessment(Integer assessmentId) {
        return serviceLocator.getAssessmentService().getGradesByAssessment(assessmentId);
    }

    @Override
    public Long insertGrade(com.revature.caliber.assessment.beans.Grade grade) {return serviceLocator.getAssessmentService().insertGrade(grade);
    }

    /***********************************Trainer Notes**********************************/
    @Override
    public void createTrainerNote(TrainerNote note) {
        serviceLocator.getAssessmentService().createTrainerNote(note);

    }

    @Override
    public void updateTrainerNote(TrainerNote note) {
        serviceLocator.getAssessmentService().updateTrainerNote(note);
    }

    @Override
    public void deleteTrainerNote(TrainerNote note) {
        serviceLocator.getAssessmentService().deleteTrainerNote(note);

    }

    /****************************Batch Notes**********************************/
    @Override
    public void createBatchNote(BatchNote batchNote) {
        serviceLocator.getAssessmentService().createBatchNote(batchNote);

    }

    @Override
    public void updateBatchNote(BatchNote batchNote) {
        serviceLocator.getAssessmentService().updateBatchNote(batchNote);

    }

    @Override
    public void deleteBatchNote(BatchNote batchNote) {
        serviceLocator.getAssessmentService().deleteBatchNote(batchNote);

    }

    /****************************Assessment**********************************/
    @Override
    public long createAssessment(com.revature.caliber.assessment.beans.Assessment assessment) {
        return serviceLocator.getAssessmentService().createAssessment(assessment);
    }

    @Override
    public void updateAssessment(com.revature.caliber.assessment.beans.Assessment assessment) {
        serviceLocator.getAssessmentService().updateAssessment(assessment);
    }

    @Override
    public void deleteAssessment(com.revature.caliber.assessment.beans.Assessment assessment) {
        serviceLocator.getAssessmentService().deleteAssessment(assessment);
    }

    /****************************QCNote**********************************/
    @Override
    public void createQCNote(QCNote note) {
        serviceLocator.getAssessmentService().createQCNote(note);
    }

    @Override
    public void updateQCNote(QCNote note) {
        serviceLocator.getAssessmentService().updateQCNote(note);

    }


    /**
     * Gets batch from current batches by id.
     *
     * @param id the id
     * @return the batch from current batches by id
     */
    public Batch getBatchFromCurrentBatchesById(int id) {
        Batch batch = new Batch();
        batch.setBatchId(id);
        return batch;
    }

    /**
     * Gets current batch.
     *
     * @return the current batch
     */
    public Batch getCurrentBatch() {
        return null;
    }

    /**
     * Gets all batches.
     *
     * @return the all batches
     */
    @Override
    public Set<Batch> getAllBatches() {
        return serviceLocator.getTrainingService().allBatch();
    }

    /**
     * Update batch from current batches by id batch.
     *
     * @param batch the batch
     * @return the batch
     */
    public Batch updateBatchFromCurrentBatchesById(Batch batch) {
        return batch;
    }

    /**
     * Insert batch into current batches batch.
     *
     * @param batch the batch
     * @return the batch
     */
    public Batch insertBatchIntoCurrentBatches(Batch batch) {
        return batch;
    }

    /**
     * Delete batch from current batches by id batch.
     *
     * @param id the id
     * @return the batch
     */
    public Batch deleteBatchFromCurrentBatchesById(int id) {
        return null;
    }

    /**
     * Update all current batches set.
     *
     * @param batches the batches
     * @return the set
     */
    public Set<Batch> updateAllCurrentBatches(Set<Batch> batches) {
        return batches;
    }


    /**
     * Gets batch by trainer id.
     *
     * @param id the id
     * @return the batch by trainer id
     */
    public Batch getBatchByTrainerId(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Gets all current batches.
     *
     * @return the all current batches
     */
    public Set<Batch> getAllCurrentBatches() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Gets batch from current batches by id.
     *
     * @return the batch from current batches by id
     */
    public Batch getBatchFromCurrentBatchesById() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Gets batch from all batches by id.
     *
     * @return the batch from all batches by id
     */
    public Batch getBatchFromAllBatchesById() {
        // TODO Auto-generated method stub
        return null;
    }


    /**
<<<<<<< HEAD
     * Trainee
     Aggregate grades by all tech for a Trainee // param - traineeId
     - HashMap
     - key Tech(Category)
     - value double array
     - average
     - median
     - high
     - low
     Key: REST, Value: [83.54, 78.56, 90.56, 78.56]
     Key: SOAP, Value: [83.54, 78.56, 90.56, 78.56]
     * @param id
     * @return Hashmap as explained above
     *
     * @author Shehar
=======
     * Aggregate grades by all tech for a Trainee // param - traineeId
     * - HashMap
     * - key Tech(Category)
     * - value double array
     * - average
     * - median
     * - high
     * - low
     * Key: REST, Value: [83.54, 78.56, 90.56, 78.56]
     * Key: SOAP, Value: [83.54, 78.56, 90.56, 78.56]
     *
     * @param id the id
     * @return something
>>>>>>> master
     */

    @Override
    public HashMap<String, Double[]> getTechGradeDataForTrainee(int id) {
        //grade data that we get from assessment module
        List<com.revature.caliber.assessment.beans.Grade> allGrades =
                serviceLocator.getAssessmentService().getGradesByTraineeId(id);

        HashMap<String,Double[]> grades = new HashMap<>(); //our result map
        HashMap<String, List<Integer>> gradeValues = new HashMap<>(); //get grade values
        //processing
        for ( com.revature.caliber.assessment.beans.Grade grade : allGrades) {
            List<com.revature.caliber.assessment.beans.Category> catList =
                    grade.getAssessment().getCategories().stream().collect(Collectors.toList());
            if (catList.size() < 1) { continue; }
            //assume there is only one category per assessment
            com.revature.caliber.assessment.beans.Category category = catList.get(0);
            //map does not have the key yet
            if (!grades.containsKey(category.getSkillCategory())) {
                grades.put(category.getSkillCategory(), new Double[]{0.0, 0.0, 0.0, 0.0});
                gradeValues.put(category.getSkillCategory(), new ArrayList<>());
            }
            //add grade to total number
            grades.get(category.getSkillCategory())[0] += grade.getScore();
            //add grade to list of grades for a tech
            gradeValues.get(category.getSkillCategory()).add(grade.getScore());
        }
        //actually processing the values
        for (String categoryName : grades.keySet()) {
            //convenience
            Double[] gradeV = grades.get(categoryName);
            List<Integer> list = gradeValues.get(categoryName);
            list.sort(Integer::compareTo); //sort list of grades for convenience

            //assume there is at least one grade
            if (list.size() < 1) {
                continue;
            }
//
            //average
            gradeV[0] = gradeV[0] / list.size(); //just divide the total by list size
            //medium
            if (list.size() > 1) {
                gradeV[1] = list.size() % 2 == 1 ? list.get(list.size() / 2).doubleValue() :
                        (list.get(list.size() / 2).doubleValue() + list.get(list.size() / 2 - 1).doubleValue()) / 2;
            } else {
                gradeV[1] = list.get(0).doubleValue();
            }
            //since the list of grades is sorted, we can get high and low just by one call for each
            //low
            gradeV[3] = list.get(0).doubleValue();
            //high
            gradeV[2] = list.get(list.size() - 1).doubleValue();

            grades.put(categoryName, gradeV); //put the result array back to the map
        }
        return grades;
    }

    /**
     *
     Aggregate grades per week for a Batch // param - batchId
     - HashMap
     - key week
     - value double array
     - average
     - median
     - high
     - low
     Key: Week 1, Value: [83.54, 78.56, 90.56, 78.56]
     Key: Week 2, Value: [83.54, 78.56, 90.56, 78.56]           etc.
     * @param batchID
     * @author Shehar
     */
    @Override
    public HashMap<String, Double[]> getGradesForBatchWeekly(int batchID) {
        //grade data that we get from assessment module
        List<com.revature.caliber.assessment.beans.Grade> allGrades =
                serviceLocator.getAssessmentService().getAllGrades();//get all grades
        HashMap<String,Double[]> grades = new HashMap<>(); //our result map
        HashMap<String, List<Integer>> gradeValues = new HashMap<>(); //get grade values
        Double[] gradeV;
        List<Integer> list;
        int highestWeek =0;

        for ( com.revature.caliber.assessment.beans.Grade grade : allGrades) {
            if(grade.getAssessment().getBatch()==batchID) {
                long weekNumber = grade.getAssessment().getWeek();
                if (!grades.containsKey(weekNumber)) {
                    grades.put(String.valueOf(weekNumber), new Double[]{0.0, 0.0, 0.0, 0.0});
                    gradeValues.put(String.valueOf(weekNumber), new ArrayList<>());
                }
            }
        }
        for ( com.revature.caliber.assessment.beans.Grade grade : allGrades) {
            if(grade.getAssessment().getBatch()==batchID) {
                long weekNumber = grade.getAssessment().getWeek();
                grades.get(String.valueOf(weekNumber))[0] += grade.getScore();
                gradeValues.get(String.valueOf(weekNumber)).add(grade.getScore());
            }
        }

        for (String weekName : grades.keySet()) {
            gradeV = grades.get(weekName);
            list = gradeValues.get(weekName);
            list.sort(Integer::compareTo); //sort list of grades for convenience
            //assume there is at least one grade

            if (list.size() < 1) {
                continue;
            }

            gradeV[0] = gradeV[0] / list.size();

            if (list.size() > 1) {

                gradeV[1] = list.size() % 2 == 1 ? list.get(list.size() / 2).doubleValue() :
                        (list.get(list.size() / 2).doubleValue() + list.get(list.size() / 2 - 1).doubleValue()) / 2;
            } else {
                gradeV[1] = list.get(0).doubleValue();
            }
            gradeV[3] = list.get(0).doubleValue();
            gradeV[2] = list.get(list.size() - 1).doubleValue();
            grades.put(weekName, gradeV); //put the result array back to the map
        }


        return grades;
    }


    /**
     * Create new week.
     *
     * @param week the week
     */
    public Long createNewWeek(Week week) {
        return serviceLocator.getTrainingService().createWeek(week);
    }

    /**
     * Gets assessment grades by id.
     *
     * @param id the id
     * @return the assessment grades by id
     */
    public List<com.revature.caliber.assessment.beans.Grade> getAssessmentGradesById(int id) { return serviceLocator.getAssessmentService().getGradesByAssessment(id); }

    @Override
    public void createAssessmentNote(Note note) {

    }

    public void updateGrade(com.revature.caliber.assessment.beans.Grade grade) { serviceLocator.getAssessmentService().updateGrade(grade);}


    @Override
    public HashMap<String, Double[]> getWeekGradeDataForTrainee(int id) {
        List<Week> weeks = serviceLocator.getTrainingService().getAllWeek();
        List<com.revature.caliber.assessment.beans.Grade> allGrades =
                serviceLocator.getAssessmentService().getGradesByTraineeId(id);
        HashMap<String, Double[]> grades = new HashMap<>();

        for (Week week : weeks) {
            List<Integer> scores = new ArrayList<>();
            //get the grades for that week
            for (com.revature.caliber.assessment.beans.Grade grade : allGrades) {
                if (week.getWeekId() == grade.getAssessment().getWeek()) {
                        scores.add(grade.getScore());
                    }
                }
            if (scores.size() < 1) { continue; }
            Collections.sort(scores);
            Double[] aggregates = new Double[4];
            aggregates[0] = getAverage(scores);
            aggregates[1] = getMedian(scores);
            aggregates[3] = (double) scores.get(0);
            aggregates[2] = (double) scores.get(scores.size() - 1);
            if (scores.size() > 0) {
                grades.put(Integer.toString(week.getWeekNumber()), aggregates);
            }
        }
        return grades;
    }

    @Override
    public HashMap<String, Double[]> getTechGradeDataForBatch(int batchId) {
    	List<com.revature.caliber.assessment.beans.Grade> allGrades = 
    			serviceLocator.getAssessmentService().getAllGrades();
    	HashMap<String,Double[]> grades = new HashMap<>(); //our result map
        HashMap<String, List<Integer>> gradeValues = new HashMap<>(); //get grade values
        //processing
        for ( com.revature.caliber.assessment.beans.Grade grade : allGrades) {
        	if(batchId==grade.getAssessment().getBatch()){
            List<com.revature.caliber.assessment.beans.Category> catList =
                    grade.getAssessment().getCategories().stream().collect(Collectors.toList());
            if (catList.size() < 1) { continue; }
            //assume there is only one category per assessment
            com.revature.caliber.assessment.beans.Category category = catList.get(0);
            //map does not have the key yet
            if (!grades.containsKey(category.getSkillCategory())) {
                grades.put(category.getSkillCategory(), new Double[]{0.0, 0.0, 0.0, 0.0});
                gradeValues.put(category.getSkillCategory(), new ArrayList<>());
            }
            //add grade to total number
            grades.get(category.getSkillCategory())[0] += grade.getScore();
            //add grade to list of grades for a tech
            gradeValues.get(category.getSkillCategory()).add(grade.getScore());
        	}
        }
        //actually processing the values
        for (String categoryName : grades.keySet()) {
            //convenience
            Double[] gradeV = grades.get(categoryName);
            List<Integer> list = gradeValues.get(categoryName);
            list.sort(Integer::compareTo); //sort list of grades for convenience

            //assume there is at least one grade
            if (list.size() < 1) {
                continue;
            }
            //average
            gradeV[0] = gradeV[0] / list.size(); //just divide the total by list size
            //since the list of grades is sorted, we can get high and low just by one call for each
            gradeV[1] = getMedian(list);
            //high
            gradeV[2] = list.get(list.size() - 1).doubleValue();
            //low
            gradeV[3] = list.get(0).doubleValue();

            grades.put(categoryName, gradeV); //put the result array back to the map
        }
        return grades;

    	
    }

    @Override
    public Map<String, Double[]> getTraineeGradeDataForTrainer(int trainerId) {
        List<Trainee> trainees = serviceLocator.getTrainingService().getTraineesByTrainer(new Long(trainerId));
        List<com.revature.caliber.assessment.beans.Grade> allGrades =
                serviceLocator.getAssessmentService().getAllGrades();
        HashMap<String, Double[]> grades = new HashMap<>();
        for (Trainee trainee : trainees) {
            List<com.revature.caliber.assessment.beans.Grade> tgrades = new ArrayList<>();
            for (com.revature.caliber.assessment.beans.Grade gr : allGrades) {
                if (gr.getTrainee() == trainee.getTraineeId()) {
                    tgrades.add(gr);
                }
            }
            List<Integer> scores = new ArrayList<>();
            for (com.revature.caliber.assessment.beans.Grade grade : tgrades) {
                scores.add(grade.getScore());
            }

            //aggregate here
            if(scores.size()<1){
            	continue;
            }
            Collections.sort(scores);
            Double[] aggregates = new Double[2];
            aggregates[0] = getAverage(scores);
            aggregates[1] = getMedian(scores);
            grades.put(trainee.getName(), aggregates);

        }
        return grades;
    }
    @Override
    public HashMap<String,HashMap<String,Double[]>> getTechGradeAllBatch(){
        List<com.revature.caliber.assessment.beans.Grade> allGrades =
                serviceLocator.getAssessmentService().getAllGrades();
        HashMap<String,HashMap<String,Double[]>> grades = new HashMap<>(); //our result map
        HashMap<String, Double[]> techGrade = new HashMap<>();

        Set<Integer> batchIds = new TreeSet<>();

        for (com.revature.caliber.assessment.beans.Grade grade : allGrades) {
            batchIds.add(grade.getAssessment().getBatch());
        }
        for (Integer batchId : batchIds) {
            if(!grades.containsKey(batchId)){
                techGrade = getTechGradeDataForBatch(batchId);
                grades.put(String.valueOf(batchId),techGrade);
            }
        }
        return grades;
    }

    /**
     * Gets average.
     *
     * @param list the list
     * @return the average
     */
    public double getAverage(List<Integer> list) {
        int sum = 0;
        for (int nums : list) {
            sum += nums;
        }
        double avg = (double)sum / list.size();
        return avg;
    }

    /**
     * Gets median.
     *
     * @param list the list
     * @return the median
     */
    public double getMedian(List<Integer> list) {
        int middle = list.size() / 2;
        if (list.size() % 2 == 1) {
            return list.get(middle);
        } else {
            return (double)((list.get(middle - 1) + list.get(middle)) / 2);
        }

    }

    /**
     * Gets all assessments.
     *
     * @return the all assessments
     */
    public List<com.revature.caliber.assessment.beans.Assessment> getAllAssessments() {

        return serviceLocator.getAssessmentService().getAllAssessments();

    }

    @Override
    public List<Assessment> getAssessmentsByWeekId(long weekId) {
        return serviceLocator.getAssessmentService().getAssessmentsByWeekId(weekId);
    }

    /**
     * Update assessment note.
     *
     * @param note the note
     */
    public void updateAssessmentNote(Note note) {

    }
}
