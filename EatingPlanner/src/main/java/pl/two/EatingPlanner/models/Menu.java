package pl.two.EatingPlanner.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Transactional
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate createdAt;

    @ManyToMany(mappedBy = "menus")
    @JsonIgnoreProperties("menus")
    private List<Dish> dishes = new ArrayList<>();

    private int dishesPerDay;

    private int durationTimeInDays;

    public void addDish(Dish dish){
        this.dishes.add(dish);
        dish.getMenus().add(this);
    }

    public void removeDish(Dish dish){
        this.dishes.remove(dish);
        dish.getMenus().remove(this);
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdAt=" + createdAt +
                ", dishes=" + dishes +
                ", dishesPerDay=" + dishesPerDay +
                ", durationTimeInDays=" + durationTimeInDays +
                '}';
    }
}

