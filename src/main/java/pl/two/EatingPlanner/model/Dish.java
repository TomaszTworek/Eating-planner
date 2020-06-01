package pl.two.EatingPlanner.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Entity
@Transactional
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private DishCategory dishCategory;

    private String description;

    @OneToOne(cascade = CascadeType.MERGE)
    private Image image;

    @ManyToMany(mappedBy = "dishes")
    @JsonIgnoreProperties("dishes")
    private Set<Ingredient> ingredients = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "dishes_menus",
            joinColumns = @JoinColumn(name = "dish_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id", referencedColumnName = "id"))
    private Set<Menu> menus = new HashSet<>();

    private Double calories;



}
