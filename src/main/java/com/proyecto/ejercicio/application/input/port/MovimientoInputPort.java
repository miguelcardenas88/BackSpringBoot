package com.proyecto.ejercicio.application.input.port;

import com.proyecto.ejercicio.domain.Cuenta;
import com.proyecto.ejercicio.domain.Movimiento;

import java.util.List;

public interface MovimientoInputPort {

    List<Movimiento> findAll();

    Boolean delete(String accountNumber);

    Movimiento getById(String accountNumber);

    Movimiento update(String accountNumber, Movimiento customerDomain);

    Movimiento save(Movimiento customerDomain);

}
