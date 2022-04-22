package br.com.daianebellon.userservice.pessoa.service;

import br.com.daianebellon.userservice.pessoa.domain.Pessoa;
import br.com.daianebellon.userservice.pessoa.dto.PessoaDTO;

import java.util.Optional;

public interface PessoaService {

    Pessoa save(PessoaDTO pessoaDTO);

    Optional<Pessoa> findById(Long id);
}
