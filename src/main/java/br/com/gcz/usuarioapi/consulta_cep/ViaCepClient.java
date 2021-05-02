package br.com.gcz.usuarioapi.consulta_cep;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacepclient", url = "https://viacep.com.br/ws/")
public interface ViaCepClient {

    @GetMapping("{uf}/{cidade}/{logradouro}/json")
    ViaCepResponse buscarCep(@PathVariable String uf, @PathVariable String cidade, @PathVariable String logradouro);

    @GetMapping("{cep}/json")
    ViaCepResponse buscarPorCep(@PathVariable String cep);

}
