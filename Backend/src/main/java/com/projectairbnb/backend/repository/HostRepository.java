package com.projectairbnb.backend.repository;

import com.projectairbnb.backend.model.Host;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HostRepository extends JpaRepository<Host, Long> {

}
