package com.spring.docker1.service;

import com.spring.docker1.enums.EstadoTarea;
import com.spring.docker1.exception.TareaNotFoundException;
import com.spring.docker1.model.Tarea;
import com.spring.docker1.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaService {
    @Autowired
    private TareaRepository tareaRepository;

    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    //POST
    public Tarea save(Tarea tarea) {
        if(tareaRepository.existsById(tarea.getId())) throw new RuntimeException("Tarea already exists");
        return tareaRepository.save(tarea);
    }
    //GET
    public Tarea findById(Long id) {
        return tareaRepository.findById(id).orElseThrow(()-> new TareaNotFoundException("Tarea not found"));
    }
    public List<Tarea> findAll() {
        return (List<Tarea>) tareaRepository.findAll();
    }
    public Tarea getByEstado(EstadoTarea estado) {
        try{
            return tareaRepository.findByEstado(estado);
        }catch(TareaNotFoundException e){
            throw new TareaNotFoundException("Tarea not found");
        }
    }
    //PUT
    public Tarea update(Long id, Tarea tarea) {
        Tarea nTarea= findById(id);
        nTarea.setTitulo(tarea.getTitulo());
        nTarea.setDescripcion(tarea.getDescripcion());
        nTarea.setEstado(tarea.getEstado());
        nTarea.setCreationDate(tarea.getCreationDate());
        return tareaRepository.save(nTarea);
    }
    public Tarea cambiarEstado(Long id, EstadoTarea estado) {
        Tarea nTarea= findById(id);
        nTarea.setEstado(estado);
        return tareaRepository.save(nTarea);
    }
    //DELETE
    public void deleteById(Long id) {
        tareaRepository.deleteById(id);
    }
}
