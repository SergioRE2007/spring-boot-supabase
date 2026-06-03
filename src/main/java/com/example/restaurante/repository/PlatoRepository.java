package com.example.restaurante.repository;

import com.example.restaurante.entity.Plato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "platos", collectionResourceRel = "platos")
public interface PlatoRepository extends JpaRepository<Plato, Long> {
}
