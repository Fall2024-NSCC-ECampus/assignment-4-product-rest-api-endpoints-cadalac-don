package org.example.assignment4.controller;

import jakarta.validation.Valid;
import org.example.assignment4.model.Product;
import org.example.assignment4.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {

    @Autowired
    private final ProductRepository productRepository;
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //Post Request
    @PostMapping(value = "/api/v1/product")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        productRepository.save(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    //UpdateRequest - Put
    @PutMapping(value = "/api/v1/product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @Valid @RequestBody Product updateProduct){
        return productRepository.findById(id).
                map( existingProduct -> {
                    existingProduct.setName(updateProduct.getName());
                    existingProduct.setPrice(updateProduct.getPrice());
                    existingProduct.setQuantities(updateProduct.getQuantities());
                    Product savedProduct = productRepository.save(existingProduct);
                    return new ResponseEntity<>(savedProduct, HttpStatus.OK);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
    }

    //GetByID Request
    @GetMapping(value = "/api/v1/product/{id}")
    public ResponseEntity<Product> listSingleProduct(@PathVariable Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    //Get Request
    @GetMapping(value = "/api/v1/list-product")
    public ResponseEntity<List<Product>> listProduct() {
        List<Product> product = productRepository.findAll();
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    //Delete Request
    @DeleteMapping(value = "api/v1/product/{id}")
    public ResponseEntity<Map<String, String>> deleteUserById(@PathVariable Long id){
        return productRepository.findById(id).
                map( product -> {
                    productRepository.delete(product);
                    Map<String, String> response = new HashMap<>();
                    response.put("message", "Product has been deleted");
                    return new ResponseEntity<>(response, HttpStatus.OK);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
    }
}
