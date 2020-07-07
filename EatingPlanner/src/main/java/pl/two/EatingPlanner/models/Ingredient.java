package pl.two.EatingPlanner.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Entity
@Transactional
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String units;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "ingredient_dishes",
            joinColumns = @JoinColumn(name = "ingredient_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id", referencedColumnName = "id"))
    private List<Dish> dishes = new ArrayList<>();

    private Double calories;

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", units='" + units + '\'' +
                ", calories=" + calories +
                '}';
    }
}
