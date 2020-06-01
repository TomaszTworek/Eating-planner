package pl.two.EatingPlanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.two.EatingPlanner.model.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
}
