package com.stefanini.spotify.excepction;

public class PlaylistNotFoundException extends Exception {
    
    public PlaylistNotFoundException (Long id) {
        super("Playlist não encontrada com id:"  +id);
    }
    
}
