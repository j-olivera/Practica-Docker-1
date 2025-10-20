package com.spring.docker1.controller;

import com.spring.docker1.dto.TareaRequestDTO;
import com.spring.docker1.dto.TareaResponseDTO;
import com.spring.docker1.mapper.TareaMapper;
import com.spring.docker1.model.Tarea;
import com.spring.docker1.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/tarea")
public class TareaController {

    @Autowired
    private TareaService tareaService;
    @Autowired
    private TareaMapper tareaMapper;

    //POST
    @PostMapping("/create")
    public ResponseEntity<TareaResponseDTO> putTarea(@RequestBody TareaRequestDTO tareaRequestDTO){
        Tarea tarea = tareaMapper.toEntity(tareaRequestDTO);
        Tarea nuevaTarea = tareaService.save(tarea);
        TareaResponseDTO tareaResponseDTO = tareaMapper.toResponse(nuevaTarea);
        return ResponseEntity.status(HttpStatus.CREATED).body(tareaResponseDTO);
    }
    //GET
    @GetMapping("/id/{id}")
    public ResponseEntity<TareaResponseDTO> getTareaById(@PathVariable Long id){
        Tarea tarea = tareaService.findById(id);
        TareaResponseDTO tareaResponseDTO = tareaMapper.toResponse(tarea);
        return ResponseEntity.status(HttpStatus.OK).body(tareaResponseDTO);
    }
    @GetMapping("/allTares")
    public ResponseEntity<List<TareaResponseDTO>> getAllTareas(){
        List<Tarea> tareas = tareaService.findAll();
        List<TareaResponseDTO> tareaResponseDTO = tareas.stream()
                .map(tareaMapper::toResponse)
                .toList();
        return ResponseEntity.ok(tareaResponseDTO);
    }
    //
    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteTareaById(@PathVariable Long id){
        Tarea tarea = tareaService.findById(id);
        if(tarea != null){
            tareaService.deleteById(id);
            return ResponseEntity.ok("Tarea has been deleted");
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
