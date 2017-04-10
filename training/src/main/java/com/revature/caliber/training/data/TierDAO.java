package com.revature.caliber.training.data;

import java.util.List;

import com.revature.caliber.training.beans.Tier;
import com.revature.caliber.training.beans.Trainer;

public interface TierDAO {

	void createTier(Tier tier);

	Tier getTier(short num);

	Tier getTier(String name);

	List<Tier> getAllTiers();

	void updateTier(Tier tier);

	void deleteTier(Tier tier);

	//
	List<Trainer> getTrainersInTier(short tier);
}
