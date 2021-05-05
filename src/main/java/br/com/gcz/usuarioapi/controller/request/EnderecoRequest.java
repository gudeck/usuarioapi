package br.com.gcz.usuarioapi.controller.request;

import br.com.gcz.usuarioapi.annotation.constraint.CEP;
import br.com.gcz.usuarioapi.domain.Endereco;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record EnderecoRequest(
        @CEP(message = "{endereco.invalido.cep}")
        @NotNull(message = "{campo.vazio}")
        Long cep,

        @NotBlank(message = "{campo.vazio}")
        String estado,

        @NotBlank(message = "{campo.vazio}")
        String cidade,

        @NotBlank(message = "{campo.vazio}")
        String bairro,

        @NotBlank(message = "{campo.vazio}")
        String logradouro,

        @NotBlank(message = "{campo.vazio}")
        String numero,

        @NotBlank(message = "{campo.vazio}")
        String complemento) {

    public Endereco toEndereco(Long idUsuario) {
        return new Endereco(idUsuario, cep, estado, cidade, bairro, logradouro, numero, complemento);
    }
}
