package com.proyecto.ejercicio.infrastructure.output.repository.mapper;

import com.proyecto.ejercicio.domain.Movimiento;
import com.proyecto.ejercicio.infrastructure.output.repository.entity.MovimientoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING)
public interface MovimientoMapper {

    Movimiento AccountEntityToAccount(MovimientoEntity AccountEntity);
    List<Movimiento> ListAccountEntityToAccount(List<MovimientoEntity> AccountEntity);
    MovimientoEntity AccountDomainToAccountEntity (Movimiento AccountDomain);

    }
