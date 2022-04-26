package br.com.daianebellon.userservice.pessoa.validacoes;

import br.com.daianebellon.userservice.pessoa.dto.PessoaDTO;
import br.com.daianebellon.userservice.pessoa.exceptions.CampoInvalidoException;

public class PessoaValidation {

    public static void validar(PessoaDTO pessoaDTO) {
        if (pessoaDTO.getTelefones() == null || pessoaDTO.getTelefones().isEmpty()) {
            throw new CampoInvalidoException("O telefone não pode ser nulo ou vazio");
        } else if (pessoaDTO.getTelefones().size() > 2) {
            throw new CampoInvalidoException("O telefone não pode conter mais que 2 registros");
        }

        if (pessoaDTO.getDocumentoPessoal() == null || pessoaDTO.getDocumentoPessoal().isBlank()) {
            throw new CampoInvalidoException("Documento não pode ser nulo ou vazio");
        }
    }
}