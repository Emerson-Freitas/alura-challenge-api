package br.com.alura.challenge.model.categoria;

import br.com.alura.challenge.model.video.VideoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "Categoria")
@Table(name = "categorias")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class CategoriaModel {

    @Id
    private Long id;
    private String titulo;
    private String cor;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="categoria_id")
    private List<VideoModel> videos;

    public CategoriaModel(DadosCadastroCategoria dadosCadastroCategoria) {
        this.id = dadosCadastroCategoria.id();
        this.titulo = dadosCadastroCategoria.titulo();
        this.cor = dadosCadastroCategoria.cor();
    }

    public void atualizarDados(DadosAtualizadosCategoria dadosCategoria) {
        if(dadosCategoria.titulo() != null){
            this.titulo = dadosCategoria.titulo();
        }
        if(dadosCategoria.cor() != null){
            this.cor = dadosCategoria.cor();
        }
    }
}
