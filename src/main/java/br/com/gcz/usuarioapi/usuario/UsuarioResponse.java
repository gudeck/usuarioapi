package br.com.gcz.usuarioapi.usuario;

import br.com.gcz.usuarioapi.endereco.Endereco;
import br.com.gcz.usuarioapi.endereco.EnderecoResponse;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioResponse {

    private final Long id;
    private final String nome;
    private final String email;
    private final String cpf;
    private final LocalDate dataNascimento;
    private List<EnderecoResponse> enderecos;

    public UsuarioResponse(Long id, String nome, String email, String cpf, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public Long getId() {
        return id;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos.stream().map(Endereco::toEnderecoResponse).collect(Collectors.toList());
    }
}
