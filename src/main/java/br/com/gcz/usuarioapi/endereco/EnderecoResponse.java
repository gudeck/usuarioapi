package br.com.gcz.usuarioapi.endereco;

public class EnderecoResponse {
    private Long id;
    private String cep;
    private String estado;
    private String cidade;
    private String bairro;
    private String logradouro;
    private String numero;
    private String complemento;

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
