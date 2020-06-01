package pl.two.EatingPlanner.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

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
    @JsonIgnoreProperties
    private Set<Dish> dishes = new HashSet<>();

    private Byte dishesPerDay;

    private Byte durationTimeInDays;


}

