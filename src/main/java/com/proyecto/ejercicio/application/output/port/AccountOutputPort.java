package com.proyecto.ejercicio.application.output.port;

import com.proyecto.ejercicio.domain.Cuenta;

import java.time.LocalDate;
import java.util.List;

public interface AccountOutputPort {
    List<Cuenta> findAll();

    Boolean delete(String accountNumber);

    Cuenta getById(String accountNumber);

    Cuenta update(String accountNumber, Cuenta customerDomain);

    Cuenta save(Cuenta customerDomain);

}
