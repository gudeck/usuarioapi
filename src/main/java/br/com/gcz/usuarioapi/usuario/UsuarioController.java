package br.com.gcz.usuarioapi.usuario;

import br.com.gcz.usuarioapi.consulta_cep.ViaCepClient;
import br.com.gcz.usuarioapi.consulta_cep.ViaCepResponse;
import br.com.gcz.usuarioapi.endereco.Endereco;
import br.com.gcz.usuarioapi.endereco.EnderecoRepository;
import br.com.gcz.usuarioapi.endereco.EnderecoRequest;
import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @PutMapping("/{id}/enderecos")
    public ResponseEntity<Void> associarEndereco(@PathVariable Long id, @RequestBody @Valid EnderecoRequest request) {
        validarUsuario(id);
        validarEndereco(request.cep());
        Endereco endereco = enderecoRepository.save(request.toEndereco(id));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}/enderecos/{id}").buildAndExpand(id, endereco.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> buscarPorId(@PathVariable Long id) {
        UsuarioResponse response = validarUsuario(id).toUsuarioResponse();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Void> inserir(@RequestBody @Valid UsuarioRequest request) {
        Usuario usuario = usuarioRepository.save(request.toUsuario());
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    private void validarEndereco(Long cep) {
        ViaCepResponse response = viaCepClient.buscarPorCep(cep);
        if (Strings.isBlank(response.cep())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "endereco.invalido");
        }
    }

    private Usuario validarUsuario(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "usuario.naoEncontrado"));
    }

}
