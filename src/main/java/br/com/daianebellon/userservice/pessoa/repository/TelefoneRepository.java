package br.com.daianebellon.userservice.pessoa.repository;

import br.com.daianebellon.userservice.pessoa.domain.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
    boolean existsTelefoneByNumero(String numeroTelefone);
}
