package com.projectairbnb.backend.controller;

import com.projectairbnb.backend.model.Apartment;
import com.projectairbnb.backend.repository.ApartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apartments")
@CrossOrigin(origins = "*")
public class ApartmentController {

    @Autowired
    private ApartmentRepository apartmentRepository;

    @PostMapping("/add")
    public Apartment addApartment(@RequestBody Apartment apartment) {
        return apartmentRepository.save(apartment);
    }

    @GetMapping("/host/{hostId}")
    public List<Apartment> getApartmentsByHost(@PathVariable Long hostId) {
        return apartmentRepository.findByHostId(hostId);
    }

    @DeleteMapping("/{apartmentId}")
    public void deleteApartment(@PathVariable Long apartmentId) {
        apartmentRepository.deleteById(apartmentId);
    }

    @GetMapping("/search")
    public List<Apartment> searchApartments(@RequestParam String location) {
        return apartmentRepository.findByLocationContainingIgnoreCase(location);
    }
}

