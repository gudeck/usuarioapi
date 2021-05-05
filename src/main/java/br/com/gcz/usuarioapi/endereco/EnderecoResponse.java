package br.com.gcz.usuarioapi.endereco;

public record EnderecoResponse(Long id, Long cep, String estado, String cidade,
                               String bairro, String logradouro, String numero, String complemento) {
}
