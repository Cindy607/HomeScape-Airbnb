package com.projectairbnb.backend.repository;

import com.projectairbnb.backend.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    // You can add custom query methods later if needed
}