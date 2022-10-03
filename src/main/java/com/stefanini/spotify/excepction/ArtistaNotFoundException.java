package com.stefanini.spotify.excepction;

public class ArtistaNotFoundException extends Exception {

    public ArtistaNotFoundException(Long id) {
        super("Artista não encontrada com id:" + id);
    }
}