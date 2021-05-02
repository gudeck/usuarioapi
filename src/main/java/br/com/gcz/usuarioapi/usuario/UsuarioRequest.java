package br.com.gcz.usuarioapi.usuario;

import br.com.gcz.usuarioapi.validation.constraint.UsuarioUniqueColumn;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

public final class UsuarioRequest {

    @NotBlank(message = "{campo.vazio}")
    private final String nome;

    @Email(message = "{usuario.invalido.email}")
    @UsuarioUniqueColumn(value = "email", message = "{usuario.unico.email}")
    @NotBlank(message = "{campo.vazio}")
    private final String email;

    @CPF(message = "{usuario.invalido.cpf}")
    @UsuarioUniqueColumn(value = "cpf", message = "{usuario.unico.cpf}")
    @NotBlank(message = "{campo.vazio}")
    private final String cpf;

    @Past(message = "{usuario.invalido.dataPassada}")
    @NotNull(message = "{campo.vazio}")
    private final LocalDate dataNascimento;

    public UsuarioRequest(String nome, String email, String cpf, LocalDate dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public Usuario toUsuario() {
        return new Usuario(nome, email, cpf, dataNascimento);
    }
}
