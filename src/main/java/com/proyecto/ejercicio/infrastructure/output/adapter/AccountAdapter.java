package com.proyecto.ejercicio.infrastructure.output.adapter;

import com.proyecto.ejercicio.application.output.port.AccountOutputPort;
import com.proyecto.ejercicio.domain.Account;
import com.proyecto.ejercicio.domain.CustomerAccountInner;
import com.proyecto.ejercicio.infrastructure.output.repository.AccountRepository;
import com.proyecto.ejercicio.infrastructure.output.repository.mapper.AccountMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Component
@AllArgsConstructor
public class AccountAdapter implements AccountOutputPort {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    @Override
    public List<Account> findAll() {
        return accountRepository.findAll().stream().map(accountMapper::AccountEntityToAccount).toList();
    }

    @Override
    public Void delete(String accountNumber) {
        return null;
    }

    @Override
    public Account getById(String accountNumber) {
        return null;
    }

    @Override
    public Account update(String accountNumber, Account customerDomain) {
        return null;
    }

    @Override
    public Account save(Account customerDomain) {
        return null;
    }

    @Override
    public List<CustomerAccountInner> getAccountCustomer(LocalDate dateStart, LocalDate dateEnd, String idCustumer) {
        return List.of();
    }
//    @Autowired
//    private AccountRepository accountRepository;
//    @Autowired
//    private AccountMapper accountMapper;
//    @Override
//    public Flux<AccountDomain> findAll() {
//        return accountRepository.findAll().map(accountMapper::AccountEntityToAccountDomain);
//    }
//    @Override
//    public Mono<Void> delete(String id) {
//        return accountRepository.delete(id);
//    }
//
//    @Override
//    public Mono<AccountDomain> getById(String id) {
//        return accountRepository.getById(id)
//                .map(accountMapper::AccountEntityToAccountDomain);
//    }
//    public AccountDomain AccountEntityToAccountDomain(AccountEntity accountEntity){
//        System.out.print("");
//        return null;
//    }
//    @Override
//    public Mono<AccountDomain> update(String id, AccountDomain customerDomain) {
//        return accountRepository.update(id, accountMapper.AccountDomainToAccountEntity(customerDomain)
//        ).map(accountMapper::AccountEntityToAccountDomain);
//    }
//
//    @Override
//    public Mono<AccountDomain> save(AccountDomain customerDomain) {
//        return accountRepository.save(accountMapper.AccountDomainToAccountEntity(customerDomain)
//        ).map(accountMapper::AccountEntityToAccountDomain);
//    }
//
//    @Override
//    public Flux<AccountDomain> getByIdCustomer(String id) {
//        return accountRepository.getByIdCustomer(id
//        ).map(accountMapper::AccountEntityToAccountDomain);
//    }
}

