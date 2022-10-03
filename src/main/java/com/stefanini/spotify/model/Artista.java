package com.stefanini.spotify.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@Table(name = "Artista")

public class Artista {

   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    public Artista() {
    }

    @Column(nullable = false)
    private String nomeArtista;

    @ManyToMany
   @JoinTable (name = "artista_musica", joinColumns = @JoinColumn(name ="artista_id"), inverseJoinColumns = @JoinColumn (name = "musica_id"))
    private List<Musica> musicas;

    public Artista(Long id, String nomeArtista, List<Musica> musicas) {
        this.id = id;
        this.nomeArtista = nomeArtista;
        this.musicas = musicas;
    }
    
        public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNomeArtista () {
        return nomeArtista; 
    }
    
    public void setNomeArtista (String nomeArtista) {
        this.nomeArtista = nomeArtista; 
    }
    
    public List <Musica> getMusica () {
        return musicas; 
    }
    
    public void setMusica (List <Musica> musicas) {
        this.musicas = musicas; 
    }
}
