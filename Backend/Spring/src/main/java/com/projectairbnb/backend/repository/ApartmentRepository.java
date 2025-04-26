package com.projectairbnb.backend.repository;

import com.projectairbnb.backend.model.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {
    List<Apartment> findByHostId(Long hostId);
    List<Apartment> findByLocationContainingIgnoreCase(String location);
}

