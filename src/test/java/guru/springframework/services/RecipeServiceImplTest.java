package guru.springframework.services;

import guru.springframework.models.Recipe;
import guru.springframework.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {

    private RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void getRecipes() {

        // Creating a set of data
        Recipe recipe = new Recipe();
        HashSet<Recipe> recipesData = new HashSet<Recipe>();
        recipesData.add(recipe);

        // return our set of data when call the repository
        when(recipeRepository.findAll()).thenReturn(recipesData);

        Set<Recipe> recipes = recipeService.getRecipes();

        // verifying than the we return only one recipe
        assertEquals(recipes.size(), 1);

        // verifying than repository is call only one time
        verify(recipeRepository, times(1)).findAll();
    }
}