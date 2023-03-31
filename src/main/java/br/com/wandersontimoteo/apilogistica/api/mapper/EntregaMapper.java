package br.com.wandersontimoteo.apilogistica.api.mapper;

import br.com.wandersontimoteo.apilogistica.api.model.EntregaModel;
import br.com.wandersontimoteo.apilogistica.domain.model.Entrega;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class EntregaMapper {

    private ModelMapper modelMapper;

    public EntregaModel toModel(Entrega entrega) {
        return modelMapper.map(entrega, EntregaModel.class);
    }
}
