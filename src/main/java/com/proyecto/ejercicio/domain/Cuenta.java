package com.proyecto.ejercicio.domain;

import com.proyecto.ejercicio.infrastructure.output.repository.entity.ClienteEntity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Cuenta {

    private String numeroCuenta;

    private String tipoCuenta;

    private BigDecimal saldoinicial;

    private boolean estado;

    private ClienteEntity cliente;


}
