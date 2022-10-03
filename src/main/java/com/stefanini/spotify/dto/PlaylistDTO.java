package com.stefanini.spotify.dto;


public class PlaylistDTO {
    
    private String nomePlaylist; 
    private String sinopsePlaylist; 
    private String duracaoPlaylist; 
    


    public PlaylistDTO(String nomePlaylist, String sinopsePlaylist, String duracaoPlaylist) {
        this.nomePlaylist = nomePlaylist;
        this.sinopsePlaylist = sinopsePlaylist;
        this.duracaoPlaylist = duracaoPlaylist;
    }

    public PlaylistDTO (){
        
    }
    
    public String getNomePlaylist() {
        return nomePlaylist;
    }

    public void setNomePlaylist(String nomePlaylist) {
        this.nomePlaylist = nomePlaylist;
    }

    public String getSinopsePlaylist() {
        return sinopsePlaylist;
    }

    public void setSinopsePlaylist(String sinopsePlaylist) {
        this.sinopsePlaylist = sinopsePlaylist;
    }

    public String getDuracaoPlaylist() {
        return duracaoPlaylist;
    }

    public void setDuracaoPlaylist(String duracaoPlaylist) {
        this.duracaoPlaylist = duracaoPlaylist;
    }

    public Long getArtista() {
       return null;
    }

 
    
}
