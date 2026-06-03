package com.example.restaurante.controller;

import com.example.restaurante.entity.Categoria;
import com.example.restaurante.entity.Chef;
import com.example.restaurante.entity.Plato;
import com.example.restaurante.repository.CategoriaRepository;
import com.example.restaurante.repository.ChefRepository;
import com.example.restaurante.repository.PlatoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RestauranteWebController {

    private final ChefRepository chefRepository;
    private final CategoriaRepository categoriaRepository;
    private final PlatoRepository platoRepository;

    public RestauranteWebController(ChefRepository chefRepository,
                                    CategoriaRepository categoriaRepository,
                                    PlatoRepository platoRepository) {
        this.chefRepository = chefRepository;
        this.categoriaRepository = categoriaRepository;
        this.platoRepository = platoRepository;
    }

    @GetMapping("/")
    public String inicio() {
        return "redirect:/dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("totalPlatos", platoRepository.count());
        model.addAttribute("totalChefs", chefRepository.count());
        model.addAttribute("totalCategorias", categoriaRepository.count());
        model.addAttribute("platos", platoRepository.findAll());
        return "dashboard";
    }

    // --- CHEFS ---

    @GetMapping("/chefs")
    public String listarChefs(Model model) {
        model.addAttribute("chefs", chefRepository.findAll());
        return "chefs";
    }

    @GetMapping("/chefs/nuevo")
    public String nuevoChefForm(Model model) {
        model.addAttribute("chef", new Chef());
        return "chef-form";
    }

    @PostMapping("/chefs/guardar")
    public String guardarChef(@ModelAttribute Chef chef) {
        chefRepository.save(chef);
        return "redirect:/chefs";
    }

    // --- CATEGORIAS ---

    @GetMapping("/categorias")
    public String listarCategorias(Model model) {
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "categorias";
    }

    @GetMapping("/categorias/nuevo")
    public String nuevaCategoriaForm(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categoria-form";
    }

    @PostMapping("/categorias/guardar")
    public String guardarCategoria(@ModelAttribute Categoria categoria) {
        categoriaRepository.save(categoria);
        return "redirect:/categorias";
    }

    // --- PLATOS ---

    @GetMapping("/platos")
    public String listarPlatos(Model model) {
        model.addAttribute("platos", platoRepository.findAll());
        return "platos";
    }

    @GetMapping("/platos/nuevo")
    public String nuevoPlatoForm(Model model) {
        model.addAttribute("plato", new Plato());
        model.addAttribute("chefs", chefRepository.findAll());
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "plato-form";
    }

    @PostMapping("/platos/guardar")
    public String guardarPlato(@ModelAttribute Plato plato,
                               @RequestParam(required = false) Long chefId,
                               @RequestParam(required = false) Long categoriaId) {
        if (chefId != null) {
            Chef chef = chefRepository.findById(chefId).orElse(null);
            plato.setChef(chef);
        }
        if (categoriaId != null) {
            Categoria categoria = categoriaRepository.findById(categoriaId).orElse(null);
            plato.setCategoria(categoria);
        }
        platoRepository.save(plato);
        return "redirect:/platos";
    }
}
