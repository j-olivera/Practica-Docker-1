package com.spring.docker1.dto;

import com.spring.docker1.enums.EstadoTarea;
import jakarta.persistence.Column;

import java.time.LocalDate;

public class TareaRequestDTO {
    private Long id;
    private String titulo;
    private String descripcion;
    private EstadoTarea estado;
    private LocalDate creationDate;

    public TareaRequestDTO(Long id, String titulo, String descripcion, EstadoTarea estado, LocalDate creationDate) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.creationDate = creationDate;
    }

    public TareaRequestDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EstadoTarea getEstado() {
        return estado;
    }

    public void setEstado(EstadoTarea estado) {
        this.estado = estado;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = null;
    }
}
