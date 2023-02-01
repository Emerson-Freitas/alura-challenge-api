package br.com.alura.challenge.model.categoria;

import br.com.alura.challenge.model.video.VideoModel;

import java.util.List;

public record DadosCategoria(Long id, String titulo, String cor, List<VideoModel> videos) {

    public DadosCategoria(CategoriaModel categoria){
        this(categoria.getId(), categoria.getTitulo(), categoria.getCor(), categoria.getVideos());
    }

}
