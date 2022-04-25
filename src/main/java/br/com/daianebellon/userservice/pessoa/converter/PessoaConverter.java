package br.com.daianebellon.userservice.pessoa.converter;

import br.com.daianebellon.userservice.pessoa.domain.Endereco;
import br.com.daianebellon.userservice.pessoa.domain.Pessoa;
import br.com.daianebellon.userservice.pessoa.domain.Telefone;
import br.com.daianebellon.userservice.pessoa.dto.PessoaDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PessoaConverter {

    EnderecoConverter enderecoConverter;
    TelefoneConverter telefoneConverter;

    public PessoaConverter(EnderecoConverter enderecoConverter, TelefoneConverter telefoneConverter) {
        this.enderecoConverter = enderecoConverter;
        this.telefoneConverter = telefoneConverter;
    }

    public Pessoa converter(PessoaDTO pessoaDTO) {
        Endereco endereco = enderecoConverter.converter(pessoaDTO.getEndereco());
        List<Telefone> telefones = telefoneConverter.converter(pessoaDTO.getTelefones());

        Pessoa pessoa = new Pessoa();
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setSobrenome(pessoaDTO.getSobrenome());
        pessoa.setDocumentoPessoal(pessoaDTO.getDocumentoPessoal());
        pessoa.setDataNascimento(pessoaDTO.getDataNascimento());
        pessoa.setEndereco(endereco);
        pessoa.setTelefones(telefones);

        pessoa.getTelefones().forEach(telefone -> telefone.setPessoa(pessoa));

        return pessoa;
    }
}
