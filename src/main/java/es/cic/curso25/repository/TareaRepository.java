package es.cic.curso25.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.cic.curso25.model.Tarea;


public interface TareaRepository extends JpaRepository<Tarea, Long> {

}