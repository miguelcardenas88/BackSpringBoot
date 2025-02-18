package com.proyecto.ejercicio.infrastructure.input.adapter.rest.impl;

import com.proyecto.ejercicio.infrastructure.output.repository.ClienteRepository;
import com.proyecto.ejercicio.infrastructure.output.repository.CuentaRepository;
import com.proyecto.ejercicio.infrastructure.output.repository.entity.ClienteEntity;
import com.proyecto.ejercicio.infrastructure.output.repository.entity.CuentaEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CuentaControllerTest {

    @Mock
    private CuentaRepository cuentaRepository;

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private CuentaController cuentaController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllCuentas() {
        List<CuentaEntity> cuentas = Arrays.asList(new CuentaEntity(), new CuentaEntity());
        when(cuentaRepository.findAll()).thenReturn(cuentas);

        List<CuentaEntity> result = cuentaController.getAllCuentas();

        assertEquals(cuentas, result);
        verify(cuentaRepository, times(1)).findAll();
    }

    @Test
    void testGetCuentaById() {
        String numeroCuenta = "12345";
        CuentaEntity cuenta = new CuentaEntity();
        when(cuentaRepository.findById(numeroCuenta)).thenReturn(Optional.of(cuenta));

        ResponseEntity<CuentaEntity> result = cuentaController.getCuentaById(numeroCuenta);

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(cuenta, result.getBody());
        verify(cuentaRepository, times(1)).findById(numeroCuenta);
    }

    @Test
    void testCreateCuenta() {
        CuentaEntity cuenta = new CuentaEntity();
        ClienteEntity cliente = new ClienteEntity();
        cuenta.setCliente(cliente);
        when(clienteRepository.findById(cliente.getId())).thenReturn(Optional.of(cliente));
        when(cuentaRepository.save(cuenta)).thenReturn(cuenta);

        ResponseEntity<?> result = cuentaController.createCuenta(cuenta);

        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertEquals(cuenta, result.getBody());
        verify(clienteRepository, times(1)).findById(cliente.getId());
        verify(cuentaRepository, times(1)).save(cuenta);
    }

    @Test
    void testUpdateCuenta() {
        String numeroCuenta = "12345";
        CuentaEntity cuentaActualizada = new CuentaEntity();
        CuentaEntity cuenta = new CuentaEntity();
        when(cuentaRepository.findById(numeroCuenta)).thenReturn(Optional.of(cuenta));
        when(cuentaRepository.save(cuenta)).thenReturn(cuenta);

        ResponseEntity<CuentaEntity> result = cuentaController.updateCuenta(numeroCuenta, cuentaActualizada);

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(cuenta, result.getBody());
        verify(cuentaRepository, times(1)).findById(numeroCuenta);
        verify(cuentaRepository, times(1)).save(cuenta);
    }

    @Test
    void testDeleteCuenta() {
        String numeroCuenta = "12345";
        when(cuentaRepository.existsById(numeroCuenta)).thenReturn(true);

        ResponseEntity<Void> result = cuentaController.deleteCuenta(numeroCuenta);

        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());
        verify(cuentaRepository, times(1)).existsById(numeroCuenta);
        verify(cuentaRepository, times(1)).deleteById(numeroCuenta);
    }

}