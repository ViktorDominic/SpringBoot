package com.stefanini.spotify.dto;


public class ArtistaDTO {
    
   private String nomeArtista; 
   
   public ArtistaDTO() {
       
   }

    public ArtistaDTO(String nomeArtista) {
        this.nomeArtista = nomeArtista;
    }

    public String getNomeArtista() {
        return nomeArtista;
    }

    public void setNomeArtista(String nomeArtista) {
        this.nomeArtista = nomeArtista;
    }
   
   

}
