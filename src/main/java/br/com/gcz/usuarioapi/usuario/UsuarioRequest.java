package br.com.gcz.usuarioapi.usuario;

import br.com.gcz.usuarioapi.validation.constraint.UsuarioUniqueColumn;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

public class UsuarioRequest {

    @NotBlank
    private String nome;

    @Email
    @UsuarioUniqueColumn(value = "email", message = "Email já cadastrado")
    @NotBlank
    private String email;

    @CPF
    @UsuarioUniqueColumn(value = "cpf", message = "CPF já cadastrado")
    @NotNull
    private String cpf;

    @Past
    @NotNull
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
