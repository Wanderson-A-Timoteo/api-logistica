package br.com.wandersontimoteo.apilogistica.api.mapper;


import br.com.wandersontimoteo.apilogistica.api.model.OcorrenciaModel;
import br.com.wandersontimoteo.apilogistica.domain.model.Ocorrencia;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class OcorrenciaMapper {

    private ModelMapper modelMapper;

    public OcorrenciaModel toModel(Ocorrencia ocorrencia) {

        return modelMapper.map(ocorrencia, OcorrenciaModel.class);
    }
}
