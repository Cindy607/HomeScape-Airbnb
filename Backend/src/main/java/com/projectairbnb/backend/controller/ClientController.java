package com.projectairbnb.backend.controller;

import com.projectairbnb.backend.model.Client;
import com.projectairbnb.backend.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@CrossOrigin(origins = "*")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @PostMapping("/register")
    public Client registerClient(@RequestBody Client client) {
        return clientRepository.save(client);
    }

    @GetMapping
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @PostMapping("/login")
    public Client loginClient(@RequestBody Client loginRequest) {
        List<Client> clients = clientRepository.findAll();
        for (Client client : clients) {
            if (client.getEmail().equals(loginRequest.getEmail()) && client.getPassword().equals(loginRequest.getPassword())) {
                return client; // login successful
            }
        }
        return null; // login failed
    }
}
