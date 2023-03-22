package br.com.wandersontimoteo.apilogistica.api.controller;

import br.com.wandersontimoteo.apilogistica.domain.model.Cliente;
import br.com.wandersontimoteo.apilogistica.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class ClienteController {

    private ClienteRepository clienteRepository;

    @GetMapping("/clientes")
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }
    @GetMapping("/clientes/{clienteId}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId) {

        return clienteRepository.findById(clienteId)
                .map(cliente -> ResponseEntity.ok(cliente))
                .orElse(ResponseEntity.notFound().build());
    }
}
