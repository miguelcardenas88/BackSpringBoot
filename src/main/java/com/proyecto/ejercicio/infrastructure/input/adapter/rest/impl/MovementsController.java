package com.proyecto.ejercicio.infrastructure.input.adapter.rest.impl;


import com.proyecto.ejercicio.application.input.port.MovimientoInputPort;
import com.proyecto.ejercicio.domain.Movimiento;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/movimientos")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class MovementsController {

    private final MovimientoInputPort accountInputPort;


    @GetMapping
    public ResponseEntity<?> getAccount() {
        return new ResponseEntity<>(accountInputPort.findAll(), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAccountNumber(@PathVariable String id) {
        return new ResponseEntity<>(accountInputPort.getById(id),
                HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<?> postAccount(@RequestBody Movimiento account) {
        var cuenta = accountInputPort.save(account);
        if (cuenta.getSaldo().equals(BigDecimal.valueOf(0))) {
            return new ResponseEntity<>("Saldo insuficiente", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(cuenta,
                HttpStatus.CREATED);
    }
    @PutMapping("/customer/{movementNumber}")
    public ResponseEntity<?> putAccount(@PathVariable String accountNumber, Movimiento account) {
        return new ResponseEntity<>(accountInputPort.update(accountNumber, account),
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable String id) {

        return new ResponseEntity<>(accountInputPort.delete(id), HttpStatus.NO_CONTENT);
    }


}
