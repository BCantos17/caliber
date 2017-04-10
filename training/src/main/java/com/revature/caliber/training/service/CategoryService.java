package com.revature.caliber.training.service;

import java.util.List;

import com.revature.caliber.training.beans.Category;

public interface CategoryService {

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
