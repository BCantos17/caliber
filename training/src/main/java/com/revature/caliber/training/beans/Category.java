package com.revature.caliber.training.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CALIBER_CATEGORY")
public class Category {

	@Id
	@Column(name = "CATEGORY_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORY_ID_SEQUENCE")
	@SequenceGenerator(name = "CATEGORY_ID_SEQUENCE", sequenceName = "CATEGORY_ID_SEQUENCE")
	private int categoryId;

	@Column(name = "SKILL_CATEGORY")
	private String skillCategory;

	// Bi-directional mapping -- to avoid recursion, make DTO to send to UI
	@ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	@JoinTable(name = "CATEGORY_COVERED")
	private Set<Week> weeks;

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

	public Category(int categoryId, String skillCategory, Set<Week> weeks) {
		super();
		this.categoryId = categoryId;
		this.skillCategory = skillCategory;
		this.weeks = weeks;
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

	public Set<Week> getWeeks() {
		return weeks;
	}

	public void setWeeks(Set<Week> weeks) {
		this.weeks = weeks;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", skillCategory=" + skillCategory + ", weeks=" + weeks + "]";
	}

}