package br.com.alura.challenge.model.categoria;

import br.com.alura.challenge.model.video.VideoModel;

import java.util.List;

public record CategoriaVideos(List<VideoModel> videos) {


    public CategoriaVideos(CategoriaModel categoria){
        this(categoria.getVideos());
    }

}
