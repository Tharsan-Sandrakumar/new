package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.qa.business.service.RecipeService;
import com.qa.persistence.domain.Recipe;
import com.qa.util.JSONUtil;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Transactional(SUPPORTS)
@Default
public class RecipeDBRepository implements RecipeRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	@Override
	public int cycleRecipes(String recipe_name) {

		Query query = manager.createQuery("Select a FROM Recipe a");
		Collection<Recipe> recipes = (Collection<Recipe>) query.getResultList();

		List<Recipe> validList = recipes.stream().filter(n -> n.getRecipe_name().equals(recipe_name)).collect(Collectors.toList());

		return validList.size();
	}

	@Override
	public String getAllRecipes() {
		Query query = manager.createQuery("Select a FROM Recipe a");
		Collection<Recipe> Recipes = (Collection<Recipe>) query.getResultList();

		return util.getJSONForObject(Recipes);
	}

	@Override
	@Transactional(REQUIRED)
	public String createRecipe(String Recipe) {
		Recipe aRecipe = util.getObjectForJSON(Recipe, Recipe.class);
		manager.persist(aRecipe);
		return "{\"message\": \"Recipe has been sucessfully added\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteRecipe(Long id) {
		Recipe RecipeInDB = util.getObjectForJSON(getARecipe(id), Recipe.class);

		if (manager.contains(manager.find(Recipe.class, id))) {

			manager.remove(manager.find(Recipe.class, id));
		}
		return "{\"message\": \"Recipe sucessfully deleted\"}";
	}

	@Override
	public String getARecipe(Long id) {
		return util.getJSONForObject(manager.find(Recipe.class, id));
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

	@Override
	public String updateRecipe(String Recipe, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
