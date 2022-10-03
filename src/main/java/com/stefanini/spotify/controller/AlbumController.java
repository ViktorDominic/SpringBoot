package com.stefanini.spotify.controller;

import com.stefanini.spotify.dto.AlbumDTO;
import com.stefanini.spotify.excepction.AlbumNotFoundException;
import com.stefanini.spotify.excepction.ArtistaNotFoundException;
import com.stefanini.spotify.excepction.MusicaNotFoundException;
import com.stefanini.spotify.excepction.PlaylistNotFoundException;
import com.stefanini.spotify.mapper.AlbumDTOService;
import com.stefanini.spotify.model.Album;
import com.stefanini.spotify.service.AlbumService;
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
@RequestMapping(path = "/album")
public class AlbumController {

    private final AlbumService albumService;
    private final AlbumDTOService albumDTOService;

    @Autowired

    public AlbumController(AlbumService albumService, AlbumDTOService albumDTOService) {
        this.albumService = albumService;
        this.albumDTOService = albumDTOService;

    }

    @Autowired

    @GetMapping
    public List<Album> getAllAlbum() {
        return albumService.findAllAlbum();
    }

    @PostMapping
    public String saveAlbum(@RequestBody AlbumDTO album) throws ArtistaNotFoundException, PlaylistNotFoundException, MusicaNotFoundException {

        Album newAlbum = albumDTOService.mapAlbum(album);

        albumService.save(newAlbum);

        return newAlbum.getNomeAlbum() + ", album salvo com sucesso!";
    }

    @PutMapping("{id}")
    public String updateAlbum(@PathVariable Long id, @RequestBody AlbumDTO album) throws AlbumNotFoundException, PlaylistNotFoundException, ArtistaNotFoundException, MusicaNotFoundException {
        Album repo = albumService.findById(id);
        repo = albumDTOService.mapAlbum(album);
        repo.setId(id);
        albumService.save(repo);
        return ", album atualizado com sucesso!";
    }

    @DeleteMapping("{id}")
    public String deleteAlbumById(@PathVariable Long id, @RequestBody AlbumDTO albumDTO) throws AlbumNotFoundException {
        Album album = albumService.findById(id);
        albumService.delete(album);
        return ", album deletado com sucesso!";
    }

}
