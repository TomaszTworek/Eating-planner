package pl.two.EatingPlanner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.two.EatingPlanner.model.*;
import pl.two.EatingPlanner.repository.DishRepository;
import pl.two.EatingPlanner.repository.ImageRepository;
import pl.two.EatingPlanner.repository.IngredientRepository;
import pl.two.EatingPlanner.repository.MenuRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class IntegrationTestsForProperEntitiesMapping {

    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private DishRepository dishRepository;
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private ImageRepository imageRepository;

    private Ingredient testIngredient1;
    private Ingredient testIngredient2;
    private Dish testDish1;
    private Dish testDish2;
    private Menu testMenu1;
    private Menu testMenu2;
    private Image image;

    @Before
    public void setUp() {
        testIngredient1 = new Ingredient();
        testIngredient1.setName("Ingredient Test 1");
        testIngredient1.setAmount(2.0);
        testIngredient1.setUnits("kg");

        testIngredient2 = new Ingredient();
        testIngredient2.setName("Ingredient Test 2");
        testIngredient2.setAmount(5.0);
        testIngredient2.setUnits("dag");

        testDish1 = new Dish();
        testDish1.setName("Dish Test 1");
        testDish1.setDescription("This is fresh and juicy");
        testDish1.setDishCategory(DishCategory.DINNER);

        testDish2 = new Dish();
        testDish2.setName("Dish Test 2");
        testDish2.setDescription("This is a little bit spicy. Take care!");
        testDish2.setDishCategory(DishCategory.LUNCH);

        testMenu1 = new Menu();
        testMenu1.setName("Casual menu");
        testMenu1.setDishesPerDay(4);
        testMenu1.setDurationTimeInDays(5);

        testMenu2 = new Menu();
        testMenu2.setName("Standard menu");
        testMenu2.setDishesPerDay(3);
        testMenu2.setDurationTimeInDays(10);

        image = new Image();
        image.setName("Test Image");

        ingredientRepository.save(testIngredient1);
        ingredientRepository.save(testIngredient2);

        dishRepository.save(testDish1);
        dishRepository.save(testDish2);

        menuRepository.save(testMenu1);
        menuRepository.save(testMenu2);

        imageRepository.save(image);
    }

    @Test
    public void shouldDishContainsExactlyThreeIngredientsAfterAddDishToThisIngredients() {
        //given
        Ingredient testedIngredient1 = ingredientRepository.findById(1L).get();
        Ingredient testedIngredient2 = ingredientRepository.findById(2L).get();

        //when
        testDish1.addIngredient(testedIngredient1);
        testDish1.addIngredient(testedIngredient1);
        testDish1.addIngredient(testedIngredient2);
        Dish foundedDish = dishRepository.save(testDish1);

        //than
        assertThat(foundedDish.getIngredients().size()).isEqualTo(3);
    }

    @Test
    public void shouldDatabaseContainsThreeDishesAfterAddOne() {
        dishRepository.save(new Dish());

        List<Dish> allDishesFromRepository = dishRepository.findAll();

        assertThat(allDishesFromRepository.size()).isEqualTo(3);
    }

    @Test
    public void shouldMenuContainsOneDishAndDishContainsOneIngredient() {

        testDish2.addIngredient(testIngredient2);
        dishRepository.save(testDish2);
        testMenu2.addDish(testDish2);
        menuRepository.save(testMenu2);

        Menu testedMenu = menuRepository.findByName("Standard menu");

        assertThat(testedMenu.getDishes().size()).isEqualTo(1);
        assertThat(testedMenu.getDishes().get(0).getIngredients().size()).isEqualTo(1);
    }

    @Test
    public void shouldDishHaveImage() {
        testDish1.setImage(image);

        Dish savedDish = dishRepository.save(testDish1);

        assertThat(savedDish.getImage().getName()).isEqualTo("Test Image");
    }

    @Test
    public void shouldFindMenuByName() {
        Menu testedMenu = menuRepository.findByName("Casual menu");

        assertThat(testedMenu.getName()).isEqualTo("Casual menu");
        assertThat(testedMenu.getDishesPerDay()).isEqualTo(4);
    }
}
