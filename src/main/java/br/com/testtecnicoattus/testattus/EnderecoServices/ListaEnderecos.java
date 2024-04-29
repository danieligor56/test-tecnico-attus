package br.com.testtecnicoattus.testattus.EnderecoServices;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.testtecnicoattus.testattus.Entity.Endereco;
import br.com.testtecnicoattus.testattus.Repository.EnderecoRepository;

@Service

public class ListaEnderecos {
	
	@Autowired
	EnderecoRepository repository;
	
	public List<Endereco> listaEnderecos(){
		return repository.findAll();
	}
	
	public List<Endereco>listaEnderecoPorPessoa(Integer idPessoa){
		return repository.findByPessoaId(idPessoa);
		
	}
	
	public Endereco encontraPorId(Integer id) {
		return repository.findEnderecoById(id);
		
	}

}
