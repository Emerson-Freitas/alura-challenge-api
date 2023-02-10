package br.com.alura.challenge.repository;

import br.com.alura.challenge.model.video.VideoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VideoRepository extends JpaRepository<VideoModel, Long> {

    List<VideoModel> findFirst10ByOrderByIdAsc();

}
