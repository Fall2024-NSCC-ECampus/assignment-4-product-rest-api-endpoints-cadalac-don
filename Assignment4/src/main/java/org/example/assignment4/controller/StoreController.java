package org.example.assignment4.controller;
import org.example.assignment4.model.Store;
import org.example.assignment4.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StoreController {

    @Autowired
    private final StoreRepository storeRepository;
    public StoreController(StoreRepository storeRepository) {this.storeRepository = storeRepository;}

    @PostMapping(value = "/api/v1/new-store")
    public ResponseEntity<Store> createPurchase(@RequestBody Store store) {
        storeRepository.save(store);
        return new ResponseEntity<>(store, HttpStatus.CREATED);
    }

    @GetMapping(value = "/api/v1/list-store")
    public ResponseEntity<List<Store>> listPurchase() {
        List<Store> store = storeRepository.findAll();
        return new ResponseEntity<>(store, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/v1/delete-store/{id}")
    public ResponseEntity<Map<String, String>> deleteUsersById(@PathVariable Long id){
        return storeRepository.findById(id).
                map( store -> {
                    storeRepository.delete(store);
                    Map<String, String> response = new HashMap<>();
                    response.put("message", "Store has been deleted");
                    return new ResponseEntity<>(response, HttpStatus.OK);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Store not found"));
    }
}