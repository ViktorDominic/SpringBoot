package com.stefanini.spotify.mapper;

import com.stefanini.spotify.dto.PlaylistDTO;
import com.stefanini.spotify.excepction.ArtistaNotFoundException;
import com.stefanini.spotify.model.Artista;
import com.stefanini.spotify.model.Playlist;
import com.stefanini.spotify.service.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PlaylistDTOService {

    private final ArtistaService artistaService;

    @Autowired
    public PlaylistDTOService(ArtistaService artistaService) {
        this.artistaService = artistaService;
    }

    public Playlist mapPlaylist(PlaylistDTO playlist) {


        Playlist newPlaylist = new Playlist(null,
                playlist.getNomePlaylist(),
                playlist.getSinopsePlaylist(),
                playlist.getDuracaoPlaylist(),
                null);
        return newPlaylist;
    }
}
