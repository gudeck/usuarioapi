package br.com.gcz.usuarioapi.consulta_cep;

public final class ViaCepResponse {

    private final String cep;
    private final String logradouro;
    private final String complemento;
    private final String bairro;
    private final String localidade;
    private final String uf;
    private final String numero;

    public ViaCepResponse(String cep, String logradouro, String complemento,
                          String bairro, String localidade, String uf, String numero) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }
}
