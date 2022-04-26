package br.com.daianebellon.userservice.pessoa.validacoes;

public class IdValidation {

    public static void validar(Long id) {
        if (id == null) {
            throw new NullPointerException("Id inválido"); //criar exception
        }
    }
}
