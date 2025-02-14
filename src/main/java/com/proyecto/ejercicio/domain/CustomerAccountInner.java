package com.proyecto.ejercicio.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomerAccountInner {
    private static final long serialVersionUID = 1L;

    private Account account;


    private List<Movement> movements;
}
