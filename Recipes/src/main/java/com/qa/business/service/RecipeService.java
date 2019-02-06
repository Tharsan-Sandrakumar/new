package com.qa.business.service;

public interface RecipeService {

	//C
	String addRecipe(String Recipe);
	
	//R
	String getAllRecipes();
	
	String getARecipe(Long id);

	//U
	String updateRecipe(String Recipe, Long id);

	//D
	String deleteRecipe(Long id);
	
	int cycleRecipes(String recipe_name);

}