package com.revature.caliber.assessments.data;

import com.revature.caliber.assessments.beans.Assessment;

import java.util.Set;

/**
 * This is the Data Access Object interface for the Assessment bean
 */
public interface AssessmentDAO {

//    Get
    /**
     * Returns a Set of all Assessments
     * @return a Set of Assessments
     */
    Set<Assessment> getAll();

    /**
     * Return Assessment with AssessmentId
     * @return an Assessment
     */
    Assessment getById(long id);

    /**
     * Returns HashSet of Assessments with WeekId
     * @param id the Week ID
     * @return a Set of Assessments
     */
    Set<Assessment> getByWeekId(long id);

//    Create

    /**
     * Inserts Assessment
     * @param assessment an Assessment to be inserted
     */
    long insert(Assessment assessment);

//    Update

    /**
     * Updates Assessment
     * @param assessment an Assessment to be updated
     */
    void update(Assessment assessment);


//    Delete
    /**
     * Deletes Assessment
     * @param assessment and Assessment to delete
     */
    void delete(Assessment assessment);
}
