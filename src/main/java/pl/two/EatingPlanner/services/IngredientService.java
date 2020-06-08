package pl.two.EatingPlanner.services;

import org.springframework.stereotype.Service;
import pl.two.EatingPlanner.model.Ingredient;
import pl.two.EatingPlanner.repository.IngredientRepository;

import java.util.List;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public Ingredient save(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    public List<Ingredient> findAll() {
        return ingredientRepository.findAll();
    }

    public void delete(Ingredient ingredient) {
        ingredientRepository.delete(ingredient);
    }

    public Ingredient findByName(String name) {
        return ingredientRepository.findByName(name);
    }
}
