package com.revature.caliber.assessments.service.implementations;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.caliber.assessments.beans.Assessment;
import com.revature.caliber.assessments.beans.QCStatus;
import com.revature.caliber.assessments.data.Facade;
import com.revature.caliber.assessments.service.QCStatusService;

@Service(value = "qcStatusService")
public class QCStatusServiceImpl implements QCStatusService {

	private Facade facade;
	@Autowired
	public void setFacade(Facade facade) { this.facade = facade; }

	@Override
	public Set<QCStatus> getAllStatus() { return facade.getAllStatus(); }

	@Override
	public Set<Assessment> getAssessmentByStatus(String status) {
		return facade.getAssessmentByStatus(status);
	}
}
