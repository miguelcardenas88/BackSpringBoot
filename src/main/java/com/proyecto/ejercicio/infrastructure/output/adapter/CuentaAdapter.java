package com.proyecto.ejercicio.infrastructure.output.adapter;

import com.proyecto.ejercicio.application.output.port.AccountOutputPort;
import com.proyecto.ejercicio.domain.Cuenta;
import com.proyecto.ejercicio.infrastructure.output.repository.CuentaRepository;
import com.proyecto.ejercicio.infrastructure.output.repository.entity.CuentaEntity;
import com.proyecto.ejercicio.infrastructure.output.repository.mapper.AccountMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class CuentaAdapter implements AccountOutputPort {
    private final CuentaRepository accountRepository;
    private final AccountMapper accountMapper;
    @Override
    public List<Cuenta> findAll() {

        return accountMapper.ListAccountEntityToAccount(accountRepository.findAll()) ;

    }

    @Override
    public Boolean delete(String accountNumber) {
        if (!accountRepository.existsById(accountNumber)) {
            return false;
        }
        accountRepository.deleteById(accountNumber);
        return true;
    }

    @Override
    public Cuenta getById(String accountNumber)
    {
        Optional<CuentaEntity> cuenta = accountRepository.findById(accountNumber);
        return cuenta.map(accountMapper::AccountEntityToAccount).orElse(null);
    }

    @Override
    public Cuenta update(String accountNumber, Cuenta customerDomain) {

        Optional<CuentaEntity> valor =   accountRepository.findById(accountNumber)
                .map(cuenta -> {
                    cuenta.setTipoCuenta(customerDomain.getTipoCuenta() != null ? customerDomain.getTipoCuenta() : cuenta.getTipoCuenta());
                    cuenta.setSaldoinicial(customerDomain.getSaldoinicial());
                    cuenta.setEstado(customerDomain.isEstado());
                    return accountRepository.save(cuenta);
                });
            return accountMapper.AccountEntityToAccount(valor.get());

    }

    @Override
    public Cuenta save(Cuenta customerDomain) {

        var cuenta= accountRepository.save(accountMapper.AccountDomainToAccountEntity(customerDomain));
         return  accountMapper.AccountEntityToAccount(cuenta);
    }


}

