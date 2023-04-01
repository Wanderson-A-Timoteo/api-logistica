package br.com.wandersontimoteo.apilogistica.domain.service;

import br.com.wandersontimoteo.apilogistica.domain.exception.NegocioException;
import br.com.wandersontimoteo.apilogistica.domain.model.Entrega;
import br.com.wandersontimoteo.apilogistica.domain.model.StatusEntrega;
import br.com.wandersontimoteo.apilogistica.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FinalizacaoEntregaService {

    private EntregaRepository entregaRepository;
    private BuscaEntregaService buscaEntregaService;

    public void finalizar(Long entregaId) {
        Entrega entrega = buscaEntregaService.buscar(entregaId);

        entrega.finalizar();

        entregaRepository.save(entrega);
    }
}
