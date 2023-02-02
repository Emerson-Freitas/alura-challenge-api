package br.com.alura.challenge.model.categoria;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroCategoria(
        @NotNull
        Long id,
        @NotBlank(message = "O título é obrigatório")
        String titulo,
        @NotBlank(message = "A cor é obrigatória")
        String cor) {
}
