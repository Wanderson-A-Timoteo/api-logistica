package br.com.wandersontimoteo.apilogistica.api.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class EntregaRequestModel {

    @Valid
    @NotNull
    private ClienteIdRequestModel cliente;

    @Valid
    @NotNull
    private DestinatarioRequestModel destinatario;

    @NotNull
    private BigDecimal taxa;
}
