package com.proyecto.ejercicio.application.input.port;

import com.proyecto.ejercicio.domain.Account;
import com.proyecto.ejercicio.domain.CustomerAccountInner;

import java.time.LocalDate;
import java.util.List;

public interface AccountInputPort {

    List<Account> findAll();

    Void delete(String accountNumber);

    Account getById(String accountNumber);

    Account update(String accountNumber, Account customerDomain);

    Account save(Account customerDomain);

    List<CustomerAccountInner> getAccountCustomer(LocalDate dateStart, LocalDate dateEnd, String idCustumer);
}
