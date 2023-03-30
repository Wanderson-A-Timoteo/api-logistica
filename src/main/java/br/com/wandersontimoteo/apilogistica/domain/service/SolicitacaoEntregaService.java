package br.com.wandersontimoteo.apilogistica.domain.service;

import br.com.wandersontimoteo.apilogistica.domain.model.Cliente;
import br.com.wandersontimoteo.apilogistica.domain.model.Entrega;
import br.com.wandersontimoteo.apilogistica.domain.model.StatusEntrega;
import br.com.wandersontimoteo.apilogistica.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {

    private CatalogoClienteService catalogoClienteService;
    private EntregaRepository entregaRepository;

    @Transactional
    public Entrega solicitar(Entrega entrega) {
        Cliente cliente = catalogoClienteService.buscar(entrega.getCliente().getId());

        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(LocalDateTime.now());

        return entregaRepository.save(entrega);
    }
}
