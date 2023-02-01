package br.com.alura.challenge.model.categoria;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizadosCategoria(
        @NotNull
        Long id,
        String titulo,
        String cor) {
}
