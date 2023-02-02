package br.com.alura.challenge.controller;

import br.com.alura.challenge.model.categoria.*;
import br.com.alura.challenge.model.video.DadosVideo;
import br.com.alura.challenge.repository.CategoriaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public ResponseEntity listaDeCategorias(){
        var categorias = categoriaRepository.findAll();
        return ResponseEntity.ok(categorias.stream().map(DadosCategoria::new).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity consultarCategoriaPorId(@PathVariable(name="id") Long id){
        var categoria = categoriaRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosCategoria(categoria));
    }

    @GetMapping("/{id}/videos")
    public ResponseEntity consultarVideosPorCategoria(@PathVariable(name = "id") Long id){
        var videos = categoriaRepository.findByVideosPorCategoria(id);
        return ResponseEntity.ok(videos.stream().map(DadosVideo::new).collect(Collectors.toList()));
    }

   @GetMapping("/videos/")
   public ResponseEntity consultarCategoriaPeloTitulo(@RequestParam("search") String search){
        var categoria = categoriaRepository.findByTitulo(search);
        return ResponseEntity.ok(new CategoriaVideos(categoria));
   }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroCategoria dadosCadastroCategoria, UriComponentsBuilder builder){
        var categoria = new CategoriaModel(dadosCadastroCategoria);
        var uri = builder.buildAndExpand("/categorias/{id}").expand(categoria.getId()).toUri();
        categoriaRepository.save(categoria);
        return ResponseEntity.created(uri).body(new DadosCategoria(categoria));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarCategoria(@RequestBody @Valid DadosAtualizadosCategoria dadosCategoria){
        var categoria = categoriaRepository.getReferenceById(dadosCategoria.id());
        categoria.atualizarDados(dadosCategoria);
        categoriaRepository.save(categoria);
        return ResponseEntity.ok(new DadosCategoria(categoria));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarCategoria(@PathVariable(name = "id") Long id){
        categoriaRepository.deleteById(id);

        return ResponseEntity.noContent()
                .header("mensagem", "A categoria com o id " + id + " foi deletada com sucesso!")
                .build();
    }
}
