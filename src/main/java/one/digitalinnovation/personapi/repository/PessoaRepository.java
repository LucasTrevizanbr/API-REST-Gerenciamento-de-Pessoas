package one.digitalinnovation.personapi.repository;

import one.digitalinnovation.personapi.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
