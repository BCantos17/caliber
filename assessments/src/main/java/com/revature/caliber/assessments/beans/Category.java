package com.revature.caliber.assessments.beans;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

import java.util.Set;

@Entity(name = "CALIBER_ASSESSMENT_CATEGORY")
public class Category {

    @Id
    @Column(name = "CATEGORY_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORY_ID_SEQUENCE")
    @SequenceGenerator(name = "CATEGORY_ID_SEQUENCE", sequenceName = "CATEGORY_ID_SEQUENCE")
    private int categoryId;

    @Column(name = "SKILL_CATEGORY")
    private String skillCategory;

    // Bi-directional mapping -- to avoid recursion, make DTO to send to UI
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "categories")
    @JsonBackReference(value = "Temporary")
    private Set<Assessment> assessments;

    @ElementCollection(targetClass = Integer.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "CALIBER_CATEGORY_WEEKS")
    @Column(name = "WEEK_ID")
    private Set<Integer> weeks;

    public Category() {
        super();
    }

    public Category(String skillCategory) {
        super();
        this.skillCategory = skillCategory;
    }

    public Category(int categoryId, String skillCategory) {
        super();
        this.categoryId = categoryId;
        this.skillCategory = skillCategory;
    }

    public Category(int categoryId, String skillCategory, Set<Assessment> assessments, Set<Integer> weeks) {
        super();
        this.categoryId = categoryId;
        this.skillCategory = skillCategory;
        this.assessments = assessments;
        this.weeks = weeks;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", skillCategory='" + skillCategory + '\'' +
                ", assessments=" + assessments.size() +
                ", weeks=" + weeks +
                '}';
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getSkillCategory() {
        return skillCategory;
    }

    public void setSkillCategory(String skillCategory) {
        this.skillCategory = skillCategory;
    }

    public Set<Assessment> getAssessments() {
        return assessments;
    }

    public void setAssessments(Set<Assessment> assessments) {
        this.assessments = assessments;
    }

    public Set<Integer> getWeeks() {
        return weeks;
    }

    public void setWeeks(Set<Integer> weeks) {
        this.weeks = weeks;
    }


}