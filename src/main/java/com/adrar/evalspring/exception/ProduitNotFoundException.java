package com.adrar.evalspring.exception;

public class ProduitNotFoundException extends RuntimeException {
    public ProduitNotFoundException(Long id) {
        super("Produit non trouvé avec l'id :" + id);
    }
}
