package br.com.gcz.usuarioapi.consulta_cep;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacepclient", url = "${feign.viacep.url}")
public interface ViaCepClient {

    @GetMapping("{cep}/json")
    Object buscarPorCep(@PathVariable String cep);

}
