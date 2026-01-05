package com.adrar.evalspring.controller;

import com.adrar.evalspring.model.Categorie;
import com.adrar.evalspring.service.CategorieService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class CategorieController {

    private final CategorieService categorieService;

    //Route GET: recuperer toutes les catégories
    @GetMapping
    public ResponseEntity<List<Categorie>> toutesLesCategories() {
        List<Categorie> categories = categorieService.recupererToutesLesCategories();
        return ResponseEntity.ok(categories);
    }

    //Route GET: recuperer une catégorie par ID
    @GetMapping("/{id}")
    public ResponseEntity<Categorie> categorieParId(@PathVariable Long id) {
        Categorie categorie = categorieService.recupCategorieParId(id);
        return ResponseEntity.ok(categorie);
    }

    //Route POST: ajout une catégorie
    @PostMapping
    public ResponseEntity<Categorie> ajouterCategorie(@RequestBody Categorie categorie) {
        Categorie categorieCree = categorieService.ajouterCategorie(categorie);
        return new ResponseEntity<>(categorieCree, HttpStatus.CREATED);
    }

}