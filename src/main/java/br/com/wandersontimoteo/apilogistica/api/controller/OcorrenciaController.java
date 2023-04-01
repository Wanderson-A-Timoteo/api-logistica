package br.com.wandersontimoteo.apilogistica.api.controller;


import br.com.wandersontimoteo.apilogistica.api.mapper.OcorrenciaMapper;
import br.com.wandersontimoteo.apilogistica.api.model.OcorrenciaModel;
import br.com.wandersontimoteo.apilogistica.api.model.request.OcorrenciaRequestModel;
import br.com.wandersontimoteo.apilogistica.domain.model.Ocorrencia;
import br.com.wandersontimoteo.apilogistica.domain.service.RegistroOcorrenciaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {

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
}
