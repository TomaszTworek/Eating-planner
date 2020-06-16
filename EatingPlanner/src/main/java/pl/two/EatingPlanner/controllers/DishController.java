package pl.two.EatingPlanner.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.two.EatingPlanner.model.Dish;
import pl.two.EatingPlanner.services.DishService;

import java.util.List;

@RestController
public class DishController {

    private DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping
    public List<Dish> getAll() {
        return dishService.findAll();
    }

    @PostMapping
    public void addDish(@RequestBody Dish dish) {
        dishService.save(dish);
    }
}
