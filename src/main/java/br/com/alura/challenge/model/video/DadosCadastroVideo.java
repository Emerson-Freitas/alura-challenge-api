package br.com.alura.challenge.model.video;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroVideo(
        @NotNull
        Long id,
        @NotBlank
        String titulo,
        @NotBlank
        String descricao,
        @NotBlank
        String url,
        Long categoriaId) {
}
