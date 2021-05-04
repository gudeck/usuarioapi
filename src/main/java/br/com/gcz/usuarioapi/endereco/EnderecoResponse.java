package br.com.gcz.usuarioapi.endereco;

public record EnderecoResponse(Long id, Long cep, String estado, String cidade,
                               String bairro, String logradouro, String numero, String complemento) {
    public String getBairro() {
        return bairro;
    }

    public Long getCep() {
        return cep;
    }

    public String getCidade() {
        return cidade;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getEstado() {
        return estado;
    }

    public Long getId() {
        return id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumero() {
        return numero;
    }
}
