package pl.two.EatingPlanner.controllers.viewmodels;

import com.sun.istack.NotNull;
import lombok.Data;
import pl.two.EatingPlanner.model.Dish;

import java.util.List;

@Data
public class IngredientViewModel {

    @NotNull
    private String name;

    @NotNull
    private String units;

    @NotNull
    private Double calories;

    private List<Dish> dishes;

}
