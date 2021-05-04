package br.com.gcz.usuarioapi.usuario;

import br.com.gcz.usuarioapi.validation.constraint.UsuarioUniqueColumn;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

public record UsuarioRequest(
        @NotBlank(message = "{campo.vazio}")
        String nome,

        @Email(message = "{usuario.invalido.email}")
        @UsuarioUniqueColumn(value = "email", message = "{usuario.unico.email}")
        @NotBlank(message = "{campo.vazio}")
        String email,

        @CPF(message = "{usuario.invalido.cpf}")
        @UsuarioUniqueColumn(value = "cpf", message = "{usuario.unico.cpf}")
        @NotBlank(message = "{campo.vazio}")
        String cpf,

        @Past(message = "{usuario.invalido.dataPassada}")
        @NotNull(message = "{campo.vazio}")
        LocalDate dataNascimento) {

    public Usuario toUsuario() {
        return new Usuario(nome, email, cpf, dataNascimento);
    }
}
