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

public class Shipment {
    @Column
    @NotNull(message = "Name must not be null")
    String firstName;

    @Column
    @NotNull(message = "Name must not be null")
    String lastName;

    @Column
    @NotNull(message = "Name must not be null")
    @Min(value = 1000, message = "Tracking number must be a bigger number")
    int trackingNumber;

    @Column
    @NotNull(message = "Name must not be null")
    String StoreInfo;

    @Column
    @NotNull(message = "Name must not be null")
    @Min(value = 1000, message = "Tracking number must be a bigger number")
    int returnTrackingNumber;

    @Id
    @GeneratedValue
    private Long id;

    public Shipment(String firstName, String lastName, int trackingNumber, String storeInfo, int returnTrackingNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.trackingNumber = trackingNumber;
        this.StoreInfo = storeInfo;
        this.returnTrackingNumber = returnTrackingNumber;
    }
}