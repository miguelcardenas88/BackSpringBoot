package com.proyecto.ejercicio.application.service;

import com.proyecto.ejercicio.application.output.port.AccountOutputPort;
import com.proyecto.ejercicio.domain.Cuenta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AccountServiceTest {

    @Mock
    private AccountOutputPort accountOutputPort;

    @InjectMocks
    private AccountService accountService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        List<Cuenta> accounts = Arrays.asList(new Cuenta(), new Cuenta());
        when(accountOutputPort.findAll()).thenReturn(accounts);

        List<Cuenta> result = accountService.findAll();

        assertEquals(accounts, result);
        verify(accountOutputPort, times(1)).findAll();
    }

    @Test
    void testDelete() {
        String accountNumber = "12345";
        accountService.delete(accountNumber);

        verify(accountOutputPort, times(1)).delete(accountNumber);
    }

    @Test
    void testGetById() {
        String accountNumber = "12345";
        Cuenta account = new Cuenta();
        when(accountOutputPort.getById(accountNumber)).thenReturn(account);

        Cuenta result = accountService.getById(accountNumber);

        assertEquals(account, result);
        verify(accountOutputPort, times(1)).getById(accountNumber);
    }

    @Test
    void testUpdate() {
        String accountNumber = "12345";
        Cuenta account = new Cuenta();
        when(accountOutputPort.update(accountNumber, account)).thenReturn(account);

        Cuenta result = accountService.update(accountNumber, account);

        assertEquals(account, result);
        verify(accountOutputPort, times(1)).update(accountNumber, account);
    }

    @Test
    void testSave() {
        Cuenta account = new Cuenta();
        when(accountOutputPort.save(account)).thenReturn(account);

        Cuenta result = accountService.save(account);

        assertEquals(account, result);
        verify(accountOutputPort, times(1)).save(account);
    }



}