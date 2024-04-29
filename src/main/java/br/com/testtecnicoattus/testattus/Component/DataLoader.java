package br.com.testtecnicoattus.testattus.Component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.testtecnicoattus.testattus.Entity.Endereco;
import br.com.testtecnicoattus.testattus.Entity.Pessoa;
import br.com.testtecnicoattus.testattus.Repository.EnderecoRepository;
import br.com.testtecnicoattus.testattus.Repository.PessoaRepository;
import br.com.testtecnicoattus.testattus.TiposEndereco.TipoEndereco;
import jakarta.annotation.PostConstruct;

@Component
public class DataLoader {
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;

	@PostConstruct
	private void InitDataBase() {
			
		//PESSOA
		pessoaRepository.save(new Pessoa("Daniel Igor","15/12/1994"));
		pessoaRepository.save(new Pessoa("Pedro Silva","10/05/1987"));
		pessoaRepository.save(new Pessoa("Maria Oliveira","22/09/1990"));
		pessoaRepository.save(new Pessoa("Carlos Santos","05/11/1982"));
		pessoaRepository.save(new Pessoa("Ana Pereira","18/03/1998"));
		pessoaRepository.save(new Pessoa("Pedro Souza","30/07/1985"));
		
		//ENDERECO
		enderecoRepository.save(new Endereco("Rua das Flores","60030101","120B","São Paulo","São Paulo",TipoEndereco.PRICIPAL,pessoaRepository.getPessoaById(1)));
		enderecoRepository.save(new Endereco("Avenida Paulista", "60030101", "106A", "São Paulo", "São Paulo", TipoEndereco.TRABALHO,pessoaRepository.getPessoaById(2)));
		enderecoRepository.save(new Endereco("Torres Camara", "60030101", "662", "Fortaleza", "Ceara", TipoEndereco.SECUNDARIO,pessoaRepository.getPessoaById(1)));
		enderecoRepository.save(new Endereco("Graça Aranha", "60030101", "662", "Fortaleza", "Ceara", TipoEndereco.TRABALHO,pessoaRepository.getPessoaById(3)));
		enderecoRepository.save(new Endereco("Rua São Paulo", "60030101", "1346 - Altos", "Fortaleza", "Ceara", TipoEndereco.PRICIPAL,pessoaRepository.getPessoaById(4)));
	
	}
}
