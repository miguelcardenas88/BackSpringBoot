package com.proyecto.ejercicio.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente extends Persona {

    private String clienteId;

    private String clave;

    private boolean estado;


}
