package com.proyecto.ejercicio.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class Movimiento {

    private Integer id;

    private String tipoMovimiento;


    private BigDecimal valor;

    private BigDecimal saldo;


    private LocalDateTime fecha = LocalDateTime.now();

    private Cuenta cuenta;
    
}
