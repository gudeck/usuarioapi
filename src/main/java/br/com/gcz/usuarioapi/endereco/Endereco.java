package br.com.gcz.usuarioapi.endereco;

import br.com.gcz.usuarioapi.usuario.Usuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Column(nullable = false)
    private String cep;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private String bairro;

    @Column(nullable = false)
    private String logradouro;

    @Column(nullable = false)
    private String numero;

    @Column(nullable = false)
    private String complemento;

    public Endereco() {
    }

    public Endereco(Long idUsuario, String cep, String estado, String cidade,
                    String bairro, String logradouro, String numero, String complemento) {
        this.usuario = new Usuario(idUsuario);
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
    }

    public Long getId() {
        return id;
    }

    public EnderecoResponse toEnderecoResponse() {
        return new EnderecoResponse(id, cep, estado, cidade, bairro, logradouro, numero, complemento);
    }
}
