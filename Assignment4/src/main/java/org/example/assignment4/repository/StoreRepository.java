package org.example.assignment4.repository;

import org.example.assignment4.model.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
    public void deleteUsersById(Long id);
}
