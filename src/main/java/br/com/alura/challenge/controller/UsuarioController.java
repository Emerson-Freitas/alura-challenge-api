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
@CrossOrigin(origins = {"http://localhost:8080", "https://alura-challenge-api-production.up.railway.app/*", "http://alura-challenge-api-production.up.railway.app/*"})
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarUsuario(@RequestBody @Valid DadosCadastroUsuario dadosCadastroUsuario, UriComponentsBuilder builder){
        var usuario = new UsuarioModel(dadosCadastroUsuario);
        var senhaCriptografada = usuarioService.criptografaSenha(usuario.getSenha());
        usuario.setSenha(senhaCriptografada);
        usuarioRepository.save(usuario);
        var uri = builder.buildAndExpand("/usuario/{id}").expand(usuario.getId()).toUri();

        return ResponseEntity.created(uri).body("Cadastrado realizado com sucesso!");
    }
}
