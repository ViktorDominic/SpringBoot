package com.stefanini.spotify.service;

import com.stefanini.spotify.excepction.PlaylistNotFoundException;
import com.stefanini.spotify.model.Playlist;
import com.stefanini.spotify.repository.PlaylistRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service

public class PlaylistService {

    private final PlaylistRepository playlistRepository;

    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    public List<Playlist> findAllPlaylist() {
        return playlistRepository.findAll();
    }

    public Playlist findById(Long id) throws PlaylistNotFoundException {
        return playlistRepository.findById(id)
                .orElseThrow(() -> new PlaylistNotFoundException(id));
    }

    public Playlist save(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    public void delete(Playlist playlist) {
        playlistRepository.delete(playlist);
    }
}
