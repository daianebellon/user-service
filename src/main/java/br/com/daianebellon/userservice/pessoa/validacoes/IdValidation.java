package br.com.daianebellon.userservice.pessoa.validacoes;

import br.com.daianebellon.userservice.pessoa.exceptions.CampoInvalidoException;
import br.com.daianebellon.userservice.pessoa.exceptions.ErrorMessages;

public class IdValidation {

    public static void validar(Long id) {
        if (id == null) {
            throw new CampoInvalidoException(ErrorMessages.CAMPO_INVALIDO_EXCEPTION, "id");
        }
    }
}
