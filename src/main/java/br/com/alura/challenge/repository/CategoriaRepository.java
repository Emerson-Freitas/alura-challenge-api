package br.com.alura.challenge.repository;

import br.com.alura.challenge.model.categoria.CategoriaModel;
import br.com.alura.challenge.model.video.VideoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {

    @Query("SELECT v FROM Video v WHERE v.categoriaId = :id")
    List<VideoModel> findByVideosPorCategoria(@Param("id")Long id);

    CategoriaModel findByTitulo(String titulo);

}
