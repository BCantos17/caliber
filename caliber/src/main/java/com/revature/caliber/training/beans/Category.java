package com.revature.caliber.training.beans;

import java.util.Set;

/**
 * The type Category.
 */
public class Category {

    private int categoryId;

    private String skillCategory;

    // Bi-directional mapping -- to avoid recursion, make DTO to send to UI
    private Set<Week> weeks;

    /**
     * Instantiates a new Category.
     */
    public Category() {
        super();
    }

    /**
     * Instantiates a new Category.
     *
     * @param skillCategory the skill category
     */
    public Category(String skillCategory) {
        super();
        this.skillCategory = skillCategory;
    }

    /**
     * Instantiates a new Category.
     *
     * @param categoryId    the category id
     * @param skillCategory the skill category
     */
    public Category(int categoryId, String skillCategory) {
        super();
        this.categoryId = categoryId;
        this.skillCategory = skillCategory;
    }

    /**
     * Instantiates a new Category.
     *
     * @param categoryId    the category id
     * @param skillCategory the skill category
     * @param weeks         the weeks
     */
    public Category(int categoryId, String skillCategory, Set<Week> weeks) {
        super();
        this.categoryId = categoryId;
        this.skillCategory = skillCategory;
        this.weeks = weeks;
    }

    /**
     * Gets category id.
     *
     * @return the category id
     */
    public int getCategoryId() {
        return categoryId;
    }

    /**
     * Sets category id.
     *
     * @param categoryId the category id
     */
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * Gets skill category.
     *
     * @return the skill category
     */
    public String getSkillCategory() {
        return skillCategory;
    }

    /**
     * Sets skill category.
     *
     * @param skillCategory the skill category
     */
    public void setSkillCategory(String skillCategory) {
        this.skillCategory = skillCategory;
    }

    /**
     * Gets weeks.
     *
     * @return the weeks
     */
    public Set<Week> getWeeks() {
        return weeks;
    }

    /**
     * Sets weeks.
     *
     * @param weeks the weeks
     */
    public void setWeeks(Set<Week> weeks) {
        this.weeks = weeks;
    }

    @Override
    public String toString() {
        return "Category [categoryId=" + categoryId + ", skillCategory=" + skillCategory + ", weeks=" + weeks + "]";
    }

}
