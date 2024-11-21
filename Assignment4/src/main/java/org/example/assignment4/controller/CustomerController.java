package org.example.assignment4.controller;
import org.example.assignment4.model.Customer;
import org.example.assignment4.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CustomerController {

    @Autowired
    private final CustomerRepository customerRepository;
    public CustomerController(CustomerRepository customerRepository) {this.customerRepository = customerRepository;}

    @PostMapping(value = "/api/v1/new-customer")
    public ResponseEntity<Customer> createUser(@RequestBody Customer customer){
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @GetMapping(value = "/api/v1/list-customer")
    public ResponseEntity<List<Customer>> listUsers(){
        List<Customer> customer = customerRepository.findAll();
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/v1/delete-customer/{id}")
    public ResponseEntity<Map<String, String>> deleteUsersById(@PathVariable Long id){
        return customerRepository.findById(id).
                map( customer -> {
                    customerRepository.delete(customer);
                    Map<String, String> response = new HashMap<>();
                    response.put("message", "Customer has been deleted");
                    return new ResponseEntity<>(response, HttpStatus.OK);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));
    }
}
