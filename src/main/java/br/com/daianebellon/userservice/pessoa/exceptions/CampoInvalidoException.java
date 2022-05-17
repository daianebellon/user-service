package br.com.daianebellon.userservice.pessoa.exceptions;

public class CampoInvalidoException extends RuntimeException {

    public CampoInvalidoException(ErrorMessages errorMessages, Long id) {
        super(String.format(errorMessages.getMensagem(), id));
    }

    public CampoInvalidoException(ErrorMessages errorMessages, String string) {
        super(String.format(errorMessages.getMensagem(), string));
    }
}
