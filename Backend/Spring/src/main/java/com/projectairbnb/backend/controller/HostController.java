package com.projectairbnb.backend.controller;

import com.projectairbnb.backend.model.Host;
import com.projectairbnb.backend.repository.HostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hosts")
@CrossOrigin(origins = "*")
public class HostController {

    @Autowired
    private HostRepository hostRepository;

    @PostMapping("/register")
    public Host registerHost(@RequestBody Host host) {
        return hostRepository.save(host);
    }

    @GetMapping
    public List<Host> getAllHosts() {
        return hostRepository.findAll();
    }

    @PostMapping("/login")
    public Host loginHost(@RequestBody Host loginRequest) {
        List<Host> hosts = hostRepository.findAll();
        for (Host host : hosts) {
            if (host.getEmail().equals(loginRequest.getEmail()) && host.getPassword().equals(loginRequest.getPassword())) {
                return host; // login successful
            }
        }
        return null; // login failed
    }
}
