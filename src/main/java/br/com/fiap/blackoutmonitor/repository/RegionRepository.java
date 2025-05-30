package br.com.fiap.blackoutmonitor.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.blackoutmonitor.model.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {
    Optional<Region> findByCep(String cep);
}

