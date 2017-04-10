package com.revature.caliber.assessments.service;

import java.util.Set;

import com.revature.caliber.assessments.beans.Assessment;
import com.revature.caliber.assessments.beans.QCStatus;

public interface QCStatusService {
	
    public Set<QCStatus> getAllStatus();
	public Set<Assessment> getAssessmentByStatus(String status);
}
