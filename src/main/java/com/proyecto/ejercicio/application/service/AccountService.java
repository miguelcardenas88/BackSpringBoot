package com.proyecto.ejercicio.application.service;

import com.proyecto.ejercicio.application.input.port.AccountInputPort;
import com.proyecto.ejercicio.application.output.port.AccountOutputPort;
import com.proyecto.ejercicio.domain.Account;
import com.proyecto.ejercicio.domain.CustomerAccountInner;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
@AllArgsConstructor
public class AccountService implements AccountInputPort {
    private final AccountOutputPort accountOutputPort;


    @Override
    public List<Account> findAll() {
        var datos = accountOutputPort.findAll();
        //return accountOutputPort.findAll();
        return datos;
    }

    @Override
    public Void delete(String accountNumber) {
        return accountOutputPort.delete(accountNumber);
    }

    @Override
    public Account getById(String accountNumber) {
        return accountOutputPort.getById(accountNumber);
    }

    @Override
    public Account update(String accountNumber, Account customerDomain) {
        return accountOutputPort.update(accountNumber, customerDomain);
    }

    @Override
    public Account save(Account customerDomain) {
        return accountOutputPort.save(customerDomain);
    }

    @Override
    public List<CustomerAccountInner> getAccountCustomer(LocalDate dateStart, LocalDate dateEnd, String idCustumer) {
        return accountOutputPort.getAccountCustomer(dateStart, dateEnd, idCustumer);
    }
}
