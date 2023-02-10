package br.com.alura.challenge.repository;

import br.com.alura.challenge.model.video.VideoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VideoRepository extends JpaRepository<VideoModel, Long> {

    Page<VideoModel> findFirst10ByOrderByIdAsc(Pageable page);

}
