package com.stefanini.spotify.controller;

import com.stefanini.spotify.dto.ArtistaDTO;
import com.stefanini.spotify.excepction.AlbumNotFoundException;
import com.stefanini.spotify.excepction.ArtistaNotFoundException;
import com.stefanini.spotify.excepction.MusicaNotFoundException;
import com.stefanini.spotify.excepction.PlaylistNotFoundException;
import com.stefanini.spotify.mapper.ArtistaDTOService;
import com.stefanini.spotify.model.Artista;
import com.stefanini.spotify.service.ArtistaService;
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
@RequestMapping(path="/artista")
public class ArtistaController {

    private final ArtistaService artistaService;
    private final ArtistaDTOService artistaDTOService;

    @Autowired

    public ArtistaController(ArtistaService artistaService, ArtistaDTOService artistaDTOService) {
        this.artistaService = artistaService;
        this.artistaDTOService = artistaDTOService;

    }

    @Autowired

    @GetMapping
    public List<Artista> getAllArtista() {
        return artistaService.findAllArtista();
    }

    @PostMapping
    public String saveArtista(@RequestBody ArtistaDTO artista) {
        Artista newArtista = artistaDTOService.mapArtista(artista);
        artistaService.save(newArtista);
        return newArtista.getNomeArtista() + ", artista salvo com sucesso!";
    }

    @PutMapping("{id}")
    public String updateArtista(@PathVariable Long id, @RequestBody ArtistaDTO artista) throws ArtistaNotFoundException {
        Artista repo = artistaService.findById(id);
        repo = artistaDTOService.mapArtista(artista);
        repo.setId(id);
        artistaService.save(repo);
        return ", artista atualizado com sucesso!";
    }

   @DeleteMapping("{id}")
   public String deleteArtistaById(@PathVariable Long id, @RequestBody ArtistaDTO artistaDTO) throws ArtistaNotFoundException {
       Artista artista = artistaService.findById(id);
       artistaService.delete(artista);
       return "Artista deletado com sucesso!";
  }

}
