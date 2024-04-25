package br.com.testtecnicoattus.testattus.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.testtecnicoattus.testattus.Dto.PessoaDTO;
import br.com.testtecnicoattus.testattus.entity.Pessoa;
import br.com.testtecnicoattus.testattus.services.AdicionaNovaPessoa;
import br.com.testtecnicoattus.testattus.services.AlteraPessoaExistente;
import br.com.testtecnicoattus.testattus.services.EncontraPessoa;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
	
	@PostMapping("/adicionaPessoa")	
	public ResponseEntity<Pessoa> adicionarPessoa(@RequestBody @Valid List<PessoaDTO> pessoaDTO) throws Exception{
		adicionaNovaPessoa.adicionaNovaPessoa(pessoaDTO);		
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/alteraPessoa")
	public ResponseEntity<Pessoa> alteraPessoa(@RequestParam List<Integer>id, @RequestBody List<PessoaDTO> pessoaDto) throws Exception {
		alteraPessoaExistente.alteraPessoa(id, pessoaDto);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/encontraPessoa/{id}")
	public ResponseEntity<Pessoa> encontrPesso(@RequestParam Integer id) {
		return ResponseEntity.ok().body(encontraPessoa.encontrarPessoa(id));
	}
	
	@GetMapping("/encontraPessoaNome/")
	public ResponseEntity<List<Pessoa>> encontrPessoPorNome(@RequestParam String nome)  {
		return ResponseEntity.ok().body(encontraPessoa.encontrarPorNome(nome));
	}
	
	
	
	
	
	

}
