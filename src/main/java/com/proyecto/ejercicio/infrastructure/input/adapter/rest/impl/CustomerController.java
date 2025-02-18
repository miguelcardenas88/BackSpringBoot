package com.proyecto.ejercicio.infrastructure.input.adapter.rest.impl;


import com.proyecto.ejercicio.application.input.port.ClienteInputPort;
import com.proyecto.ejercicio.domain.Cliente;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {

    private final ClienteInputPort accountInputPort;


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
    public ResponseEntity<?> postAccount(@RequestBody  Cliente account) {
        return new ResponseEntity<>(accountInputPort.save(account),
                HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putAccount(@PathVariable String id, Cliente account) {
        return new ResponseEntity<>(accountInputPort.update(id, account),
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable  String id) {

        return new ResponseEntity<>(accountInputPort.delete(id), HttpStatus.NO_CONTENT);
    }


}
