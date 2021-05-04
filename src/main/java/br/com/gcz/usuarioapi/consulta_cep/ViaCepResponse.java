package br.com.gcz.usuarioapi.consulta_cep;

public record ViaCepResponse(String cep, String logradouro, String complemento, String bairro,
                             String localidade, String uf, String numero) {
}
