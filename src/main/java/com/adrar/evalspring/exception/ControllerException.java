package com.adrar.evalspring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerException extends RuntimeException {


    // Produit exception
    @ExceptionHandler({ProduitException.class, ProduitNotFoundException.class})
    public ResponseEntity<String> handleProduitException(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // Cat exception
    @ExceptionHandler({CategorieException.class, CategorieNotFoundException.class})
    public ResponseEntity<String> handleCategorieException(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    //pas sur
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        return new ResponseEntity<>("Erreur serveur: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
