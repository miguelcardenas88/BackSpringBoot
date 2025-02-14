package com.proyecto.ejercicio.infrastructure.input.adapter.rest.impl;

import com.proyecto.ejercicio.infrastructure.output.repository.MovimientoRepository;
import com.proyecto.ejercicio.infrastructure.output.repository.CuentaRepository;
import com.proyecto.ejercicio.infrastructure.output.repository.entity.MovimientoEntity;
import com.proyecto.ejercicio.infrastructure.output.repository.entity.CuentaEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movimientos")
@CrossOrigin(origins = "http://localhost:4200")
public class MovimientoController {

    private final MovimientoRepository movimientoRepository;
    private final CuentaRepository cuentaRepository;

    public MovimientoController(MovimientoRepository movimientoRepository, CuentaRepository cuentaRepository) {
        this.movimientoRepository = movimientoRepository;
        this.cuentaRepository = cuentaRepository;
    }

    @GetMapping
    public List<MovimientoEntity> getAllMovimientos() {
        return movimientoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovimientoEntity> getMovimientoById(@PathVariable Integer id) {
        Optional<MovimientoEntity> movimiento = movimientoRepository.findById(id);
        return movimiento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createMovimiento(@RequestBody MovimientoEntity movimiento) {
        Optional<CuentaEntity> cuentaOpt = cuentaRepository.findById(movimiento.getCuenta().getNumeroCuenta());
        if (cuentaOpt.isEmpty()) {
            return new ResponseEntity<>("Cuenta no encontrada", HttpStatus.BAD_REQUEST);
        }

        CuentaEntity cuenta = cuentaOpt.get();
        BigDecimal nuevoSaldo;

        if (movimiento.getTipoMovimiento().equalsIgnoreCase("RETIRO")) 
        {
            if (cuenta.getSaldoInicial().compareTo(movimiento.getValor()) < 0) { 
                return new ResponseEntity<>("Saldo insuficiente", HttpStatus.BAD_REQUEST);
            }
            nuevoSaldo = cuenta.getSaldoInicial().subtract(movimiento.getValor()); 
        } else {
            nuevoSaldo = cuenta.getSaldoInicial().add(movimiento.getValor()); 
        }
        
        cuenta.setSaldoInicial(nuevoSaldo);
        movimiento.setSaldo(nuevoSaldo); 
        

        cuenta.setSaldoInicial(nuevoSaldo);
        cuentaRepository.save(cuenta);

        movimiento.setCuenta(cuenta);
        movimiento.setFecha(LocalDateTime.now());
        movimiento.setSaldo(nuevoSaldo);

        return new ResponseEntity<>(movimientoRepository.save(movimiento), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovimiento(@PathVariable Integer id) {
        if (!movimientoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        movimientoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
