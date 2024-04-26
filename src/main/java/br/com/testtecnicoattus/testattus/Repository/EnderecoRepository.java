package br.com.testtecnicoattus.testattus.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.testtecnicoattus.testattus.Dto.EnderecoDTO;
import br.com.testtecnicoattus.testattus.Entity.Endereco;
import java.util.List;


@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{

	/*
	 * Endereco findByLogradouroAndCepAndNumeroAndCidadeAndEstado( String
	 * logradouro, Long cep, Long numero, String cidade, String estado);
	 */
	
	
	Boolean existsByLogradouroAndCepAndNumeroAndCidadeAndEstado(String
	  logradouro, Long cep, Long numero, String cidade, String estado);
	 
	
	
	
}
