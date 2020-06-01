package pl.two.EatingPlanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.two.EatingPlanner.model.Dish;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {
}
