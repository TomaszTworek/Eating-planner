package pl.two.EatingPlanner.services;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import pl.two.EatingPlanner.models.Dish;
import pl.two.EatingPlanner.repository.DishRepository;
import pl.two.EatingPlanner.repository.IngredientRepository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class DishServiceTest {
    @Mock
    private IngredientRepository ingredientRepository;

    @Mock
    private DishRepository dishRepository;

    @InjectMocks
    private DishService dishService;

    @Test
    public void save() {
        Dish dish = Dish.builder().name("DishServiceTestingADD").calories(3000D).build();
        when(dishRepository.save(any(Dish.class))).thenReturn(dish);

        Dish savedDish = dishService.save(dish);

        Assertions.assertThat(savedDish.getName()).isEqualTo("DishServiceTestingADD");
    }
}
