package br.com.fiap.blackoutmonitor.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.blackoutmonitor.model.Device;

public interface DeviceRepository extends JpaRepository<Device, Long> {
    Optional<Device> findByIdentifier(String identifier);
}