package com.adrar.evalspring.controller;

import com.adrar.evalspring.model.Produit;
import com.adrar.evalspring.service.ProduitService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produits")
@AllArgsConstructor
public class ProduitController {
    private final ProduitService produitService;

    //Route Get: liste touts les produits et leur categorie
    @GetMapping
    public ResponseEntity<List<Produit>> tousLesProduits(){
        List<Produit> produits = produitService.recupererTousLesProduits();
        return ResponseEntity.ok(produits);
    }

    //Route Get: produit par son id
    @GetMapping("/{id}")
    public ResponseEntity<Produit>produitParId(@PathVariable long id ){
        Produit produit= produitService.recupererProduitParId(id);
        return ResponseEntity.ok(produit);
    }

    //Ropute POST: ajoute un produit
    @PostMapping
    public ResponseEntity<Produit> ajouterProduit(@RequestBody Produit produit) {
        Produit produitCree = produitService.ajouterProduit(produit);
        return new ResponseEntity<>(produitCree, HttpStatus.CREATED);
    }
}
