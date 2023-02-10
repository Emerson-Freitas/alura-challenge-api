package br.com.alura.challenge.repository;

import br.com.alura.challenge.model.categoria.CategoriaModel;
import br.com.alura.challenge.model.video.VideoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {

    @Query("SELECT v FROM Video v WHERE v.categoriaId = :id")
    Page<VideoModel> findByVideosPorCategoria(@Param("id")Long id, Pageable page);

    @Query("SELECT c.videos FROM Categoria c WHERE c.titulo = :titulo")
    Page<VideoModel> findVideosByTituloCategoria(@Param("titulo") String titulo, Pageable pageable);
}
