package pl.two.EatingPlanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.two.EatingPlanner.model.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
}
