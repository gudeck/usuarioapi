package br.com.gcz.usuarioapi.controller.repository;

import br.com.gcz.usuarioapi.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
