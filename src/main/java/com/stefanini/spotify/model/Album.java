package com.stefanini.spotify.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import lombok.Data;


import javax.persistence.*;

@Entity
@Data
@Table(name = "Album")

public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
     public Album() {
    }

    @Column(nullable = false)
    private String nomeAlbum;

    @Column(nullable = false)
    private String tipoAlbum;

    @Column(nullable = false)
    private String dataAlbum;

    @Column(nullable = false)
    private String generoAlbum;

    @ManyToMany
    @JoinTable (name = "album_musica", joinColumns = @JoinColumn (name = "album_id"), inverseJoinColumns = @JoinColumn (name = "musica_id"))
    private List<Musica> musicas;

    public Album(Long id, String nomeAlbum, String tipoAlbum, String dataAlbum, String generoAlbum, List<Musica> musicas) {
        this.id = id;
        this.nomeAlbum = nomeAlbum;
        this.tipoAlbum = tipoAlbum;
        this.dataAlbum = dataAlbum;
        this.generoAlbum = generoAlbum;
        this.musicas = musicas; 
    }

}
