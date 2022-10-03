package com.stefanini.spotify.service;

import com.stefanini.spotify.excepction.AlbumNotFoundException;
import com.stefanini.spotify.model.Album;
import com.stefanini.spotify.repository.AlbumRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {

    private final AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public List<Album> findAllAlbum() {
        return albumRepository.findAll();
    }

    public Album findById(Long id) throws AlbumNotFoundException {
        return albumRepository.findById(id)
                .orElseThrow(() -> new AlbumNotFoundException(id));
    }

    public Album save(Album album) {
        return albumRepository.save(album);
    }

    public void delete(Album album) {
        albumRepository.delete(album);
    }
}
