package com.proyecto.ejercicio.application.service;

import com.proyecto.ejercicio.application.input.port.AccountInputPort;
import com.proyecto.ejercicio.application.output.port.AccountOutputPort;
import com.proyecto.ejercicio.domain.Cuenta;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
@AllArgsConstructor
public class AccountService implements AccountInputPort {
    private final AccountOutputPort accountOutputPort;


    @Override
    public List<Cuenta> findAll() {
        return accountOutputPort.findAll();

    }

    @Override
    public Boolean delete(String accountNumber) {
        return accountOutputPort.delete(accountNumber);
    }

    @Override
    public Cuenta getById(String accountNumber) {
        return accountOutputPort.getById(accountNumber);
    }

    @Override
    public Cuenta update(String accountNumber, Cuenta customerDomain) {
        return accountOutputPort.update(accountNumber, customerDomain);
    }

    @Override
    public Cuenta save(Cuenta customerDomain) {
        return accountOutputPort.save(customerDomain);
    }
}
