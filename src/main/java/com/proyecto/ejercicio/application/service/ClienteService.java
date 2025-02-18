package com.proyecto.ejercicio.application.service;

import com.proyecto.ejercicio.application.input.port.AccountInputPort;
import com.proyecto.ejercicio.application.input.port.ClienteInputPort;
import com.proyecto.ejercicio.application.output.port.AccountOutputPort;
import com.proyecto.ejercicio.application.output.port.ClienteOutputPort;
import com.proyecto.ejercicio.domain.Cliente;
import com.proyecto.ejercicio.domain.Cuenta;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteService implements ClienteInputPort {
    private final ClienteOutputPort clienteOutputPort;


    @Override
    public List<Cliente> findAll() {
        return clienteOutputPort.findAll();
    }

    @Override
    public Boolean delete(String accountNumber) {
        return clienteOutputPort.delete(accountNumber);
    }

    @Override
    public Cliente getById(String accountNumber) {
        return clienteOutputPort.getById(accountNumber);
    }



    @Override
    public Cliente update(String accountNumber, Cliente customerDomain) {
        return clienteOutputPort.update(accountNumber, customerDomain);
    }

    @Override
    public Cliente save(Cliente customerDomain) {
        return clienteOutputPort.save(customerDomain);
    }
}
