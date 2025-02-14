package com.proyecto.ejercicio.infrastructure.input.adapter.rest.impl;
import jakarta.validation.Valid;
import com.proyecto.ejercicio.infrastructure.output.repository.ClienteRepository;
import com.proyecto.ejercicio.infrastructure.output.repository.entity.ClienteEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {

    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping
    public List<ClienteEntity> listarClientes() {
        return clienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteEntity> obtenerCliente(@PathVariable Integer id) {
        Optional<ClienteEntity> cliente = clienteRepository.findById(id);
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
public ResponseEntity<ClienteEntity> agregarCliente(@Valid @RequestBody ClienteEntity cliente) {
    ClienteEntity nuevoCliente = clienteRepository.save(cliente);
    return ResponseEntity.ok(nuevoCliente);
}

    

    @PutMapping("/{id}")
    public ResponseEntity<ClienteEntity> actualizarCliente(@PathVariable Integer id, @RequestBody ClienteEntity clienteActualizado) {
        return clienteRepository.findById(id)
                .map(cliente -> {
                    cliente.setClave(clienteActualizado.geteClave());
                    cliente.setEstado(clienteActualizado.isEstado());
                    return ResponseEntity.ok(clienteRepository.save(cliente));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Integer id) {
        if (!clienteRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        clienteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
