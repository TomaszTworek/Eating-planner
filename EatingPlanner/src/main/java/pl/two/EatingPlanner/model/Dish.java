package pl.two.EatingPlanner.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private DishCategory dishCategory;

    private String description;

    @OneToOne(cascade = CascadeType.MERGE)
    private Image image;

    @ManyToMany(mappedBy = "dishes")
    @JsonIgnoreProperties("dishes")
    private List<Ingredient> ingredients = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "dishes_menus",
            joinColumns = @JoinColumn(name = "dish_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "menu_id", referencedColumnName = "id"))
    private List<Menu> menus = new ArrayList<>();

    private Double calories;


    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
        ingredient.getDishes().add(this);
    }

    public void removeIngredient(Ingredient ingredient) {
        this.ingredients.remove(ingredient);
        ingredient.getDishes().remove(this);
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dishCategory=" + dishCategory +
                ", description='" + description + '\'' +
                ", image=" + image +
                ", ingredients=" + ingredients +
                ", calories=" + calories +
                '}';
    }
}
