package com.proyecto.ejercicio.infrastructure.output.repository;

import com.proyecto.ejercicio.infrastructure.output.repository.entity.CuentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepository extends JpaRepository<CuentaEntity, String> {
}
