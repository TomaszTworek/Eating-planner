package pl.two.EatingPlanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.two.EatingPlanner.models.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    Menu findByName(String name);
}
