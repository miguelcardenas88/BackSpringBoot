package com.proyecto.ejercicio.infrastructure.output.adapter;

import com.proyecto.ejercicio.application.output.port.ClienteOutputPort;
import com.proyecto.ejercicio.domain.Cliente;
import com.proyecto.ejercicio.infrastructure.output.repository.ClienteRepository;
import com.proyecto.ejercicio.infrastructure.output.repository.entity.ClienteEntity;
import com.proyecto.ejercicio.infrastructure.output.repository.mapper.ClienteMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class ClienteAdapter implements ClienteOutputPort {
    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;
    @Override
    public List<Cliente> findAll() {
        return clienteMapper.ListAccountEntityToAccount(clienteRepository.findAll());
    }

    @Override
    public Boolean delete(String accountNumber) {
        if (!clienteRepository.existsById(Integer.valueOf(accountNumber) )) {
            return false;
        }
        clienteRepository.deleteById(Integer.valueOf(accountNumber));
        return true;
    }

    @Override
    public Cliente getById(String accountNumber)
    {
        Optional<ClienteEntity> cuenta = clienteRepository.findById(Integer.valueOf(accountNumber));
        return cuenta.map(clienteMapper::AccountEntityToAccount).orElse(null);
    }

    @Override
    public Cliente update(String accountNumber, Cliente clienteDomain) {

        Optional<ClienteEntity> valor =   clienteRepository.findById(Integer.valueOf(accountNumber))
                .map(cliente -> {
                    cliente.setClave(clienteDomain.getClave());
                    cliente.setEstado(clienteDomain.isEstado());
                    return clienteRepository.save(cliente);
                });
            return clienteMapper.AccountEntityToAccount(valor.get());

    }

    @Override
    public Cliente save(Cliente customerDomain) {
        customerDomain.setClave("1234");
        customerDomain.setEstado(true);
        customerDomain.setId(null);
        var cuenta= clienteRepository.save(clienteMapper.AccountDomainToAccountEntity(customerDomain));
         return  clienteMapper.AccountEntityToAccount(cuenta);
    }


}

