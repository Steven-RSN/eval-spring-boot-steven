package com.adrar.evalspring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Entity
@Table(name="categories")
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Libellé de la categorie est obligatoire !")
    @Length(min = 2, message = "Le libellé doit contenir au minimum 2 caractères")
    @Column(nullable = false)
    private String libele;

    // Relation OneToMany avec Produit
    @OneToMany(mappedBy = "categorie")
    private List<Produit> produits;

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibele() {
        return libele;
    }

    public void setLibele(String libele) {
        this.libele = libele;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }
}

