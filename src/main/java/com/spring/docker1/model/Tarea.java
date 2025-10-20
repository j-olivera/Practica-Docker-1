package com.spring.docker1.model;

import com.spring.docker1.enums.EstadoTarea;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="tareas")
public class Tarea {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name="Titulo")
    private String titulo;
    @Column(name="Descripción")
    private String descripcion;
    @Column(name="Estado")
    private EstadoTarea estado;
    private LocalDate creationDate;

    public Tarea(Long id, String titulo, String descripcion, EstadoTarea estado, LocalDate creationDate) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.creationDate = creationDate;
    }

    public Tarea() {
    }

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
        this.creationDate = creationDate;
    }
}
