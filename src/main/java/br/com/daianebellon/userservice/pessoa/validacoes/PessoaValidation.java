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

    private static final String NOME = "Nome";
    private static final String SOBRENOME = "Sobrenome";
    private static final String DATA_DE_NASCIMENTO = "Data de Nascimento";
    private static final String DOCUMENTO_PESSOAL = "Documento Pessoal";
    private static final String ENDERECO = "Endereço";
    private static final String TELEFONE = "Telefone";

    private final PessoaRepository repository;
    private final TelefoneRepository telefoneRepository;

    public PessoaValidation(PessoaRepository repository, TelefoneRepository telefoneRepository) {
        this.repository = repository;
        this.telefoneRepository = telefoneRepository;
    }

    public void validaCadastroPessoaDTO(PessoaDTO pessoaDTO) {

        if (repository.existsByDocumentoPessoal(pessoaDTO.getDocumentoPessoal())) {
            throw new CampoInvalidoException(ErrorMessages.EXISTE_DOCUMENTO_PESSOAL_EXCEPTION, pessoaDTO.getDocumentoPessoal());
        }

        for (TelefoneDTO telefone : pessoaDTO.getTelefones()) {
            if (telefoneRepository.existsTelefoneByNumero(telefone.getNumero())) {
                throw new CampoInvalidoException(ErrorMessages.EXISTE_TELEFONE_CADASTRADO_EXCEPTION, TELEFONE);
            }
        }

        validaPessoaDTO(pessoaDTO);
    }

    public void validaEditarPessoaDTO(PessoaDTO pessoaDTO) {
        validaPessoaDTO(pessoaDTO);
    }

    private void validaPessoaDTO(PessoaDTO pessoaDTO) {
        if (pessoaDTO.getNome() == null || pessoaDTO.getNome().isBlank()) {
            throw new CampoInvalidoException(ErrorMessages.CAMPO_INVALIDO_EXCEPTION, NOME);
        }

        if (pessoaDTO.getSobrenome() == null || pessoaDTO.getSobrenome().isBlank()) {
            throw new CampoInvalidoException(ErrorMessages.CAMPO_INVALIDO_EXCEPTION, SOBRENOME);
        }

        validaDocumentoPessoal(pessoaDTO.getDocumentoPessoal(), pessoaDTO.getId());
        validaTelefone(pessoaDTO.getTelefones());
        validaEndereco(pessoaDTO.getEndereco());
        validaDataNascimento(pessoaDTO);
    }

    private void validaDataNascimento(PessoaDTO pessoaDTO) {
        if (pessoaDTO.getDataNascimento() == null) {
            throw new CampoInvalidoException(ErrorMessages.CAMPO_INVALIDO_EXCEPTION, DATA_DE_NASCIMENTO);
        }

        LocalDate dataNascimento = pessoaDTO.getDataNascimento();
        LocalDate dataAtual = LocalDate.now();

        if ((dataAtual.compareTo(dataNascimento)) < 18) {
            throw new CampoInvalidoException(ErrorMessages.DATA_MENOR_QUE_DEZOITO_EXCEPTION, DATA_DE_NASCIMENTO);
        }
    }

    private void validaEndereco(EnderecoDTO endereco) {
        if (endereco == null) {
            throw new CampoInvalidoException(ErrorMessages.CAMPO_INVALIDO_EXCEPTION, ENDERECO);
        }
    }


    private void validaTelefone(List<TelefoneDTO> telefones) {
        if (telefones == null || telefones.isEmpty()) {
            throw new CampoInvalidoException(ErrorMessages.CAMPO_INVALIDO_EXCEPTION, TELEFONE);
        }
    }

    private void validaDocumentoPessoal(String documentoPessoal, Long id) {
        if (documentoPessoal == null) {
            throw new CampoInvalidoException(ErrorMessages.CAMPO_INVALIDO_EXCEPTION, DOCUMENTO_PESSOAL);
        }

        if (documentoPessoal.length() != 11 && documentoPessoal.length() != 14) {
            throw new CampoInvalidoException(ErrorMessages.CAMPO_INVALIDO_EXCEPTION, DOCUMENTO_PESSOAL);
        }
    }
}