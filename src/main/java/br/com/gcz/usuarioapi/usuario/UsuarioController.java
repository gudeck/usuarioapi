package br.com.gcz.usuarioapi.usuario;

import br.com.gcz.usuarioapi.endereco.Endereco;
import br.com.gcz.usuarioapi.endereco.EnderecoRepository;
import br.com.gcz.usuarioapi.endereco.EnderecoRequest;
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

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;
    private final EnderecoRepository enderecoRepository;

    public UsuarioController(UsuarioRepository usuarioRepository, EnderecoRepository enderecoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.enderecoRepository = enderecoRepository;
    }

    @PutMapping("/{id}/enderecos")
    public ResponseEntity<Void> associarEndereco(@PathVariable Long id, @RequestBody @Valid EnderecoRequest request) {
        Endereco endereco = enderecoRepository.save(request.toEndereco(id));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}/enderecos/{id}").buildAndExpand(id, endereco.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> buscarPorId(@PathVariable Long id) {
        UsuarioResponse response = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "registro.naoEncontrado"))
                .toUsuarioResponse();
        response.setEnderecos(enderecoRepository.findAllByUsuarioId(response.getId()));
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Void> inserir(@RequestBody @Valid UsuarioRequest request) {
        Usuario usuario = usuarioRepository.save(request.toUsuario());
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
