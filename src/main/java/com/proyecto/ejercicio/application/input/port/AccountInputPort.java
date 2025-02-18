package com.proyecto.ejercicio.application.input.port;

import com.proyecto.ejercicio.domain.Cuenta;

import java.time.LocalDate;
import java.util.List;

public interface AccountInputPort {

    List<Cuenta> findAll();

    Boolean delete(String accountNumber);

    Cuenta getById(String accountNumber);

    Cuenta update(String accountNumber, Cuenta customerDomain);

    Cuenta save(Cuenta customerDomain);

}
