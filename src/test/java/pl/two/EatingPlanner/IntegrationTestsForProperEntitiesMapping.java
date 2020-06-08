package pl.two.EatingPlanner;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.two.EatingPlanner.model.Dish;
import pl.two.EatingPlanner.model.Ingredient;
import pl.two.EatingPlanner.repository.DishRepository;
import pl.two.EatingPlanner.repository.IngredientRepository;

import static org.assertj.core.api.Assertions.*;


@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class Testingredient {


    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private DishRepository dishRepository;



    @Test
    public void test() {

        Ingredient ingredient = new Ingredient();
        ingredient.setName("Def");
        Ingredient ingredientSaved = ingredientRepository.save(ingredient);

        Dish dish = new Dish();
        dish.setName("test");
        Dish dishSaved = dishRepository.save(dish);

        ingredientSaved.addDish(dishSaved);

        Ingredient foundedIngredient = ingredientRepository.save(ingredientSaved);

        assertThat(foundedIngredient.getDishes().size() == 1);
        assertThat(foundedIngredient).isNotNull();


    }
}
