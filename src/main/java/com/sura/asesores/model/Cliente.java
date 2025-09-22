package com.sura.asesores.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    @Enumerated(EnumType.STRING)
    private EstadoAfiliacion estadoAfiliacion;
    private LocalDateTime fechaRegistro;

    public Cliente() {
        this.fechaRegistro = LocalDateTime.now();
        this.estadoAfiliacion = EstadoAfiliacion.INGRESADO;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public EstadoAfiliacion getEstadoAfiliacion() { return estadoAfiliacion; }
    public void setEstadoAfiliacion(EstadoAfiliacion estadoAfiliacion) { this.estadoAfiliacion = estadoAfiliacion; }
    public LocalDateTime getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDateTime fechaRegistro) { this.fechaRegistro = fechaRegistro; }
}
