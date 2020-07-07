package pl.two.EatingPlanner.controllers;

import org.springframework.web.bind.annotation.*;
import pl.two.EatingPlanner.models.Ingredient;
import pl.two.EatingPlanner.services.IngredientService;

import java.util.List;

@RestController
@RequestMapping("/ingredients")
@CrossOrigin
public class IngredientController {

    private IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/all")
    public List<Ingredient> getAll() {
        return ingredientService.findAll();
    }

    @GetMapping("/byName/{name}")
    public Ingredient getByName(@PathVariable String name) {
        return ingredientService.findByName(name);
    }

    @PostMapping("/add")
    public void add(@RequestBody Ingredient ingredient) {
        ingredientService.save(ingredient);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id) {
        this.ingredientService.delete(id);
    }
}
