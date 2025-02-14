package com.proyecto.ejercicio.infrastructure.output.repository.mapper;

import com.proyecto.ejercicio.domain.Account;
import com.proyecto.ejercicio.domain.CustomerAccountInner;
import com.proyecto.ejercicio.infrastructure.output.repository.entity.AccountEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {

 
    Account AccountEntityToAccount(AccountEntity  AccountEntity);


    AccountEntity AccountDomainToAccountEntity (Account AccountDomain);

    CustomerAccountInner CustomerAccountInnerDomainToCustomerAccountInner (CustomerAccountInner CustomerAccountInnerDomain);
}
