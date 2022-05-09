package br.com.daianebellon.userservice.pessoa.service;

import br.com.daianebellon.userservice.pessoa.domain.Pessoa;
import br.com.daianebellon.userservice.pessoa.dto.PessoaDTO;

public interface PessoaService {

    Long cadastrar(PessoaDTO pessoaDTO);
    Pessoa findById(Long id);
    Long editar(Long id, PessoaDTO pessoaDTO);
    void excluir(Long id);
}
