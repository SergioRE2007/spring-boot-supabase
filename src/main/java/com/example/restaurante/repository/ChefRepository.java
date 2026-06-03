package com.example.restaurante.repository;

import com.example.restaurante.entity.Chef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Optional;

@RepositoryRestResource(path = "chefs", collectionResourceRel = "chefs")
public interface ChefRepository extends JpaRepository<Chef, Long> {

    @RestResource(path = "por-email", rel = "por-email")
    Optional<Chef> findByEmail(@Param("email") String email);
}
