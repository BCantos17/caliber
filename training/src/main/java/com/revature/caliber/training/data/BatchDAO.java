package com.revature.caliber.training.data;

import java.util.List;
import java.util.Set;

import com.revature.caliber.training.beans.Batch;

/**
 * Batch Dao interface for data tier.
 */
public interface BatchDAO {

	/**
	 * Create a new batch
	 * 
	 * @param batch
	 */
	public long createBatch(Batch batch);

	/**
	 * Get all batches in a table
	 * 
	 * @return
	 */
	public Set<Batch> getAllBatch();

	/**
	 * Get all batches associated to a trainer
	 * 
	 * @param id
	 * @return
	 */
	public Set<Batch> getTrainerBatch(Integer id);

	/**
	 * Get in active batches
	 * 
	 * @return
	 */
	public List<Batch> getCurrentBatch();

	/**
	 * Get all active batches associated to a trainer
	 * 
	 * @param id
	 * @return
	 */
	public List<Batch> getCurrentBatch(Integer id);

	/**
	 * Get a batch with an id
	 * 
	 * @param id
	 * @return
	 */
	public Batch getBatch(Integer id);

	/**
	 * Update a batch
	 * 
	 * @param batch
	 */
	public void updateBatch(Batch batch);

	/**
	 * Delete a batch
	 * 
	 * @param batch
	 */
	public void deleteBatch(Batch batch);
}
