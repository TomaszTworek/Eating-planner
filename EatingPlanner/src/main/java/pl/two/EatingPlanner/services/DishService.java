package pl.two.EatingPlanner.services;

import org.springframework.stereotype.Service;
import pl.two.EatingPlanner.models.Dish;
import pl.two.EatingPlanner.models.Ingredient;
import pl.two.EatingPlanner.repository.DishRepository;
import pl.two.EatingPlanner.repository.IngredientRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishService {

    private final DishRepository dishRepository;
    private final IngredientRepository ingredientRepository;
    private final ImageService imageService;

    public DishService(DishRepository dishRepository, IngredientRepository ingredientRepository, ImageService imageService) {
        this.dishRepository = dishRepository;
        this.ingredientRepository = ingredientRepository;
        this.imageService = imageService;
    }

    //I create new dashDAO object because i want to add every ingredient From dish list to database and to dish
    //itself. I also want to save dish in database. Without new object there might be problem with concurrent modification
    //exception when i try to addIngredient to dish.
    public Dish save(Dish dish) {
        Dish dishDAO = createNewDishDAOObject(dish);
        List<Ingredient> ingredients = new ArrayList<>(dish.getIngredients());
        for (Ingredient ingredient : ingredients) {
            dishDAO.addIngredient(ingredient);
            ingredientRepository.save(ingredient);
        }
        return dishRepository.save(dishDAO);
    }

    private Dish createNewDishDAOObject(Dish dish) {
        Dish dishDAO = new Dish();
        dishDAO.setName(dish.getName());
        dishDAO.setDescription(dish.getDescription());
        dishDAO.setImage(imageService.getCurrentImage());
        dishDAO.setDishCategory(dish.getDishCategory());
        dishDAO.setCalories(dish.getCalories());
        return dishDAO;
    }

    public List<Dish> findAll() {
        return dishRepository.findAll();
    }

    public void delete(Dish dish) {
        dishRepository.delete(dish);
    }

    public Dish findByName(String name) {
        return dishRepository.findByName(name);
    }
}
