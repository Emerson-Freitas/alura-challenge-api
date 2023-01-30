package br.com.alura.challenge.model;

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
        String url) {
}
