package br.com.gcz.usuarioapi.usuario;

import br.com.gcz.usuarioapi.endereco.Endereco;
import br.com.gcz.usuarioapi.endereco.EnderecoResponse;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioResponse {

    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private LocalDate dataNascimento;
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
