package com.adrar.evalspring.service;


import com.adrar.evalspring.exception.ProduitException;
import com.adrar.evalspring.exception.ProduitNotFoundException;
import com.adrar.evalspring.model.Produit;
import com.adrar.evalspring.repository.ProduitRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProduitService {
    private ProduitRepository produitRepository;

    public Produit ajouterProduit(Produit produit) {
        if (produit.getNom() == null || produit.getNom().trim().length() < 2) {
            throw new ProduitException("Le nom du produit doit contenir au moins 2 caractères.");
        }
        if (produit.getPrix() == null || produit.getPrix() <= 0) {
            throw new ProduitException("Le prix du produit doit être supérieur à zéro.");
        }
        return produitRepository.save(produit);
    }

    public Produit recupererProduitParId(Long id) {
        if (id == null || id <= 0) {
            throw new ProduitException("L'id du produit est faux : "+ id);
        }
        return produitRepository.findById(id).orElseThrow(() -> new ProduitNotFoundException(id));
    }

    public List<Produit> recupererTousLesProduits() {
        return (List<Produit>) produitRepository.findAll();
    }
}
