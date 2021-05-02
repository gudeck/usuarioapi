package br.com.gcz.usuarioapi.endereco;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    List<Endereco> findAllByUsuarioId(Long idUsuario);
}
