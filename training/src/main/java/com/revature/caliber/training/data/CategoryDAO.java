package com.revature.caliber.training.data;

import java.util.List;

import com.revature.caliber.training.beans.Category;

/**
 * 
 * Category DAO interface for data tier
 *
 */
public interface CategoryDAO {

	/**
	 * 
	 * Returns an individual category
	 * 
	 */
	public Category getCategory(int categoryId);

	/**
	 * 
	 * Returns a list of all categories
	 * 
	 */
	public List<Category> getAllCategories();

}
