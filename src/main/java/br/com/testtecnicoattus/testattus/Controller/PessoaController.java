package br.com.testtecnicoattus.testattus.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.testtecnicoattus.testattus.Dto.PessoaDTO;
import br.com.testtecnicoattus.testattus.Entity.Pessoa;
import br.com.testtecnicoattus.testattus.PessoaServices.AdicionaNovaPessoa;
import br.com.testtecnicoattus.testattus.PessoaServices.AlteraPessoaExistente;
import br.com.testtecnicoattus.testattus.PessoaServices.EncontraPessoa;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/pessoa")
@RestController

public class PessoaController {
	
	@Autowired
	AdicionaNovaPessoa adicionaNovaPessoa;
	
	@Autowired
	AlteraPessoaExistente alteraPessoaExistente;
	
	@Autowired
	EncontraPessoa encontraPessoa;


	@Operation(summary = "Adiciona uma ou mais pessoas.", description = "Adiciona novas pessoas a lista de pessoas existentes")
	@PostMapping("/adicionaPessoa")	
	public ResponseEntity<Pessoa> adicionarPessoa(@RequestBody @Valid List<PessoaDTO> pessoaDTO) throws Exception{
		adicionaNovaPessoa.adicionaNovaPessoa(pessoaDTO);		
		return ResponseEntity.ok().build();
	}
	@Operation(summary = "Altera o registro de uma pessoa ou mais ", description = "Recebe como parametro um ID e um dto contendo as alterações")
	@PutMapping("/alteraPessoa")
	public ResponseEntity<Pessoa> alteraPessoa(@RequestParam List<Integer>id, @RequestBody List<PessoaDTO> pessoaDto) throws Exception {
		alteraPessoaExistente.alteraPessoa(id, pessoaDto);
		return ResponseEntity.ok().build();
	}
	@Operation(summary = "Encontra um registro de Pessoa por ID ", description = "Encontra um registro de pessoa utilizando o ID como parametro")
	@GetMapping("/encontraPessoa/{id}")
	public ResponseEntity<Pessoa> encontraPessoa(@RequestParam Integer id) {
		return ResponseEntity.ok().body(encontraPessoa.encontrarPessoa(id));
	}
	@Operation(summary = "Encontra registros por nome.", description = "Encontra registros utilizando o nome ou o fragmentos de um nome")
	@GetMapping("/encontraPessoaNome/")
	public ResponseEntity<List<Pessoa>> encontrPessoPorNome(@RequestParam String nome)  {
		return ResponseEntity.ok().body(encontraPessoa.encontrarPorNome(nome));
	}
	@Operation(summary = "Lista os registros existentes", description = "Lista todos os registros de Pessoa existentes")
	@GetMapping("/listarPessoa/")
	public ResponseEntity<List<Pessoa>> listarPessoas() {
		return ResponseEntity.ok().body(encontraPessoa.listarPessoas());
	}
	
	
	
	
	
	

}
