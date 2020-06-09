package pl.two.EatingPlanner.controllers;

import org.springframework.web.bind.annotation.RestController;
import pl.two.EatingPlanner.services.DishService;

@RestController
public class DishController {

    private DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }
}
