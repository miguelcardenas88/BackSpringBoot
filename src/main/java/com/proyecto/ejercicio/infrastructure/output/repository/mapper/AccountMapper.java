package com.proyecto.ejercicio.infrastructure.output.repository.mapper;

import com.proyecto.ejercicio.domain.Cuenta;
import com.proyecto.ejercicio.infrastructure.output.repository.entity.CuentaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING)
public interface AccountMapper {


    Cuenta AccountEntityToAccount(CuentaEntity AccountEntity);
    List<Cuenta> ListAccountEntityToAccount(List<CuentaEntity> AccountEntity);
    CuentaEntity AccountDomainToAccountEntity (Cuenta AccountDomain);

    }
