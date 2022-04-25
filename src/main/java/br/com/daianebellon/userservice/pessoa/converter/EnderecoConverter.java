package br.com.daianebellon.userservice.pessoa.converter;

import br.com.daianebellon.userservice.pessoa.dto.EnderecoDTO;
import br.com.daianebellon.userservice.pessoa.domain.Endereco;
import org.springframework.stereotype.Component;

@Component
public class EnderecoConverter {

    public Endereco converter(EnderecoDTO enderecoDTO) {
        Endereco endereco = new Endereco();
        endereco.setCep(enderecoDTO.getCep());
        endereco.setEstado(enderecoDTO.getEstado());
        endereco.setCidade(enderecoDTO.getCidade());
        endereco.setBairro(enderecoDTO.getBairro());
        endereco.setRua(enderecoDTO.getRua());
        endereco.setNumero(enderecoDTO.getNumero());
        return endereco;
    }
}
