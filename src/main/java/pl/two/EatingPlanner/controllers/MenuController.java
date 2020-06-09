package pl.two.EatingPlanner.controllers;

import org.springframework.web.bind.annotation.RestController;
import pl.two.EatingPlanner.services.MenuService;

@RestController
public class MenuController {

    private MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }
}
