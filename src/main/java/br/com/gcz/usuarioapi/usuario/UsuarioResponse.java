package br.com.gcz.usuarioapi.usuario;

import br.com.gcz.usuarioapi.endereco.EnderecoResponse;

import java.time.LocalDate;
import java.util.List;

public record UsuarioResponse(Long id, String nome, String email, String cpf,
                              LocalDate dataNascimento, List<EnderecoResponse> enderecos) {

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public List<EnderecoResponse> getEnderecos() {
        return enderecos;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
