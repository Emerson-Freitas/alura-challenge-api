package br.com.alura.challenge.model.usuario;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroUsuario(
        @NotBlank(message = "O login não pode ser vázio!")
        String login,
        @NotBlank(message = "A senha não pode ser vázia!")
        String senha) {
}
