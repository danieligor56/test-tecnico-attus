package br.com.testtecnicoattus.testattus.Component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.testtecnicoattus.testattus.Entity.Pessoa;
import br.com.testtecnicoattus.testattus.Repository.PessoaRepository;
import jakarta.annotation.PostConstruct;

@Component
public class DataLoader {
	
	@Autowired
	PessoaRepository repository;

	@PostConstruct
	private void InitDataBase() {
		
		repository.save(new Pessoa("Daniel Igor","15/12/1994"));
		repository.save(new Pessoa("Pedro Silva","10/05/1987"));
		repository.save(new Pessoa("Maria Oliveira","22/09/1990"));
		repository.save(new Pessoa("Carlos Santos","05/11/1982"));
		repository.save(new Pessoa("Ana Pereira","18/03/1998"));
		repository.save(new Pessoa("Pedro Souza","30/07/1985"));
	
	}
}
