package com.proyecto.ejercicio.infrastructure.output.repository;

import com.proyecto.ejercicio.infrastructure.output.repository.entity.MovimientoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoRepository extends JpaRepository<MovimientoEntity, Integer> {
}
