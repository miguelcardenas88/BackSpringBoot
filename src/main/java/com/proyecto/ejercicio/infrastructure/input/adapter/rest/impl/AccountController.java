package com.proyecto.ejercicio.infrastructure.input.adapter.rest.impl;


import com.proyecto.ejercicio.application.input.port.AccountInputPort;
import com.proyecto.ejercicio.domain.Account;
import com.proyecto.ejercicio.domain.CustomerAccountInner;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
public class AccountController {

    //    @Autowired
    private final AccountInputPort accountInputPort;
//    @Autowired
//    private AccountMapper accountMapper;

    @GetMapping("/account")
    public ResponseEntity<List<Account>> getAccount() {
        return new ResponseEntity<>(accountInputPort.findAll(), HttpStatus.OK);

    }

    @GetMapping("/account/{accountNumber}")
    public ResponseEntity<Account> getAccountNumber(String accountNumber) {
        return new ResponseEntity<>(accountInputPort.getById(accountNumber),
                HttpStatus.OK);

    }

    @PostMapping("/account")
    public ResponseEntity<Account> postAccount(Account account) {
        return new ResponseEntity<>(accountInputPort.save(account),
                HttpStatus.CREATED);
    }

    @PutMapping("/account/{accountNumber}")
    public ResponseEntity<Account> putAccount(String accountNumber, Account account) {
        return new ResponseEntity<>(accountInputPort.update(accountNumber, account),
                HttpStatus.OK);
    }

    @DeleteMapping("/account/{accountNumber}")
    public ResponseEntity<Void> deleteAccount(String accountNumber) {

        return new ResponseEntity<>(accountInputPort.delete(accountNumber), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/account/customer/{dateStart}/{dateEnd}/{idCustumer}")
    public ResponseEntity<List<CustomerAccountInner>> getAccountCustomer(LocalDate dateStart, LocalDate dateEnd, String idCustumer) {
        return new ResponseEntity<>(
                accountInputPort.getAccountCustomer(dateStart, dateEnd, idCustumer),
                HttpStatus.OK);
    }
}
