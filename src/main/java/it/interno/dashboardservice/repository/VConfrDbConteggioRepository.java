package it.interno.dashboardservice.repository;

import it.interno.dashboardservice.entity.VConfrDbConteggio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VConfrDbConteggioRepository extends JpaRepository<VConfrDbConteggio, Long> {
}