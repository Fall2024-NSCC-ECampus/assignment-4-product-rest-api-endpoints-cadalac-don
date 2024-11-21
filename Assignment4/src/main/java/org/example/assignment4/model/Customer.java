package org.example.assignment4.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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

public class Customer {
    @Column
    @NotNull(message = "Name must not be null")
    String firstName;
    @Column
    @NotNull(message = "Name must not be null")
    String lastName;
    @Column
    @NotNull(message = "Number must not be null")
    String phoneNumber;
    @Column
    @NotNull(message = "Address must not be null")
    String shippingAddress;
    @Column
    @NotNull(message = "E-mail must not be null")
    String email;

    @Id
    @GeneratedValue
    private Long id;

    public Customer(String firstName, String lastName, String phoneNumber, String shippingAddress, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.shippingAddress = shippingAddress;
        this.email = email;
    }
}
