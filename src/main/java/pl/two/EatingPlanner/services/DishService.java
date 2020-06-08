package pl.two.EatingPlanner.services;

import org.springframework.stereotype.Service;
import pl.two.EatingPlanner.model.Dish;
import pl.two.EatingPlanner.repository.DishRepository;

import java.util.List;

@Service
public class DishService {

    private final DishRepository dishRepository;

    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public Dish save(Dish dish) {
        return dishRepository.save(dish);
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
