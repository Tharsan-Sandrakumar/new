package com.qa.service.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.domain.Recipe;
import com.qa.persistence.repository.RecipeDBRepository;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class RecipeDBRepositoryTest {

	@InjectMocks
	private RecipeDBRepository repo;

	@Mock
	private EntityManager manager;

	@Mock
	private Query query;

	private JSONUtil util;
	

	private static final String MOCK_DATA_ARRAY = "[{\"recipe_name\":\"Alien\",\"recipe_owner\":\"15\",\"description\":\"dogs\"}]";

	private static final String MOCK_OBJECT = "{\"recipe_name\":\"Alien\",\"recipe_owner\":\"15\",\"description\":\"dogs\"}";

	@Before
	public void setup() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
	}

	@Test
	public void testGetAllRecipes() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Recipe> Recipes = new ArrayList<Recipe>();
		Recipes.add(new Recipe("Alien", "15","dogs"));
		Mockito.when(query.getResultList()).thenReturn(Recipes);
		System.out.println(repo.getAllRecipes());
		Assert.assertEquals(MOCK_DATA_ARRAY, repo.getAllRecipes());
	}

	@Test
	public void testCycleRecipes() {

		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Recipe> Recipes = new ArrayList<Recipe>();
		Recipes.add(new Recipe("Alien", "15","dogs"));
		Mockito.when(query.getResultList()).thenReturn(Recipes);
		Assert.assertEquals(1, repo.cycleRecipes("Alien"));

	}

	@Test
	public void testCreateRecipe() {
		String reply = repo.createRecipe(MOCK_OBJECT);
		Assert.assertEquals(reply, "{\"message\": \"Recipe has been sucessfully added\"}");
	}

	@Test
	public void testDeleteRecipe() {
		String reply = repo.deleteRecipe(1L);
		Assert.assertEquals(reply, "{\"message\": \"Recipe sucessfully deleted\"}");
	}

}
