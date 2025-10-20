package com.spring.docker1.mapper;

import com.spring.docker1.dto.TareaRequestDTO;
import com.spring.docker1.dto.TareaResponseDTO;
import com.spring.docker1.model.Tarea;

import java.time.LocalDate;

public class TareaMapper {
    public Tarea toEntity(TareaRequestDTO dto) {
        if (dto == null) return null;
        Tarea tarea = new Tarea();
        tarea.setTitulo(dto.getTitulo());
        tarea.setDescripcion(dto.getDescripcion());
        tarea.setEstado(dto.getEstado());
        tarea.setCreationDate(LocalDate.now());
        return tarea;
    }

    public TareaResponseDTO toResponse(Tarea tarea) {
        if (tarea == null) return null;
        TareaResponseDTO dto = new TareaResponseDTO();
        dto.setId(tarea.getId());
        dto.setTitulo(tarea.getTitulo());
        dto.setDescripcion(tarea.getDescripcion());
        dto.setEstado(tarea.getEstado());
        dto.setCreationDate(tarea.getCreationDate());
        return dto;
    }

}
