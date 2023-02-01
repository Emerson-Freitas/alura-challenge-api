package br.com.alura.challenge.model.categoria;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroCategoria(
        @NotNull
        Long id,
        @NotBlank
        String titulo,
        @NotBlank
        String cor) {
}
