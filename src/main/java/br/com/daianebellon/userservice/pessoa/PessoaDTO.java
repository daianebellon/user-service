package br.com.daianebellon.userservice.pessoa;

import br.com.daianebellon.userservice.endereo.EnderecoDTO;
import br.com.daianebellon.userservice.telefone.TelefoneDTO;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
@Builder
public class PessoaDTO {

    private String nome;
    private String sobrenome;
    private String documentoPessoal;
    private Date dataNascimento;
    private EnderecoDTO endereco;
    private List<TelefoneDTO> telefones;

}
