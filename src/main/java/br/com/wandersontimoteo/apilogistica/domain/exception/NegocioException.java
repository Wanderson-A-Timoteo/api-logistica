package br.com.wandersontimoteo.apilogistica.domain.exception;

public class NegocioException extends RuntimeException {
    private static final long serialVersionUID = -6967218701225347442L;

    public NegocioException(String message) {
        super(message);
    }
}
