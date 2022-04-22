package br.com.daianebellon.userservice.pessoa.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class PessoaDTO {

    private String nome;
    private String sobrenome;
    private String documentoPessoal;
    private Date dataNascimento;
    private EnderecoDTO endereco;
    private List<TelefoneDTO> telefones;

}
