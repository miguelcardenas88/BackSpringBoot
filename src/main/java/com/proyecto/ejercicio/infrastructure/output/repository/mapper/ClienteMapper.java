package com.proyecto.ejercicio.infrastructure.output.repository.mapper;

import com.proyecto.ejercicio.domain.Cliente;
import com.proyecto.ejercicio.domain.Cuenta;
import com.proyecto.ejercicio.infrastructure.output.repository.entity.ClienteEntity;
import com.proyecto.ejercicio.infrastructure.output.repository.entity.CuentaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClienteMapper {


    Cliente AccountEntityToAccount(ClienteEntity AccountEntity);
    List<Cliente> ListAccountEntityToAccount(List<ClienteEntity> AccountEntity);
    ClienteEntity AccountDomainToAccountEntity (Cliente AccountDomain);

    }
