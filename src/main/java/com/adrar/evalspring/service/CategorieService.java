package com.adrar.evalspring.service;


import com.adrar.evalspring.exception.CategorieException;
import com.adrar.evalspring.exception.CategorieNotFoundException;
import com.adrar.evalspring.model.Categorie;
import com.adrar.evalspring.repository.CategorieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategorieService {
    private CategorieRepository categorieRepository;

    //ajouter un catégorie
    public Categorie ajouterCategorie(Categorie categorie){
        if (categorie.getLibele() == null || categorie.getLibele().trim().length() < 2) {
            throw new CategorieException("Le libellé de la catégorie doit contenir au moins 2 caractères.");
        }
        return categorieRepository.save(categorie);
    }

    //lister toutes les categories
    public List<Categorie> recupererToutesLesCategories() {
        return (List<Categorie>) categorieRepository.findAll();
    }

    //Recuperer une Categorie par son Id
    public Categorie recupCategorieParId(Long id) {
        if (id == null || id <= 0) {
            throw new CategorieException("id de la catégorie invalide / non trouvé.");
        }
        return categorieRepository.findById(id).orElseThrow(() -> new CategorieNotFoundException(id));
    }

}
