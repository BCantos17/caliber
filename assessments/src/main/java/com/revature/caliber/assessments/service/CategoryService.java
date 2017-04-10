package com.revature.caliber.assessments.service;

import com.revature.caliber.assessments.beans.Category;

import java.util.Set;

public interface CategoryService {

    /**
     * Returns Set of all Categories
     *
     * @return Set of all Categories
     */
    Set<Category> getAll();

    /**
     * Returns Category
     * with provided ID
     *
     * @param id
     * @return Category
     */
    Category getById(int id);

}
