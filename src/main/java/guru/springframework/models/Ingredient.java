package guru.springframework.models;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private BigDecimal amount;

    @ManyToOne
    private Recipe recipe;

    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMesure unitOfMesure;

    public Ingredient() {
    }

    public Ingredient(String description, BigDecimal amount, UnitOfMesure unitOfMesure) {
        this.description = description;
        this.amount = amount;
        this.unitOfMesure = unitOfMesure;
    }

}
