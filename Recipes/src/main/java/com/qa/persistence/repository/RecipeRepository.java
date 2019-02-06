package com.qa.persistence.repository;

public interface RecipeRepository {

	//C
	String createRecipe(String Recipe);
	
	//R
	String getAllRecipes();
	
	String getARecipe(Long id);
	
	//U
	String updateRecipe(String Recipe, Long id);

	//D
	String deleteRecipe(Long id);
	
	int cycleRecipes(String recipe);

}