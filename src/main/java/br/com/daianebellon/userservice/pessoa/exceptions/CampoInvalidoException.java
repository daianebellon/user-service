package br.com.daianebellon.userservice.pessoa.exceptions;

public class CampoInvalidoException extends RuntimeException {

    public CampoInvalidoException(String message) {
        super(message);
    }
}
