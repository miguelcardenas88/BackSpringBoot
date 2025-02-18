package com.proyecto.ejercicio.infrastructure.input.adapter.rest.impl;


import com.proyecto.ejercicio.application.input.port.AccountInputPort;
import com.proyecto.ejercicio.domain.Cuenta;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cuentas")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {

    private final AccountInputPort accountInputPort;


    @GetMapping
    public ResponseEntity<?> getAccount() {
        return new ResponseEntity<>(accountInputPort.findAll(), HttpStatus.OK);

    }

    @GetMapping("/{numeroCuenta}")
    public ResponseEntity<?> getAccountNumber(@PathVariable String numeroCuenta) {
        return new ResponseEntity<>(accountInputPort.getById(numeroCuenta),
                HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<?> postAccount(@RequestBody Cuenta account) {
        return new ResponseEntity<>(accountInputPort.save(account),
                HttpStatus.CREATED);
    }

    @PutMapping("/{numeroCuenta}")
    public ResponseEntity<?> putAccount(@PathVariable String numeroCuenta, Cuenta account) {
        return new ResponseEntity<>(accountInputPort.update(numeroCuenta, account),
                HttpStatus.OK);
    }

    @DeleteMapping("/{numeroCuenta}")
    public ResponseEntity<?> deleteAccount(@PathVariable String numeroCuenta) {

        return new ResponseEntity<>(accountInputPort.delete(numeroCuenta), HttpStatus.NO_CONTENT);
    }


}
