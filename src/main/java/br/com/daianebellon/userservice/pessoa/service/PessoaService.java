package br.com.daianebellon.userservice.pessoa.service;

import br.com.daianebellon.userservice.pessoa.domain.Pessoa;
import br.com.daianebellon.userservice.pessoa.dto.PessoaDTO;

public interface PessoaService {

    Long save(PessoaDTO pessoaDTO);
    Pessoa findById(Long id);

}
