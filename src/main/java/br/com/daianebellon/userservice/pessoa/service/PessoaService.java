package br.com.daianebellon.userservice.pessoa.service;

import br.com.daianebellon.userservice.pessoa.domain.Pessoa;
import br.com.daianebellon.userservice.pessoa.dto.PessoaDTO;
import org.springframework.http.ResponseEntity;

public interface PessoaService {

    Long cadastrar(PessoaDTO pessoaDTO);
    Pessoa findById(Long id);
    Long editar(Long id, PessoaDTO pessoaDTO);
    ResponseEntity excluir(Long id);
}
