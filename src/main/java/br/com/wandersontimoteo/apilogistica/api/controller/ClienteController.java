package br.com.wandersontimoteo.apilogistica.api.controller;

import br.com.wandersontimoteo.apilogistica.domain.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClienteController {
    @GetMapping("/clientes")
    public List<Cliente> listar() {

        Cliente cliente1 = new Cliente();
        cliente1.setId(1L);
        cliente1.setNome("Wanderson");
        cliente1.setEmail("wanderson@gmail.com");
        cliente1.setTelefone("(99) 9.9999-9999");

        Cliente cliente2 = new Cliente();
        cliente2.setId(2L);
        cliente2.setNome("Ryan");
        cliente2.setEmail("ryan@gmail.com");
        cliente2.setTelefone("(88) 8.8888-8888");

        return Arrays.asList(cliente1, cliente2);
    }
}
