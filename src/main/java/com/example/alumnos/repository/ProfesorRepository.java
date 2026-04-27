package com.example.alumnos.repository;

import com.example.alumnos.entity.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import java.util.Optional;

// Spring Data REST expone esto en /api/profesores automaticamente
@RepositoryRestResource(path = "profesores", collectionResourceRel = "profesores")
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {

    // busqueda por email en /api/profesores/search/por-email?email=...
    @RestResource(path = "por-email", rel = "por-email")
    Optional<Profesor> findByEmail(@Param("email") String email);
}
