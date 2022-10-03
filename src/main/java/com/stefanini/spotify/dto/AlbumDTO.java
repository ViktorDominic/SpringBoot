package com.stefanini.spotify.dto;

public class AlbumDTO {

    private String nomeAlbum;
    private String tipoAlbum;
    private String dataAlbum;
    private String generoAlbum;

    public AlbumDTO() {

    }

    public AlbumDTO(String nomeAlbum, String tipoAlbum, String dataAlbum, String generoAlbum) {
        this.nomeAlbum = nomeAlbum;
        this.tipoAlbum = tipoAlbum;
        this.dataAlbum = dataAlbum;
        this.generoAlbum = generoAlbum;
    }

    public String getNomeAlbum() {
        return nomeAlbum;
    }

    public void setNomeAlbum(String nomeAlbum) {
        this.nomeAlbum = nomeAlbum;
    }

    public String getTipoAlbum() {
        return tipoAlbum;
    }

    public void setTipoAlbum(String tipoAlbum) {
        this.tipoAlbum = tipoAlbum;
    }

    public String getDataAlbum() {
        return dataAlbum;
    }

    public void setDataAlbum(String dataAlbum) {
        this.dataAlbum = dataAlbum;
    }

    public String getGeneroAlbum() {
        return generoAlbum;
    }

    public void setGeneroAlbum(String generoAlbum) {
        this.generoAlbum = generoAlbum;
    }

}
