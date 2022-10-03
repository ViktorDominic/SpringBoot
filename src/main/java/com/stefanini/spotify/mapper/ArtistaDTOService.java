package com.stefanini.spotify.mapper;

import com.stefanini.spotify.dto.ArtistaDTO;
import com.stefanini.spotify.excepction.MusicaNotFoundException;
import com.stefanini.spotify.model.Artista;
import org.springframework.stereotype.Service;

@Service
public class ArtistaDTOService {

    public Artista mapArtista(ArtistaDTO artista) {
        Artista newArtista = new Artista (null, artista.getNomeArtista(), null);
                return newArtista;
    }
}
