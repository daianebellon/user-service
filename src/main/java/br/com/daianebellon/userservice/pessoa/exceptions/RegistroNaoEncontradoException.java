package br.com.daianebellon.userservice.pessoa.exceptions;

public class RegistroNaoEncontradoException extends RuntimeException {

    public RegistroNaoEncontradoException(ErrorMessages errorMessages, Long id) {
        super(String.format(errorMessages.getMensagem(), id));
    }

}
