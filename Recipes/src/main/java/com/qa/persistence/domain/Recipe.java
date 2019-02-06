package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Recipe {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	private String recipe_name;
	private String recipe_owner;
	private String description;

	public Recipe() {

	}

	public Recipe(String recipe_name, String recipe_owner, String description) {
		this.recipe_name = recipe_name;
		this.recipe_owner = recipe_owner;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRecipe_name() {
		return recipe_name;
	}

	public void setRecipe_name(String recipe_name) {
		this.recipe_name = recipe_name;
	}

	public String getRecipe_owner() {
		return recipe_owner;
	}

	public void setRecipe_owner(String recipe_owner) {
		this.recipe_owner = recipe_owner;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	


}
