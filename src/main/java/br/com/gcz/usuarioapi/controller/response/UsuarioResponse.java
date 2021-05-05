package br.com.gcz.usuarioapi.controller.response;

import java.time.LocalDate;
import java.util.List;

public record UsuarioResponse(Long id, String nome, String email, String cpf,
                              LocalDate dataNascimento, List<EnderecoResponse> enderecos) {
}
