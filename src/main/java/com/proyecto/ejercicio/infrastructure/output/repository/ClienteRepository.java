package com.proyecto.ejercicio.infrastructure.output.repository;

import com.proyecto.ejercicio.infrastructure.output.repository.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer> {
}
