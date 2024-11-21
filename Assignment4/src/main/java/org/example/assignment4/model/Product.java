package org.example.assignment4.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Column
    @NotNull(message = "Name must not be null")
    String name;

    @Column
    @NotNull(message = "Name must not be null")
    @Min(value = 0, message = "Price must be a positive number!")
    int price;

    @Column
    @NotNull(message = "Name must not be null")
    @Min(value = 0, message = "Quantities must be positive!")
    int quantities;

    @Id
    @GeneratedValue
    private Long id;

    public Product(String name, int price, int quantities) {
        this.name = name;
        this.price = price;
        this.quantities = quantities;
    }
}
