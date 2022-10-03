package com.stefanini.spotify.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import java.util.logging.Logger;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Musica")

public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
     public Musica() {
    }

    @Column(nullable = false)
    private String nomeMusica;

    @Column(nullable = false)
    private String duracaoMusica;

    @ManyToMany (mappedBy = "musicas")
    @JsonBackReference
    private List<Playlist> playlist;

    @ManyToMany (mappedBy = "musicas")
    @JsonBackReference
    private List <Artista> artista;

    @ManyToMany (mappedBy = "musicas")
    @JsonBackReference
    private List <Album> album;

    public Musica(Long id, String nomeMusica, String duracaoMusica,List <Artista> artista, List <Album> album, List <Playlist> playlist) {
        this.id = id;
        
        this.nomeMusica = nomeMusica;
        this.duracaoMusica = duracaoMusica;
        this.artista = artista;
        this.album = album;
        this.playlist = playlist;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeMusica() {
        return nomeMusica;
    }

    public void setNomeMusica(String nomeMusica) {
        this.nomeMusica = nomeMusica;
    }

    public String getDuracaoMusica() {
        return duracaoMusica;
    }

    public void setDuracaoMusica(String duracaoMusica) {
        this.duracaoMusica = duracaoMusica;
    }

    public List <Album> getAlbum() {
        return album;
    }

    public void setAlbum(List <Album> album) {
        this.album = album;
    }

    public List <Playlist> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(List <Playlist> playlist) {
        this.playlist = playlist;
    }

    public List <Artista> getArtista() {
        return artista;
    }

    public void setArtista(List <Artista> artista) {
        this.artista = artista;
    }

}
