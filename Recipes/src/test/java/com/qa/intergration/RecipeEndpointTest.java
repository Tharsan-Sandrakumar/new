package com.qa.intergration;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.service.RecipeService;
import com.qa.rest.RecipeEndpoint;

@RunWith(MockitoJUnitRunner.class)
public class RecipeEndpointTest {

	private static final String MOCK_VALUE2 = "test_value_2";

	private static final String MOCK_VALUE = "test_value";

	@InjectMocks
	private RecipeEndpoint endpoint;

	@Mock
	private RecipeService service;

	@Before
	public void setup() {
		endpoint.setService(service);
	}

	@Test
	@Ignore
	public void testGetAllRecipes() {
		Mockito.when(service.getAllRecipes()).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.getAllRecipes());
	}

	@Test
	@Ignore
	public void testCreateRecipe() {
		Mockito.when(service.addRecipe(MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.addRecipe(MOCK_VALUE2));
		Mockito.verify(service).addRecipe(MOCK_VALUE2);
	}

	@Test
	@Ignore
	public void testDeleteRecipe() {
		Mockito.when(service.deleteRecipe(1L)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.deleteRecipe(1L));
		Mockito.verify(service).deleteRecipe(1L);
	}

}
