package com.proyecto.ejercicio.infrastructure.output.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@Entity
@Table(name = "cuenta")
public class CuentaEntity {

    @Id
    private String numeroCuenta;

    @Column(nullable = false)
    private String tipoCuenta;

    @Column(name = "saldoinicial", nullable = false, precision = 18, scale = 2)
    private BigDecimal saldoinicial; 

    @Column(nullable = false)
    private boolean estado;

    @ManyToOne
    @JoinColumn(name = "idCliente", nullable = false)
    private ClienteEntity cliente;


}
