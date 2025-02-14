package com.proyecto.ejercicio.infrastructure.output.repository.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "account")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class AccountEntity {

    private static final long serialVersionUID = 1L;
    @Id
    private Integer id;
    private String number;

    private String type;
    @Column(name = "initialBalance")
    private BigDecimal initialBalance;

    private Boolean status;
    @Column(name = "customerId")
    private String customerId;

}

