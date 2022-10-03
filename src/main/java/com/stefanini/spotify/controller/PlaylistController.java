package com.stefanini.spotify.controller;

import com.stefanini.spotify.dto.PlaylistDTO;
import com.stefanini.spotify.excepction.AlbumNotFoundException;
import com.stefanini.spotify.excepction.ArtistaNotFoundException;
import com.stefanini.spotify.excepction.MusicaNotFoundException;
import com.stefanini.spotify.excepction.PlaylistNotFoundException;
import com.stefanini.spotify.mapper.PlaylistDTOService;
import com.stefanini.spotify.model.Playlist;
import com.stefanini.spotify.service.PlaylistService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(path = "/playlist")
public class PlaylistController {

    private final PlaylistService playlistService;
    private final PlaylistDTOService playlistDTOService;

    @Autowired

    public PlaylistController(PlaylistService playlistService, PlaylistDTOService playlistDTOService) {
        this.playlistService = playlistService;
        this.playlistDTOService = playlistDTOService;

    }

    @Autowired

    @GetMapping
    public List<Playlist> getAllPlaylist() {
        return playlistService.findAllPlaylist();
    }

    @PostMapping
    public String savePlaylist(@RequestBody PlaylistDTO playlist) throws MusicaNotFoundException, ArtistaNotFoundException, AlbumNotFoundException {

        Playlist newPlaylist = playlistDTOService.mapPlaylist(playlist);

        playlistService.save(newPlaylist);

        return newPlaylist.getNomePlaylist() + ", playlist salva com sucesso!";
    }

    @PutMapping
    public String updatePlaylist(@RequestBody PlaylistDTO playlist) throws AlbumNotFoundException, PlaylistNotFoundException, ArtistaNotFoundException, MusicaNotFoundException {
        Playlist newPlaylist = playlistDTOService.mapPlaylist(playlist);
        playlistService.save(newPlaylist);
        return ", playlist atualizado com sucesso!";
    }

    @DeleteMapping("{id}")
    public String deletePlaylistById(@PathVariable Long id, @RequestBody PlaylistDTO playlistDTO) throws PlaylistNotFoundException {
        Playlist playlist = playlistService.findById(id);
        playlistService.delete(playlist);
        return ", playlist deletado com sucesso!";
    }
}
