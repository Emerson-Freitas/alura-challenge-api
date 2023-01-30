package br.com.alura.challenge.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Video")
@Table(name = "videos")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class VideoModel {

    @Id
    private Long id;

    private String titulo;

    private String descricao;

    private String url;

    public VideoModel(DadosCadastroVideo dadosCadastroVideo) {
        this.id = dadosCadastroVideo.id();
        this.titulo = dadosCadastroVideo.titulo();
        this.descricao = dadosCadastroVideo.descricao();
        this.url = dadosCadastroVideo.url();
    }

    public void atualizarDados(DadosAtualizadosVideo dadosAtualizadosVideo) {
        if(dadosAtualizadosVideo.titulo() != null){
            this.titulo = dadosAtualizadosVideo.titulo();
        }
        if(dadosAtualizadosVideo.descricao() != null){
            this.descricao = dadosAtualizadosVideo.descricao();
        }
        if(dadosAtualizadosVideo.url() != null){
            this.url = dadosAtualizadosVideo.url();
        }
    }
}
