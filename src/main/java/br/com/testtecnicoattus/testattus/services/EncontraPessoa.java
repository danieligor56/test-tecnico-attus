package br.com.testtecnicoattus.testattus.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.testtecnicoattus.testattus.Repository.PessoaRepository;
import br.com.testtecnicoattus.testattus.entity.Pessoa;
import exception.NotFound;

@Service
public class EncontraPessoa {
	
	@Autowired
	PessoaRepository repository;
	
	public Pessoa encontrarPessoa(Integer id) {
		
		boolean verificaId = repository.existsById(id);
		
		if(verificaId ) {
			Pessoa encontrarPessoa = repository.getPessoaById(id);
			
			return encontrarPessoa;
		}
			
		throw new NotFound("Não há usuarios cadastrados com esse ID");
	}
	
	
	public List<Pessoa> encontrarPorNome(String nome) {
		boolean verificaNomes = repository.existsByNomeContaining(nome);
		
		if(verificaNomes) {
			
			List<Pessoa> listaPessoas = repository.findByNomeContaining(nome);
			
			return listaPessoas;
			
		}
		
		throw new NotFound("Não há usuários cadastrados com o nome fornecido");
		
	}
	
	public List<Pessoa> listarPessoas(){
		return repository.findAll();	
	}
	
		
		
	
	
}
	
	
	


