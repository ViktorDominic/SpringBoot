package com.stefanini.spotify.mapper;

import com.stefanini.spotify.dto.MusicaDTO;
import com.stefanini.spotify.excepction.AlbumNotFoundException;
import com.stefanini.spotify.excepction.ArtistaNotFoundException;
import com.stefanini.spotify.excepction.PlaylistNotFoundException;
import com.stefanini.spotify.model.Album;
import com.stefanini.spotify.model.Artista;
import com.stefanini.spotify.model.Musica;
import com.stefanini.spotify.model.Playlist;
import com.stefanini.spotify.service.AlbumService;
import com.stefanini.spotify.service.ArtistaService;
import com.stefanini.spotify.service.PlaylistService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicaDTOService {

    private final AlbumService albumService;
    private final ArtistaService artistaService;
    private final PlaylistService playlistService;

    @Autowired
    public MusicaDTOService(AlbumService albumService, ArtistaService artistaService, PlaylistService playlistService) {
        this.albumService = albumService;
        this.artistaService = artistaService;
        this.playlistService = playlistService;
    }
    
     public Musica mapMusica(MusicaDTO musica) throws AlbumNotFoundException,  ArtistaNotFoundException, PlaylistNotFoundException{



       List <Album> album = albumService.findAllAlbum();
        List <Artista> artista = artistaService.findAllArtista();
        List <Playlist> playlist = playlistService.findAllPlaylist();
        



       Musica newMusica = new Musica(null,
                musica.getNomeMusica(),
                musica.getDuracaoMusica(),
                artista,
                album,
                playlist);



       return newMusica;
    }

}
