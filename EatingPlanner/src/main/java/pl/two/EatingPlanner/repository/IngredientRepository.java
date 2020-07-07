package pl.two.EatingPlanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.two.EatingPlanner.models.Ingredient;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    Ingredient findByName(String imageName);
}
