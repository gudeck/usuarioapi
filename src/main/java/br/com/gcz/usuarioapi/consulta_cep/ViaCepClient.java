package br.com.gcz.usuarioapi.consulta_cep;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Feign client para validação de endereços.
 *
 * @author Gustavo Zucolotto
 */
@FeignClient(name = "viacepclient", url = "https://viacep.com.br/ws/")
public interface ViaCepClient {

    @GetMapping("{cep}/json")
    ViaCepResponse buscarPorCep(@PathVariable Long cep);

}
