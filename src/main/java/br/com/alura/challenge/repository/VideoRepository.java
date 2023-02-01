package br.com.alura.challenge.repository;

import br.com.alura.challenge.model.video.VideoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<VideoModel, Long> {
}
