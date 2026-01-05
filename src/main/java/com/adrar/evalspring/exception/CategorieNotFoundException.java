package com.adrar.evalspring.exception;

public class CategorieNotFoundException extends RuntimeException {
    public CategorieNotFoundException(Long id) {
        super("Categorie avec l'ID : " + id + " non trouvée!");
    }
}

