package br.com.testtecnicoattus.testattus.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.testtecnicoattus.testattus.Entity.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{
	
	Boolean existsByLogradouroAndCepAndNumeroAndCidadeAndEstado(String
	  logradouro, String cep, String numero, String cidade, String estado);
	
	List<Endereco> findByPessoaId(Integer pessoa);
	
	Endereco findEnderecoById(Integer id);
	 
	
	
	
}
