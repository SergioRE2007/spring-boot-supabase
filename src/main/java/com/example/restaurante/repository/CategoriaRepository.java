package com.example.restaurante.repository;

import com.example.restaurante.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "categorias", collectionResourceRel = "categorias")
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
