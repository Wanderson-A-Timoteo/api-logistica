package br.com.wandersontimoteo.apilogistica.api.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class DestinatarioRequest {

    @NotBlank
    private String nome;

    @NotBlank
    private String logradouro;

    @NotBlank
    private String numero;

    @NotBlank
    private String complemento;

    @NotBlank
    private String bairro;
}
