package br.com.testtecnicoattus.testattus.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.testtecnicoattus.testattus.Entity.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
	
	
	Pessoa findByNome(String nome);

	List<Pessoa> findByNomeContaining(String nome);
	
	Pessoa getPessoaById(Integer id);
	
	Boolean existsByNomeContaining(String nome);

	
	 List<Pessoa> findAll();
		
	
	
}
