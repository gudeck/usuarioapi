package br.com.gcz.usuarioapi.endereco;

import br.com.gcz.usuarioapi.validation.constraint.CEP;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Endereco {

    @Id
    @GeneratedValue
    private Long id;

    @CEP
    @NotBlank
    private String cep;

    @NotBlank
    private String estado;

    @NotBlank
    private String cidade;

    @NotBlank
    private String bairro;

    @NotBlank
    private String logradouro;

    @NotBlank
    private String numero;

    @NotBlank
    private String complemento;

}
