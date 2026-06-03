package com.example.restaurante.controller;

import com.example.restaurante.repository.ChefRepository;
import com.example.restaurante.repository.CategoriaRepository;
import com.example.restaurante.repository.PlatoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DashboardController {

    private final ChefRepository chefRepository;
    private final CategoriaRepository categoriaRepository;
    private final PlatoRepository platoRepository;

    public DashboardController(ChefRepository chefRepository,
                               CategoriaRepository categoriaRepository,
                               PlatoRepository platoRepository) {
        this.chefRepository = chefRepository;
        this.categoriaRepository = categoriaRepository;
        this.platoRepository = platoRepository;
    }

    @GetMapping("/api/dashboard/resumen")
    public Map<String, Long> resumen() {
        Map<String, Long> datos = new HashMap<>();
        datos.put("platos", platoRepository.count());
        datos.put("chefs", chefRepository.count());
        datos.put("categorias", categoriaRepository.count());
        return datos;
    }
}
