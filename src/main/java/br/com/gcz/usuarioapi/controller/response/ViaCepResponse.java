package br.com.gcz.usuarioapi.controller.response;

public record ViaCepResponse(String cep, String logradouro, String complemento, String bairro,
                             String localidade, String uf, String numero) {
}
