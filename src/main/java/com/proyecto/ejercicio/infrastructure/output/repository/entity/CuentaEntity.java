package com.proyecto.ejercicio.infrastructure.output.repository.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cuenta")
public class CuentaEntity {

    @Id
    private String numeroCuenta;

    @Column(nullable = false)
    private String tipoCuenta;

    @Column(name = "saldoinicial", nullable = false, precision = 18, scale = 2)
    private BigDecimal saldoinicial; 

    @Column(nullable = false)
    private boolean estado;

    @ManyToOne
    @JoinColumn(name = "idCliente", nullable = false)
    private ClienteEntity cliente;

  
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public BigDecimal getSaldoinicial() {
        return saldoinicial;
    }

    public void setSaldoinicial(BigDecimal saldoinicial) {
        this.saldoinicial = saldoinicial;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }


    public BigDecimal getSaldoInicial() {
        return saldoinicial;
    }

    public void setSaldoInicial(BigDecimal saldoInicial) {
        this.saldoinicial = saldoInicial;
    }
}
