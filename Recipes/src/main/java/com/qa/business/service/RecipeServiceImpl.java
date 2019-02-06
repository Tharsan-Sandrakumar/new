package com.qa.business.service;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.persistence.repository.RecipeRepository;

public class RecipeServiceImpl implements RecipeService {

	@Inject
	private RecipeRepository repo;

	public String getAllRecipes() {
		return repo.getAllRecipes();
	}

	@Override
	public String addRecipe(String Recipe) {
		if(Recipe.contains("Bacon")) {
			
			return "This recipe can't be added";
		}
		return repo.createRecipe(Recipe);
	}

	@Override
	public String deleteRecipe(Long id) {
		return repo.deleteRecipe(id);
	}

	public void setRepo(RecipeRepository repo) {
		this.repo = repo;
	}

	@Override
	public int cycleRecipes(String recipe_name) {

		return repo.cycleRecipes(recipe_name);

	}

	@Override
	public String getARecipe(Long id) {
		return repo.getARecipe(id);
		
	}

	@Override
	public String updateRecipe(String recipe_name, Long id) {
		return repo.updateRecipe(recipe_name, id);
	}


}
