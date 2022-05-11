package br.com.daianebellon.userservice.pessoa.exceptions;

public enum ErrorMessages {
    CAMPO_INVALIDO_EXCEPTION("Campo [%s] inválido"),
    DATA_MENOR_QUE_DEZOITO_EXCEPTION("Campo [%s] inválido! Usuário não possui 18 anos!"),
    PESSOA_NAO_DEVE_POSSUIR_MAIS_QUE_DOIS_REGISTROS_EXCEPTION("Campo [%s] inválido! Máximo 2 telefones por usuário!"),
    PESSOA_NAO_ENCONTRADA_EXCEPTION("Não foi encontrado uma pessoa com o id: [%d]."),
    EXISTE_DOCUMENTO_PESSOAL_EXCEPTION("Já existe um usuário cadastrado com esse documento pessoal!"),
    EXISTE_TELEFONE_CADASTRADO_EXCEPTION("Telefone já cadastrado!");

    private String mensagem;

    ErrorMessages(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

}
