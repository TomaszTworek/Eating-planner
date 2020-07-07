package pl.two.EatingPlanner.services;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import pl.two.EatingPlanner.models.Ingredient;
import pl.two.EatingPlanner.repository.IngredientRepository;

import static org.mockito.Mockito.*;

public class IngredientServiceTest {

    @Mock
    private IngredientRepository ingredientRepository;

    @InjectMocks
    private IngredientService ingredientService;

    @Test
    public void savedIngredientShouldHaveNameBroccoli() {
        Ingredient ingredient = Ingredient.builder().name("Broccoli").build();
        when(ingredientRepository.save(any(Ingredient.class))).thenReturn(ingredient);

        Ingredient savedIngredient = ingredientService.save(ingredient);

        Assertions.assertThat(savedIngredient.getName()).isEqualTo("Broccoli");
    }




}
