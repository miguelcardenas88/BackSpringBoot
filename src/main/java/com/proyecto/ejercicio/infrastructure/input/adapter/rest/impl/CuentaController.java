package com.proyecto.ejercicio.infrastructure.input.adapter.rest.impl;

import com.proyecto.ejercicio.infrastructure.output.repository.CuentaRepository;
import com.proyecto.ejercicio.infrastructure.output.repository.ClienteRepository;
import com.proyecto.ejercicio.infrastructure.output.repository.entity.CuentaEntity;
import com.proyecto.ejercicio.infrastructure.output.repository.entity.ClienteEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cuentas")
@CrossOrigin(origins = "http://localhost:4200")
public class CuentaController {

    private final CuentaRepository cuentaRepository;
    private final ClienteRepository clienteRepository;

    public CuentaController(CuentaRepository cuentaRepository, ClienteRepository clienteRepository) {
        this.cuentaRepository = cuentaRepository;
        this.clienteRepository = clienteRepository;
    }

    @GetMapping
    public List<CuentaEntity> getAllCuentas() {
        return cuentaRepository.findAll();
    }

    @GetMapping("/{numeroCuenta}")
    public ResponseEntity<CuentaEntity> getCuentaById(@PathVariable String numeroCuenta) {
        Optional<CuentaEntity> cuenta = cuentaRepository.findById(numeroCuenta);
        return cuenta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createCuenta(@RequestBody CuentaEntity cuenta) {
        Optional<ClienteEntity> clienteOpt = clienteRepository.findById(cuenta.getCliente().getId());
        if (clienteOpt.isEmpty()) {
            return new ResponseEntity<>("Cliente no encontrado", HttpStatus.BAD_REQUEST);
        }
        
        cuenta.setCliente(clienteOpt.get());
        return new ResponseEntity<>(cuentaRepository.save(cuenta), HttpStatus.CREATED);
    }

    @PutMapping("/{numeroCuenta}")
    public ResponseEntity<CuentaEntity> updateCuenta(@PathVariable String numeroCuenta, @RequestBody CuentaEntity cuentaActualizada) {
        return cuentaRepository.findById(numeroCuenta)
                .map(cuenta -> {
                    cuenta.setTipoCuenta(cuentaActualizada.getTipoCuenta() != null ? cuentaActualizada.getTipoCuenta() : cuenta.getTipoCuenta());
                    cuenta.setSaldoinicial(cuentaActualizada.getSaldoinicial());
                    cuenta.setEstado(cuentaActualizada.isEstado());
                    return ResponseEntity.ok(cuentaRepository.save(cuenta));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{numeroCuenta}")
    public ResponseEntity<Void> deleteCuenta(@PathVariable String numeroCuenta) {
        if (!cuentaRepository.existsById(numeroCuenta)) {
            return ResponseEntity.notFound().build();
        }
        cuentaRepository.deleteById(numeroCuenta);
        return ResponseEntity.noContent().build();
    }
}
