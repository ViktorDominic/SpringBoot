package com.stefanini.spotify.controller;

import com.stefanini.spotify.dto.MusicaDTO;
import com.stefanini.spotify.excepction.AlbumNotFoundException;
import com.stefanini.spotify.excepction.ArtistaNotFoundException;
import com.stefanini.spotify.excepction.MusicaNotFoundException;
import com.stefanini.spotify.excepction.PlaylistNotFoundException;
import com.stefanini.spotify.mapper.MusicaDTOService;
import com.stefanini.spotify.model.Musica;
import com.stefanini.spotify.service.MusicaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@RequestMapping(path= "/musica")
public class MusicaController {

    private final MusicaService musicaService;
    private final MusicaDTOService musicaDTOService;

    @Autowired

    public MusicaController(MusicaService musicaService, MusicaDTOService musicaDTOService) {
        this.musicaService = musicaService;
        this.musicaDTOService = musicaDTOService;

    }


    @Autowired

    @GetMapping
    public List<Musica> getAllMusica() {
        return musicaService.findAllMusica();
    }

    @PostMapping
    public String saveMusica(@RequestBody MusicaDTO musica) throws AlbumNotFoundException, PlaylistNotFoundException, ArtistaNotFoundException {
        Musica newMusica = musicaDTOService.mapMusica(musica);
        musicaService.save(newMusica);
        return newMusica.getNomeMusica() + ", musica salva com sucesso!";
    }

    @PutMapping
    public String updateMusica(@PathVariable Long id, @RequestBody MusicaDTO musica) throws AlbumNotFoundException, PlaylistNotFoundException, ArtistaNotFoundException, MusicaNotFoundException {
        Musica repo = musicaService.findById(id);
        repo = musicaDTOService.mapMusica(musica);
        repo.setId(id);
        musicaService.save(repo);
        return ", musica atualizada com sucesso!";
    }

    @DeleteMapping("{id}")
    public String deleteMusicaById(@PathVariable Long id, @RequestBody MusicaDTO musicaDTO) throws MusicaNotFoundException {
        Musica musica = musicaService.findById(id);
        musicaService.delete(musica);
        return ", musica deletada com sucesso!";
    }

}
