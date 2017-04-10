package com.revature.caliber.training.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.caliber.training.beans.Week;
import com.revature.caliber.training.data.Facade;
import com.revature.caliber.training.service.WeekService;

@Component
public class WeekServiceImplementation implements WeekService {

	Facade facade;

	@Autowired
	public void setFacade(Facade facade) {
		this.facade = facade;
	}
	
	public List<Week> getAllWeeks() { return facade.getAllWeeks(); }
	public List<Week> getWeekByBatchId(int batchId) { return facade.getWeekByBatchId(batchId); }
	public List<Week> getWeekByWeekNumber(int weekNumber) { return facade.getWeekByWeekNumber(weekNumber); }
	public Long createWeek(Week newWeek) { return facade.createWeek(newWeek); }

}
