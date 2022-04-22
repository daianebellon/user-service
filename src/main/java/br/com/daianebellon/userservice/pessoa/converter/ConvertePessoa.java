package br.com.daianebellon.userservice.pessoa.converter;

import br.com.daianebellon.userservice.pessoa.domain.Endereco;
import br.com.daianebellon.userservice.pessoa.domain.Pessoa;
import br.com.daianebellon.userservice.pessoa.dto.PessoaDTO;
import br.com.daianebellon.userservice.pessoa.domain.Telefone;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConvertePessoa {

    EnderecoConverter enderecoConverter;
    TelefoneConverter telefoneConverter;

    public ConvertePessoa(EnderecoConverter enderecoConverter, TelefoneConverter telefoneConverter) {
        this.enderecoConverter = enderecoConverter;
        this.telefoneConverter = telefoneConverter;
    }

//    public Pessoa converter(PessoaDTO pessoaDTO) {
//        Endereco endereco = enderecoConverter.converter(pessoaDTO.getEndereco());
//        List<Telefone> telefones = telefoneConverter.converter(pessoaDTO.getTelefones());
//
//        Pessoa pessoa = Pessoa.builder()
//                .nome(pessoaDTO.getNome())
//                .sobrenome(pessoaDTO.getSobrenome())
//                .dataNascimento(pessoaDTO.getDataNascimento())
//                .documentoPessoal(pessoaDTO.getDocumentoPessoal())
//                .endereco(endereco)
//                .telefones(telefones)
//                .build();
//
//        pessoa.getTelefones().forEach(telefone -> telefone.setPessoa(pessoa));
//
//        return pessoa;
//    }
}
