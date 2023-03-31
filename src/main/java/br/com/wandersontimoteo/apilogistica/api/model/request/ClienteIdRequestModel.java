package br.com.wandersontimoteo.apilogistica.api.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ClienteIdRequestModel {

    @NotNull
    private Long id;
}
