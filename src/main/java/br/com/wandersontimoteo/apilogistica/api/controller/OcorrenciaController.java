package br.com.wandersontimoteo.apilogistica.api.controller;


import br.com.wandersontimoteo.apilogistica.api.mapper.OcorrenciaMapper;
import br.com.wandersontimoteo.apilogistica.api.model.OcorrenciaModel;
import br.com.wandersontimoteo.apilogistica.api.model.request.OcorrenciaRequestModel;
import br.com.wandersontimoteo.apilogistica.domain.model.Entrega;
import br.com.wandersontimoteo.apilogistica.domain.model.Ocorrencia;
import br.com.wandersontimoteo.apilogistica.domain.service.BuscaEntregaService;
import br.com.wandersontimoteo.apilogistica.domain.service.RegistroOcorrenciaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {

    private BuscaEntregaService buscaEntregaService;
    private RegistroOcorrenciaService registroOcorrenciaService;
    private OcorrenciaMapper ocorrenciaMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaModel registrar(@PathVariable Long entregaId,
        @Valid @RequestBody OcorrenciaRequestModel ocorrenciaRequestModel) {
        Ocorrencia ocorrenciaRegistrada = registroOcorrenciaService
                .registrar(entregaId, ocorrenciaRequestModel.getDescricao());

        return ocorrenciaMapper.toModel(ocorrenciaRegistrada);
    }

    @GetMapping
    public List<OcorrenciaModel> listar(@PathVariable Long entregaId) {
        Entrega entrega = buscaEntregaService.buscar(entregaId);
        return ocorrenciaMapper.toCollectionsModel(entrega.getOcorrencias());
    }
}
