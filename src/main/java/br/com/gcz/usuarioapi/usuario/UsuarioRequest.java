package br.com.gcz.usuarioapi.usuario;

import br.com.gcz.usuarioapi.validation.constraint.UsuarioUniqueColumn;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

public class UsuarioRequest {

    @NotBlank(message = "{usuario.vazio.nome}")
    private String nome;

    @Email(message = "{usuario.invalido.email}")
    @UsuarioUniqueColumn(value = "email", message = "{usuario.unico.email}")
    @NotBlank(message = "{usuario.vazio.email}")
    private String email;

    @CPF(message = "{usuario.invalido.cpf}")
    @UsuarioUniqueColumn(value = "cpf", message = "{usuario.unico.cpf}")
    @NotBlank(message = "{usuario.vazio.cpf}")
    private String cpf;

    @Past(message = "{usuario.invalido.dataPassada}")
    @NotNull(message = "{usuario.vazio.dataNascimento}")
    private LocalDate dataNascimento;

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Usuario toUsuario() {
        return new Usuario(this.nome, this.email, this.cpf, this.dataNascimento);
    }
}
