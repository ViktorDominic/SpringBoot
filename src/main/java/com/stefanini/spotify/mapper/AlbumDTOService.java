package com.stefanini.spotify.mapper;

import com.stefanini.spotify.dto.AlbumDTO;
import com.stefanini.spotify.model.Album;
import org.springframework.stereotype.Service;


@Service
public class AlbumDTOService {

    public Album mapAlbum(AlbumDTO album) {
        Album newAlbum = new Album(null, album.getNomeAlbum(), album.getTipoAlbum(), album.getDataAlbum(), album.getGeneroAlbum(), null);
        return newAlbum;
    }
}
