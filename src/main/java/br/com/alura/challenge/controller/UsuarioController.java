package br.com.alura.challenge.controller;

import br.com.alura.challenge.model.usuario.DadosCadastroUsuario;
import br.com.alura.challenge.model.usuario.UsuarioModel;
import br.com.alura.challenge.repository.UsuarioRepository;
import br.com.alura.challenge.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarUsuario(@RequestBody @Valid DadosCadastroUsuario dadosCadastroUsuario, UriComponentsBuilder builder){
        var usuario = new UsuarioModel(dadosCadastroUsuario);
        usuario.setSenha(usuarioService.criptografaSenha(usuario.getSenha()));
        usuarioRepository.save(usuario);
        var uri = builder.buildAndExpand("/usuario/{id}").expand(usuario.getId()).toUri();

        return ResponseEntity.created(uri).body("Cadastrado realizado com sucesso!");
    }
}
