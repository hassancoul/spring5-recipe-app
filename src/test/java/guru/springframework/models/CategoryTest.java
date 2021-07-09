package guru.springframework.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryTest {

    private Category category;

    @Before
    public void setUp() {
        category = new Category();
    }

    @Test
    public void getId() {
        Long idValue = 4L;

        category.setId(idValue);

        assertEquals(idValue, category.getId());
    }

    @Test
    public void getDescription() {
        String descriptionValue = "lorem ipsum sit amet";

        category.setDescription(descriptionValue);

        assertEquals(descriptionValue, category.getDescription());
    }

    @Test
    public void getRecipes() {
    }
}