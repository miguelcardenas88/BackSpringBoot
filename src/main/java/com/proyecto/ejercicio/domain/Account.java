package com.proyecto.ejercicio.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Account {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String number;

    private String type;

    private BigDecimal initialBalance;

    private String status;

    private String customerId;
}
