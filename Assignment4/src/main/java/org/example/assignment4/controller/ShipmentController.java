package org.example.assignment4.controller;
import org.example.assignment4.model.Shipment;
import org.example.assignment4.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ShipmentController {

    @Autowired
    private final ShipmentRepository shipmentRepository;
    public ShipmentController(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    @PostMapping(value = "/api/v1/new-shipment")
    public ResponseEntity<Shipment> createList(@RequestBody Shipment shipment) {
        shipmentRepository.save(shipment);
        return new ResponseEntity<>(shipment, HttpStatus.CREATED);
    }

    @GetMapping(value = "/api/v1/list-shipment")
    public ResponseEntity<List<Shipment>> listLists() {
        List<Shipment> shipment = shipmentRepository.findAll();
        return new ResponseEntity<>(shipment, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/v1/delete-shipment/{id}")
    public ResponseEntity<Map<String, String>> deleteUsersById(@PathVariable Long id){
        return shipmentRepository.findById(id).
                map( shipment -> {
                    shipmentRepository.delete(shipment);
                    Map<String, String> response = new HashMap<>();
                    response.put("message", "Shipment has been deleted");
                    return new ResponseEntity<>(response, HttpStatus.OK);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Shipment not found"));
    }
}