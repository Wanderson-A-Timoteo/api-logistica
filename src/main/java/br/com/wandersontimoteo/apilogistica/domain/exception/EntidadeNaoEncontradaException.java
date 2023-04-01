package br.com.wandersontimoteo.apilogistica.domain.exception;

public class EntidadeNaoEncontradaException extends NegocioException {

    private static final long serialVersionUID = -3545244177163711927L;

    public EntidadeNaoEncontradaException(String message) {
        super(message);
    }
}
