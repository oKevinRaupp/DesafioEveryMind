package com.kevinraupp.nunessports.DesafioEveryMind.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Object id) {
        super("Produto não encontrado, id = " + id);
    }
}