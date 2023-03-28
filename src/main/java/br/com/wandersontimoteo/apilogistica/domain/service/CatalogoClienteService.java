package br.com.wandersontimoteo.apilogistica.domain.service;

import br.com.wandersontimoteo.apilogistica.domain.model.Cliente;
import br.com.wandersontimoteo.apilogistica.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class CatalogoClienteService {

    private ClienteRepository clienteRepository;
    @Transactional
    public Cliente salvar(Cliente cliente) {

      return clienteRepository.save(cliente);
    }
    @Transactional
    public void excluir(Long clienteId) {

        clienteRepository.deleteById(clienteId);
    }
}
