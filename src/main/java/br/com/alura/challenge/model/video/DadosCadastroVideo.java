package br.com.alura.challenge.model.video;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroVideo(
        @NotNull
        Long id,
        @NotBlank(message = "O título é obrigatório")
        String titulo,
        @NotBlank(message = "A descrição é obrigatória")
        String descricao,
        @NotBlank(message = "A url é obrigatória")
        String url,
        Long categoriaId) {
}
