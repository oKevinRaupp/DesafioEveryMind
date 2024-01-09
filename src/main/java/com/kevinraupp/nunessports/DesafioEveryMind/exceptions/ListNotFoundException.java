package com.kevinraupp.nunessports.DesafioEveryMind.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.NotActiveException;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ListNotFoundException extends RuntimeException {
    public ListNotFoundException() {
        super("Lista de produtos não encontrada, verifique sua requisição!");
    }
}