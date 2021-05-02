package br.com.gcz.usuarioapi.endereco;

public class EnderecoResponse {
    private final Long id;
    private final String cep;
    private final String estado;
    private final String cidade;
    private final String bairro;
    private final String logradouro;
    private final String numero;
    private final String complemento;

    public EnderecoResponse(Long id, String cep, String estado, String cidade,
                            String bairro, String logradouro, String numero, String complemento) {
        this.id = id;
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
    }

}
