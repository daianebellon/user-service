package br.com.daianebellon.userservice.pessoa.validacoes;

import br.com.daianebellon.userservice.pessoa.dto.EnderecoDTO;
import br.com.daianebellon.userservice.pessoa.dto.PessoaDTO;
import br.com.daianebellon.userservice.pessoa.dto.TelefoneDTO;
import br.com.daianebellon.userservice.pessoa.exceptions.CampoInvalidoException;
import br.com.daianebellon.userservice.pessoa.exceptions.ErrorMessages;
import br.com.daianebellon.userservice.pessoa.repository.PessoaRepository;
import br.com.daianebellon.userservice.pessoa.repository.TelefoneRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class PessoaValidation {

    private final PessoaRepository repository;
    private final TelefoneRepository telefoneRepository;

    public PessoaValidation(PessoaRepository repository, TelefoneRepository telefoneRepository) {
        this.repository = repository;
        this.telefoneRepository = telefoneRepository;
    }

    public void validar(PessoaDTO pessoaDTO, Long id) {
        if (pessoaDTO.getNome() == null || pessoaDTO.getNome().isBlank()) {
            throw new CampoInvalidoException(String.format(ErrorMessages.CAMPO_INVALIDO_EXCEPTION.getMensagem(), "Nome"));
        }

        if (pessoaDTO.getSobrenome() == null || pessoaDTO.getSobrenome().isBlank()) {
            throw new CampoInvalidoException(String.format(ErrorMessages.CAMPO_INVALIDO_EXCEPTION.getMensagem(), "Sobrenome"));
        }

        validaDocumentoPessoal(pessoaDTO.getDocumentoPessoal(), id);
        validaTelefone(pessoaDTO.getTelefones());
        validaEndereco(pessoaDTO.getEndereco());
        validaDataNascimento(pessoaDTO);
    }

    private void validaDataNascimento(PessoaDTO pessoaDTO) {
        if (pessoaDTO.getDataNascimento() == null) {
            throw new CampoInvalidoException(String.format(ErrorMessages.CAMPO_INVALIDO_EXCEPTION.getMensagem(), "Data de Nascimento"));
        }

        LocalDate dataNascimento = pessoaDTO.getDataNascimento();
        LocalDate dataAtual = LocalDate.now();

        if ((dataAtual.compareTo(dataNascimento)) < 18) {
            throw new CampoInvalidoException(String.format(ErrorMessages.DATA_MENOR_QUE_DEZOITO_EXCEPTION.getMensagem(), "Data de Nascimento"));
        }
    }

    private void validaEndereco(EnderecoDTO endereco) {
        if (endereco == null) {
            throw new CampoInvalidoException(String.format(ErrorMessages.CAMPO_INVALIDO_EXCEPTION.getMensagem(), "Endereço"));
        }
    }


    private void validaTelefone(List<TelefoneDTO> telefones) {
        if (telefones == null || telefones.isEmpty()) {
            throw new CampoInvalidoException(String.format(ErrorMessages.CAMPO_INVALIDO_EXCEPTION.getMensagem(), "Telefone"));
        }

        for (TelefoneDTO telefone : telefones) {
            //ver aqui: problema ao editar
            boolean existeTelefoneCadastrado = telefoneRepository.existsTelefoneByNumero(telefone.getNumero());
            if (existeTelefoneCadastrado) {
                throw new CampoInvalidoException(String.format(ErrorMessages.EXISTE_TELEFONE_CADASTRADO_EXCEPTION.getMensagem(), "Telefone"));
            }
        }
    }

    private void validaDocumentoPessoal(String documentoPessoal, Long id) {
        if (documentoPessoal == null || documentoPessoal.isBlank()) {
            throw new CampoInvalidoException(String.format(ErrorMessages.CAMPO_INVALIDO_EXCEPTION.getMensagem(), "Documento Pessoal"));
        }

        if (documentoPessoal.length() != 11) {
            if (documentoPessoal.length() != 14) {
                throw new CampoInvalidoException(String.format(ErrorMessages.CAMPO_INVALIDO_EXCEPTION.getMensagem(), "Documento Pessoal"));
            }
        }

        boolean existeDocumentoPessoal = id != null
                ? repository.existsByDocumentoPessoalAndIdIsNot(documentoPessoal, id)
                : repository.existsByDocumentoPessoal(documentoPessoal);
        if (existeDocumentoPessoal) {
            throw new CampoInvalidoException(String.format(ErrorMessages.EXISTE_DOCUMENTO_PESSOAL_EXCEPTION.getMensagem(), "Documento Pessoal"));
        }
    }
}