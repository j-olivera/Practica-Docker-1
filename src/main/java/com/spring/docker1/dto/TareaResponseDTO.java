package com.spring.docker1.dto;

import com.spring.docker1.enums.EstadoTarea;

import java.time.LocalDate;

public class TareaResponseDTO {

    private String titulo;
    private String descripcion;
    private EstadoTarea estado;

    public TareaResponseDTO(String titulo, String descripcion, EstadoTarea estado) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
    }
    public TareaResponseDTO() {}

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

    public void setId(Long id) {
    }

    public void setCreationDate(LocalDate creationDate) {
    }
}
