package pl.two.EatingPlanner.controllers;

import org.springframework.web.bind.annotation.*;
import pl.two.EatingPlanner.model.Dish;
import pl.two.EatingPlanner.services.DishService;

import java.util.List;

@RestController
@RequestMapping("/dishes")
@CrossOrigin
public class DishController {

    private DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping("/all")
    public List<Dish> getAll() {
        return dishService.findAll();
    }

    @PostMapping("/add")
    public void addDish(@RequestBody Dish dish) {
        dishService.save(dish);
    }
}
