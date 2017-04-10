package com.revature.caliber.assessments.service.implementations;

import com.revature.caliber.assessments.beans.Assessment;
import com.revature.caliber.assessments.data.Facade;
import com.revature.caliber.assessments.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * The type Assessment service.
 */
@Service(value = "assessmentService")
public class AssessmentServiceImpl implements AssessmentService {

    private Facade facade;

    /**
     * Sets facade.
     *
     * @param facade the facade
     */
//    Spring setter based DI
    @Autowired
    public void setFacade(Facade facade) {
        this.facade = facade;
    }

    @Override
    @Transactional(
            isolation = Isolation.READ_COMMITTED,
            rollbackFor = Exception.class,
            propagation = Propagation.REQUIRES_NEW)
    public Set<Assessment> getAll() {
        return facade.getAllAssessments();
    }

    @Override
    @Transactional(
            isolation = Isolation.READ_COMMITTED,
            rollbackFor = Exception.class,
            propagation = Propagation.REQUIRES_NEW)
    public Assessment getById(long id) {
        return facade.getAssessmentById(id);
    }

    @Override
    @Transactional(
            isolation = Isolation.READ_COMMITTED,
            rollbackFor = Exception.class,
            propagation = Propagation.REQUIRES_NEW)
    public Set<Assessment> getByWeekId(long id) {
        return facade.getAssessmentsByWeekId(id);
    }

    @Override
    @Transactional(
            isolation = Isolation.READ_COMMITTED,
            rollbackFor = Exception.class,
            propagation = Propagation.REQUIRES_NEW)
    public long insert(Assessment assessment) {
        return facade.insertAssessment(assessment);
    }

    @Override
    @Transactional(
            isolation = Isolation.READ_COMMITTED,
            rollbackFor = Exception.class,
            propagation = Propagation.REQUIRES_NEW)
    public void update(Assessment assessment) {
        facade.updateAssessment(assessment);
    }

    @Override
    @Transactional(
            isolation = Isolation.READ_COMMITTED,
            rollbackFor = Exception.class,
            propagation = Propagation.REQUIRES_NEW)
    public void delete(Assessment assessment) {
        facade.deleteAssessment(assessment);
    }
}
