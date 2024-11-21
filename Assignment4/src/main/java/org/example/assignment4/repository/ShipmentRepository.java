package org.example.assignment4.repository;

import org.example.assignment4.model.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
    public void deleteUsersById(Long id);
}
