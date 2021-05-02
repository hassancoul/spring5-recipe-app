package guru.springframework.bootstrap;

import guru.springframework.models.*;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMesureRepository;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private CategoryRepository categoryRepository;
    private UnitOfMesureRepository unitOfMesureRepository;
    private RecipeRepository recipeRepository;

    public DataLoader(CategoryRepository categoryRepository, UnitOfMesureRepository unitOfMesureRepository, RecipeRepository recipeRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMesureRepository = unitOfMesureRepository;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recipeRepository.saveAll(getRecipes());
    }

    private Set<Recipe> getRecipes() {
        Set<Recipe> recipes = new HashSet<>();

        Optional<Category> americainOptional = categoryRepository.findByDescription("Americain");
        Optional<Category> italianOptional = categoryRepository.findByDescription("Italian");
        Optional<Category> mexicainOptional = categoryRepository.findByDescription("Mexicain");
        Optional<Category> fastFoodOptional = categoryRepository.findByDescription("Fast Food");

        Optional<UnitOfMesure> teaspoonOptional = unitOfMesureRepository.findByUnit("Teaspoon");
        Optional<UnitOfMesure> tablespoonOptional = unitOfMesureRepository.findByUnit("Tablespoon");
        Optional<UnitOfMesure> cupOptional = unitOfMesureRepository.findByUnit("Cup");
        Optional<UnitOfMesure> pinchOptional = unitOfMesureRepository.findByUnit("Pinch");
        Optional<UnitOfMesure> ounceOptional = unitOfMesureRepository.findByUnit("Ounce");
        Optional<UnitOfMesure> ripeOptional = unitOfMesureRepository.findByUnit("Ripe");
        Optional<UnitOfMesure> dashOptional = unitOfMesureRepository.findByUnit("Dash");

        if (!americainOptional.isPresent()) {
            throw new RuntimeException("Category not found");
        }
        if (!italianOptional.isPresent()) {
            throw new RuntimeException("Category not found");
        }
        if (!mexicainOptional.isPresent()) {
            throw new RuntimeException("Category not found");
        }
        if (!fastFoodOptional.isPresent()) {
            throw new RuntimeException("Category not found");
        }


        if (!teaspoonOptional.isPresent()) {
            throw new RuntimeException("Unit Of Mesure not found");
        }
        if (!tablespoonOptional.isPresent()) {
            throw new RuntimeException("Unit Of Mesure not found");
        }
        if (!cupOptional.isPresent()) {
            throw new RuntimeException("Unit Of Mesure not found");
        }
        if (!pinchOptional.isPresent()) {
            throw new RuntimeException("Unit Of Mesure not found");
        }
        if (!ounceOptional.isPresent()) {
            throw new RuntimeException("Unit Of Mesure not found");
        }
        if (!ripeOptional.isPresent()) {
            throw new RuntimeException("Unit Of Mesure not found");
        }
        if (!dashOptional.isPresent()) {
            throw new RuntimeException("Unit Of Mesure not found");
        }

        Recipe recipeGuacamole = new Recipe();
        recipeGuacamole.setCooktime(0);
        recipeGuacamole.setPrepTime(10);
        recipeGuacamole.setServings(4);
        Notes notesGuacamol = new Notes("Be careful handling chiles if using. " +
                "Wash your hands thoroughly after handling and do not touch your eyes or the area near your eyes " +
                "with your hands for several hours.");
        recipeGuacamole.setNotes(notesGuacamol);
        recipeGuacamole.setDifficulty(Difficulty.EASY);
        recipeGuacamole.getCategories().add(americainOptional.get());
        recipeGuacamole.getCategories().add(mexicainOptional.get());
        recipeGuacamole.addIngredient(new Ingredient("avocados", new BigDecimal(2), ripeOptional.get()));
        recipeGuacamole.addIngredient(new Ingredient("salt",  new BigDecimal(0.4), teaspoonOptional.get()));
        recipeGuacamole.addIngredient(new Ingredient("fresh lime juice or lemon juice", new BigDecimal(1), tablespoonOptional.get()));
        recipeGuacamole.addIngredient(new Ingredient("serrano chiles, stems and seeds removed, minced", new BigDecimal(2), null));
        recipeGuacamole.addIngredient(new Ingredient("cilantro (leaves and tender stems), finely chopped", new BigDecimal(2), tablespoonOptional.get()));
        recipeGuacamole.addIngredient(new Ingredient("freshly grated black pepper", new BigDecimal(1), dashOptional.get()));
        recipeGuacamole.addIngredient(new Ingredient("tomato, seeds and pulp removed, chopped", new BigDecimal(0.5), ripeOptional.get()));
        recipeGuacamole.addIngredient(new Ingredient("Red radishes or jicama, to garnish", new BigDecimal(1), null));
        recipeGuacamole.addIngredient(new Ingredient("Tortilla chips, to serve", new BigDecimal(1), null));

        recipeGuacamole.setDescription("The perfect guacamole");

        recipeGuacamole.setDirections("Step 1 - Cut the avocado, remove flesh: \n" +
                "Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and " +
                "scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl. \n\n" +
                "Step 2 - Mash with a fork: \n" +
                "Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.) \n\n" +
                "Step 3 - Add salt, lime juice, and the rest: \n" +
                "Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance " +
                "to the richness of the avocado and will help delay the avocados from turning brown. \n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually " +
                "in their hotness. So, start with a half of one chili pepper and add to the guacamole to " +
                "your desired degree of hotness. \n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. " +
                "Start with this recipe and adjust to your taste. \n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, " +
                "add it just before serving. \n\n" +
                "Step 4 - Serve: \n" +
                "Serve immediately, or if making a few hours ahead, place plastic wrap on the surface of " +
                "the guacamole and press down to cover it and to prevent air reaching it. " +
                "(The oxygen in the air causes oxidation which will turn the guacamole brown.) " +
                "Refrigerate until ready to serve.");

        recipes.add(recipeGuacamole);

        return recipes;

    }
}
