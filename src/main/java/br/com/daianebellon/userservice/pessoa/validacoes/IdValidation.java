package br.com.daianebellon.userservice.pessoa.validacoes;

import br.com.daianebellon.userservice.pessoa.exceptions.CampoInvalidoException;

public class IdValidation {

    public static void validar(Long id) {
        if (id == null) {
            throw new CampoInvalidoException("Id inválido");
        }
    }
}
