package br.com.wandersontimoteo.apilogistica.api.controller;

import br.com.wandersontimoteo.apilogistica.api.mapper.EntregaMapper;
import br.com.wandersontimoteo.apilogistica.api.model.EntregaModel;
import br.com.wandersontimoteo.apilogistica.api.model.request.EntregaRequestModel;
import br.com.wandersontimoteo.apilogistica.domain.model.Entrega;
import br.com.wandersontimoteo.apilogistica.domain.repository.EntregaRepository;
import br.com.wandersontimoteo.apilogistica.domain.service.SolicitacaoEntregaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

    private EntregaRepository entregaRepository;
    private SolicitacaoEntregaService solicitacaoEntregaService;
    private EntregaMapper entregaMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntregaModel solicitar(@Valid @RequestBody EntregaRequestModel entregaRequestModel) {
        Entrega novaEntrega = entregaMapper.toEntity(entregaRequestModel);
        Entrega entregaSolicitada = solicitacaoEntregaService.solicitar(novaEntrega);
        return entregaMapper.toModel(entregaSolicitada);
    }

    @GetMapping
    public List<EntregaModel> listar() {
        return entregaMapper.toCollectionModel(entregaRepository.findAll());
    }

    @GetMapping("/{entregaId}")
    public ResponseEntity<EntregaModel> buscar(@PathVariable Long entregaId) {
        return entregaRepository.findById(entregaId)
                .map(entrega -> ResponseEntity.ok(entregaMapper.toModel(entrega)))
                .orElse(ResponseEntity.notFound().build());
    }
}