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

public class Store {
    @Column
    @NotNull(message = "Name must not be null")
    @Min(value = 0, message = "Tracking number must be a bigger number")
    int shippingHubRates;

    @Column
    @NotNull(message = "Name must not be null")
    @Min(value = 0, message = "Tracking number must be a bigger number")
    int creditCardNumber;

    @Column
    @NotNull(message = "Name must not be null")
    String creditCardName;

    @Column
    @NotNull(message = "Name must not be null")
    String companyID;

    @Column
    @NotNull(message = "Name must not be null")
    String itemPhones;

    @Column
    @NotNull(message = "Name must not be null")
    @Min(value = 0, message = "Tracking number must be a bigger number")
    int quantities;

    @Id
    @GeneratedValue
    private Long id;

    public Store(int shippingHubRates, int creditCardNumber, String creditCardName,
                 String companyID, String itemPhones, int quantities) {
        this.shippingHubRates = shippingHubRates;
        this.creditCardNumber = creditCardNumber;
        this.creditCardName = creditCardName;
        this.companyID = companyID;
        this.itemPhones = itemPhones;
        this.quantities = quantities;
    }
}
