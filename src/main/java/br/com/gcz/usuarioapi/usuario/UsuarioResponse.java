package br.com.gcz.usuarioapi.usuario;

import br.com.gcz.usuarioapi.endereco.EnderecoResponse;

import java.time.LocalDate;
import java.util.List;

public record UsuarioResponse(Long id, String nome, String email, String cpf,
                              LocalDate dataNascimento, List<EnderecoResponse> enderecos) {
}
