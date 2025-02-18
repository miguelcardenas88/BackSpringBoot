package com.proyecto.ejercicio.infrastructure.output.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cliente")
public class ClienteEntity extends PersonaEntity {

    @Column(unique = true, nullable = false)
    private String clienteId;

    @Column(nullable = false)
    private String clave;

    @Column(nullable = false)
    private boolean estado;

}
