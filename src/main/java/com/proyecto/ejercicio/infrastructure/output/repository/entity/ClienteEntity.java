package com.proyecto.ejercicio.infrastructure.output.repository.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class ClienteEntity extends PersonaEntity {

    @Column(unique = true, nullable = false)
    private String clienteId;

    @Column(nullable = false)
    private String clave;

    @Column(nullable = false)
    private boolean estado;

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public String geteClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
