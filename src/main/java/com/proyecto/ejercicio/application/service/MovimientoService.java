package com.proyecto.ejercicio.application.service;

import com.proyecto.ejercicio.application.input.port.AccountInputPort;
import com.proyecto.ejercicio.application.input.port.MovimientoInputPort;
import com.proyecto.ejercicio.application.output.port.AccountOutputPort;
import com.proyecto.ejercicio.application.output.port.MovimientoOutputPort;
import com.proyecto.ejercicio.domain.Cuenta;
import com.proyecto.ejercicio.domain.Movimiento;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MovimientoService implements MovimientoInputPort {
    private final MovimientoOutputPort movimientoOutputPort;


    @Override
    public List<Movimiento> findAll() {
        return movimientoOutputPort.findAll();

    }

    @Override
    public Boolean delete(String accountNumber) {
        return movimientoOutputPort.delete(accountNumber);
    }

    @Override
    public Movimiento getById(String accountNumber) {
        return movimientoOutputPort.getById(accountNumber);
    }


    @Override
    public Movimiento update(String accountNumber, Movimiento customerDomain) {
        return movimientoOutputPort.update(accountNumber, customerDomain);
    }

    @Override
    public Movimiento save(Movimiento customerDomain) {
        return movimientoOutputPort.save(customerDomain);
    }
}
