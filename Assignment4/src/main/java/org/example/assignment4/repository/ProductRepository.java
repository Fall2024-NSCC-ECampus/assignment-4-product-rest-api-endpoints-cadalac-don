package org.example.assignment4.repository;

import org.example.assignment4.model.Customer;
import org.example.assignment4.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    public void deleteUsersById(Long id);
}
