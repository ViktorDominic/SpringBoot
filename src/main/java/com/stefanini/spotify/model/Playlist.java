package com.stefanini.spotify.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Playlist")

public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
     public Playlist() {
    }

    @Column(nullable = false)
    private String nomePlaylist;

    @Column(nullable = false)
    private String sinopsePlaylist;

    @Column(nullable = false)
    private String duracaoPlaylist;

    
    @ManyToMany
     @JoinTable (name = "playlist_musica", joinColumns = @JoinColumn(name = "playlist_id"), inverseJoinColumns = @JoinColumn(name = "musica_id"))
    private List<Musica> musicas;

    public Playlist(Long id, String nomePlaylist, String sinopsePlaylist, String duracaoPlaylist, List<Musica> musicas) {
        this.id = id;
        this.nomePlaylist = nomePlaylist;
        this.sinopsePlaylist = sinopsePlaylist;
        this.duracaoPlaylist = duracaoPlaylist;
        this.musicas = musicas;
    }
    
    
        public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
     public String getNomePlaylist () {
        return nomePlaylist; 
    }
    
    public void setNomePlaylist (String nomePlaylist) {
        this.nomePlaylist = nomePlaylist; 
    }
    
    
         public String getSinopsePlaylist () {
        return sinopsePlaylist; 
    }
    
    public void setSinopsePlaylist (String sinopsePlaylist) {
        this.sinopsePlaylist = sinopsePlaylist; 
    }

       public String getDuracaoPlaylist () {
        return duracaoPlaylist; 
    }
    
    public void setDuracaoPlaylist (String duracaoPlaylist) {
        this.duracaoPlaylist = duracaoPlaylist; 
    }

     public List <Musica> getMusica () {
        return musicas; 
    }
    
    public void setMusica (List <Musica> musicas) {
        this.musicas = musicas; 
    }
    
}
