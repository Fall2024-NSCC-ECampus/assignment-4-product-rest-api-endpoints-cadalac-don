package org.example.assignment4.repository;

import org.example.assignment4.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    public void deleteUsersById(Long id);
}
