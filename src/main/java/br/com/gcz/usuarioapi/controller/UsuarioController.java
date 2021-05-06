package br.com.gcz.usuarioapi.controller;

import br.com.gcz.usuarioapi.controller.repository.EnderecoRepository;
import br.com.gcz.usuarioapi.controller.repository.UsuarioRepository;
import br.com.gcz.usuarioapi.controller.request.EnderecoRequest;
import br.com.gcz.usuarioapi.controller.request.UsuarioRequest;
import br.com.gcz.usuarioapi.controller.response.UsuarioResponse;
import br.com.gcz.usuarioapi.controller.response.ViaCepResponse;
import br.com.gcz.usuarioapi.domain.Endereco;
import br.com.gcz.usuarioapi.domain.Usuario;
import br.com.gcz.usuarioapi.feign.ViaCepClient;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

/**
 * API para cadastro de usuários e
 * associação de endereços
 * <br>
 * Endpoints:
 * <br>
 * <ul>
 *     <li>POST - /usuarios</li>
 *     <li>GET  - /usuarios/{id}</li>
 *     <li>PUT  - /usuarios/{id}/enderecos</li>
 * </ul>
 *
 * @author Gustavo Zucolotto
 */

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;
    private final EnderecoRepository enderecoRepository;
    private final ViaCepClient viaCepClient;

    public UsuarioController(UsuarioRepository usuarioRepository, EnderecoRepository enderecoRepository,
                             ViaCepClient viaCepClient) {
        this.usuarioRepository = usuarioRepository;
        this.enderecoRepository = enderecoRepository;
        this.viaCepClient = viaCepClient;
    }

    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Endereço associado com sucesso"),
            @ApiResponse(code = 400, message = "Usuário não encontrado ou endereço inválido")
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{idUsuario}/enderecos")
    public ResponseEntity<Void> associarEndereco(@PathVariable Long idUsuario, @RequestBody @Valid EnderecoRequest enderecoRequest) {
        validarUsuario(idUsuario);
        validarEndereco(enderecoRequest.cep());
        Endereco endereco = enderecoRepository.save(enderecoRequest.toEndereco(idUsuario));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}/enderecos/{id}").buildAndExpand(idUsuario, endereco.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuário encontrado", response = UsuarioResponse.class),
            @ApiResponse(code = 404, message = "Usuário não encontrado")
    })
    @GetMapping("/{idUsuario}")
    public ResponseEntity<UsuarioResponse> buscarPorId(@PathVariable Long idUsuario) {
        UsuarioResponse response = validarUsuario(idUsuario).toUsuarioResponse();
        return ResponseEntity.ok(response);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Usuário criado com sucesso"),
            @ApiResponse(code = 400, message = "Usuário inválido")
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<Void> inserir(@RequestBody @Valid UsuarioRequest usuarioRequest) {
        Usuario usuario = usuarioRepository.save(usuarioRequest.toUsuario());
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    private void validarEndereco(Long cep) {
        ViaCepResponse response = viaCepClient.buscarPorCep(cep);
        if (Strings.isBlank(response.cep())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "endereco.invalido");
        }
    }

    private Usuario validarUsuario(Long idUsuario) {
        return usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "usuario.naoEncontrado"));
    }

}
