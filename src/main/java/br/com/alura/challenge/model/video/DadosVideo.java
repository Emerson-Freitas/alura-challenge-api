package br.com.alura.challenge.model.video;

import org.springframework.data.domain.Pageable;

import java.util.List;

public record DadosVideo(Long id, String titulo, String descricao, String url, Long categoriaId) {

    public DadosVideo(VideoModel video){
        this(video.getId(), video.getTitulo(), video.getDescricao(), video.getUrl(), video.getCategoriaId());
    }

}
