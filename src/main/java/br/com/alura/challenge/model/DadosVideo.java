package br.com.alura.challenge.model;

public record DadosVideo(Long id, String titulo, String descricao, String url) {

    public DadosVideo(VideoModel video){
        this(video.getId(), video.getTitulo(), video.getDescricao(), video.getUrl());
    }
}
