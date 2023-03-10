package br.com.alura.challenge.controller;

import br.com.alura.challenge.model.categoria.CategoriaModel;
import br.com.alura.challenge.model.categoria.DadosAtualizadosCategoria;
import br.com.alura.challenge.model.categoria.DadosCadastroCategoria;
import br.com.alura.challenge.model.categoria.DadosCategoria;
import br.com.alura.challenge.model.video.DadosVideo;
import br.com.alura.challenge.repository.CategoriaRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/categorias")
@SecurityRequirement(name = "bearer-key")
@CrossOrigin(origins = {"http://localhost:8080", "https://alura-challenge-api-production.up.railway.app/*", "http://alura-challenge-api-production.up.railway.app/*"})
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public ResponseEntity<Page<DadosCategoria>> listaDeCategorias(@PageableDefault(size = 5, sort = {"id"}) Pageable page){
        var categorias = categoriaRepository.findAll(page).map(DadosCategoria::new);
        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity consultarCategoriaPorId(@PathVariable(name="id") Long id){
        var categoria = categoriaRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosCategoria(categoria));
    }

    @GetMapping("/{id}/videos")
    public ResponseEntity<Page<DadosVideo>> consultarVideosPorCategoria(@PathVariable(name = "id") Long id, @PageableDefault(size = 5, sort = {"id"}) Pageable page){
        var videos = categoriaRepository.findByVideosPorCategoria(id, page).map(DadosVideo::new);
        return ResponseEntity.ok(videos);
    }

    @GetMapping("/videos/")
    public ResponseEntity consultarVideosTituloCategoria(@RequestParam(name = "titulo") String titulo, @PageableDefault(size = 5, sort = {"id"}) Pageable pageable){
        var videos = categoriaRepository.findVideosByTituloCategoria(titulo, pageable).map(DadosVideo::new);
        return ResponseEntity.ok(videos);
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
