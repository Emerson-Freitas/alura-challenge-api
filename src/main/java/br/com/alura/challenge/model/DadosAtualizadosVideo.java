package br.com.alura.challenge.model;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizadosVideo(
        @NotNull
        Long id,
        String titulo,
        String descricao,
        String url) {
}
