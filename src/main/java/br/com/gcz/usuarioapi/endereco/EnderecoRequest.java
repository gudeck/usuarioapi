package br.com.gcz.usuarioapi.endereco;

import br.com.gcz.usuarioapi.validation.constraint.CEP;

import javax.validation.constraints.NotBlank;

public class EnderecoRequest {

    @CEP(message = "{endereco.invalido.cep}")
    @NotBlank(message = "{campo.vazio}")
    private final String cep;

    @NotBlank(message = "{campo.vazio}")
    private final String estado;

    @NotBlank(message = "{campo.vazio}")
    private final String cidade;

    @NotBlank(message = "{campo.vazio}")
    private final String bairro;

    @NotBlank(message = "{campo.vazio}")
    private final String logradouro;

    @NotBlank(message = "{campo.vazio}")
    private final String numero;

    @NotBlank(message = "{campo.vazio}")
    private final String complemento;

    public EnderecoRequest(String cep, String estado, String cidade, String bairro,
                           String logradouro, String numero, String complemento) {
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public Endereco toEndereco(Long idUsuario) {
        return new Endereco(idUsuario, cep, estado, cidade, bairro, logradouro, numero, complemento);
    }
}
