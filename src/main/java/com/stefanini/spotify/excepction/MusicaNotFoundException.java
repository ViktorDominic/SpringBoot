package com.stefanini.spotify.excepction;

public class MusicaNotFoundException extends Exception {

    public MusicaNotFoundException(Long id) {
        super("Musica não encontrada com id:" + id);
    }
}