package com.stefanini.spotify.dto;

public class MusicaDTO {

    String nomeMusica;
    String duracaoMusica;

    public MusicaDTO() {
    }

    public MusicaDTO(String nomeMusica, String duracaoMusica) {
        this.nomeMusica = nomeMusica;
        this.duracaoMusica = duracaoMusica;
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

    public Long getArtista() {
        return null;
    }

    public Long getPlaylist() {
      return null;
    }

    public Long getAlbum() {
        return null;
    }

}
