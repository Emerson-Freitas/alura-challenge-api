package br.com.alura.challenge.controller;

import br.com.alura.challenge.model.video.DadosAtualizadosVideo;
import br.com.alura.challenge.model.video.DadosCadastroVideo;
import br.com.alura.challenge.model.video.DadosVideo;
import br.com.alura.challenge.model.video.VideoModel;
import br.com.alura.challenge.repository.VideoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/videos")
public class VideoController {

    @Autowired
    private VideoRepository videoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroVideo dadosCadastroVideo, UriComponentsBuilder builder){
        var video = new VideoModel(dadosCadastroVideo);
        var uri = builder.buildAndExpand("/videos/{id}").expand(video.getId()).toUri();
        videoRepository.save(video);
        return ResponseEntity.created(uri).body(new DadosVideo(video));
    }

    @GetMapping("/free")
    public ResponseEntity listaDeVideosFree(){
        var videos = videoRepository.findFirst10ByOrderByIdAsc();
        return ResponseEntity.ok(videos.stream().map(DadosVideo::new).collect(Collectors.toList()));
    }
    @GetMapping
    public ResponseEntity<List<DadosVideo>> listaDeVideos(@PageableDefault(size = 5, sort = {"id"})Pageable page){
        var videos = videoRepository.findAll(page);
        return ResponseEntity.ok(videos.stream().map(DadosVideo::new).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity consultarPorId(@PathVariable(name = "id") Long id){
        var video = videoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosVideo(video));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizadosVideo dadosAtualizadosVideo){
        var video = videoRepository.getReferenceById(dadosAtualizadosVideo.id());
        video.atualizarDados(dadosAtualizadosVideo);
        videoRepository.save(video);
        return ResponseEntity.ok(new DadosVideo(video));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable(name = "id") Long id){
        videoRepository.deleteById(id);
        return ResponseEntity.noContent().header("mensagem","Usuario com o id " + id + " deletado com sucesso!").build();
    }

}
