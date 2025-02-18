package com.proyecto.ejercicio.infrastructure.output.adapter;

import com.proyecto.ejercicio.application.output.port.MovimientoOutputPort;
import com.proyecto.ejercicio.domain.Movimiento;
import com.proyecto.ejercicio.infrastructure.output.repository.CuentaRepository;
import com.proyecto.ejercicio.infrastructure.output.repository.MovimientoRepository;
import com.proyecto.ejercicio.infrastructure.output.repository.entity.CuentaEntity;
import com.proyecto.ejercicio.infrastructure.output.repository.entity.MovimientoEntity;
import com.proyecto.ejercicio.infrastructure.output.repository.mapper.AccountMapper;
import com.proyecto.ejercicio.infrastructure.output.repository.mapper.MovimientoMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class MovimientoAdapter implements MovimientoOutputPort {
    private final MovimientoRepository movimientoRepository;
    private final CuentaRepository cuentaRepository;
    private final MovimientoMapper movimientoMapper;
    @Override
    public List<Movimiento> findAll() {
        return movimientoMapper.ListAccountEntityToAccount(movimientoRepository.findAll()) ;
    }

    @Override
    public Boolean delete(String accountNumber) {
        if (!movimientoRepository.existsById(Integer.valueOf(accountNumber))) {
            return false;
        }
        movimientoRepository.deleteById(Integer.valueOf(accountNumber));
        return true;
    }

    @Override
    public Movimiento getById(String accountNumber)
    {
        Optional<MovimientoEntity> cuenta = movimientoRepository.findById(Integer.valueOf(accountNumber));
        return cuenta.map(movimientoMapper::AccountEntityToAccount).orElse(null);
    }

    @Override
    public Movimiento update(String accountNumber, Movimiento customerDomain) {

        Optional<MovimientoEntity> valor =   movimientoRepository.findById(Integer.valueOf(accountNumber))
                .map(movimiento -> {
                    movimiento.setId(customerDomain.getId());
                    return movimientoRepository.save(movimiento);
                });
            return movimientoMapper.AccountEntityToAccount(valor.get());

    }

    @Override
    public Movimiento save(Movimiento movimiento) {

        Optional<CuentaEntity> cuentaOpt = cuentaRepository.findById(movimiento.getCuenta().getNumeroCuenta());

        CuentaEntity cuenta = cuentaOpt.get();
        BigDecimal nuevoSaldo;
        if (movimiento.getTipoMovimiento().equalsIgnoreCase("RETIRO")) {
            if (cuenta.getSaldoinicial().compareTo(movimiento.getValor()) < 0) {
                movimiento.setSaldo(BigDecimal.valueOf(0));
                return movimiento;
            }
            nuevoSaldo = cuenta.getSaldoinicial().subtract(movimiento.getValor());
        } else {
            nuevoSaldo = cuenta.getSaldoinicial().add(movimiento.getValor());
        }

        cuenta.setSaldoinicial(nuevoSaldo);

        var movi = movimientoMapper.AccountDomainToAccountEntity(movimiento);
        movi.setSaldo(nuevoSaldo);
        cuenta.setSaldoinicial(nuevoSaldo);
        cuentaRepository.save(cuenta);

        movi.setCuenta(cuenta);
        movi.setFecha(LocalDateTime.now());
        movi.setSaldo(nuevoSaldo);
        movimientoRepository.save(movi);
        return movimiento;
    }
}

