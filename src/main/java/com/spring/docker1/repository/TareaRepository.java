package com.spring.docker1.repository;

import com.spring.docker1.enums.EstadoTarea;
import com.spring.docker1.model.Tarea;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepository extends CrudRepository<Tarea, Long> {

    Tarea findByEstado(EstadoTarea estado);
}
