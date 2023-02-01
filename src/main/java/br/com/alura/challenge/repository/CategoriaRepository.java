package br.com.alura.challenge.repository;

import br.com.alura.challenge.model.categoria.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {
}
