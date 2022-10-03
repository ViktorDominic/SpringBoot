package com.stefanini.spotify.excepction;


public class AlbumNotFoundException extends Exception {

    public AlbumNotFoundException(Long id) {
        super("Album não encontrada com id:" + id);
    }
}
