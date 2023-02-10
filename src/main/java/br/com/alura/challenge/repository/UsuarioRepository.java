package br.com.alura.challenge.repository;

import br.com.alura.challenge.model.usuario.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    UserDetails findByLogin(String login);
}
