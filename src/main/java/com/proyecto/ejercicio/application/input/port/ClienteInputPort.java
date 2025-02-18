package com.proyecto.ejercicio.application.input.port;

import com.proyecto.ejercicio.domain.Cliente;

import java.util.List;

public interface ClienteInputPort {

    List<Cliente> findAll();

    Boolean delete(String accountNumber);

    Cliente getById(String accountNumber);

    Cliente update(String accountNumber, Cliente customerDomain);

    Cliente save(Cliente customerDomain);

}
