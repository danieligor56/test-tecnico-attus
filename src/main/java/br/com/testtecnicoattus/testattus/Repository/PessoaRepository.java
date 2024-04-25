package br.com.testtecnicoattus.testattus.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.testtecnicoattus.testattus.entity.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

	Object findByNome(String nome);

}
