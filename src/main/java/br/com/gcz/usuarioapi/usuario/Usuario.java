package br.com.gcz.usuarioapi.usuario;

import br.com.gcz.usuarioapi.endereco.Endereco;
import br.com.gcz.usuarioapi.endereco.EnderecoResponse;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    public Usuario() {
    }

    public Usuario(Long id) {
        this.id = id;
    }

    public Usuario(String nome, String email, String cpf, LocalDate dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public Long getId() {
        return id;
    }

    public UsuarioResponse toUsuarioResponse(List<Endereco> enderecos) {
        List<EnderecoResponse> enderecosResponse = enderecos.stream().map(Endereco::toEnderecoResponse).collect(Collectors.toList());
        return new UsuarioResponse(id, nome, email, cpf, dataNascimento, enderecosResponse);
    }
}
