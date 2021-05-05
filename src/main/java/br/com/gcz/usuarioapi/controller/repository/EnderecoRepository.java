package br.com.gcz.usuarioapi.controller.repository;

import br.com.gcz.usuarioapi.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
