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
import br.com.testtecnicoattus.testattus.Dto.EnderecoDTO;
import br.com.testtecnicoattus.testattus.EnderecoServices.AdicionaNovoEndereco;
import br.com.testtecnicoattus.testattus.EnderecoServices.AlteraEndereco;
import br.com.testtecnicoattus.testattus.EnderecoServices.ListaEnderecos;
import br.com.testtecnicoattus.testattus.Entity.Endereco;
import jakarta.validation.Valid;

@Controller
@RestController
@RequestMapping("/endereco")

public class EnderecoController {
	
	@Autowired
	AdicionaNovoEndereco novoEndereco;
	
	@Autowired
	AlteraEndereco alteraEndereco;
	
	@Autowired
	ListaEnderecos listaEnderecos;
	
	@PostMapping("/adicionaEndereco")	
	public ResponseEntity<Endereco> adicionaEndereco(@RequestBody @Valid List<EnderecoDTO> dto){
		novoEndereco.adicionaNovoEndereco(dto);		
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/alteraEndereco")	
	public ResponseEntity<Endereco> alteraEndereco(@RequestParam List<Integer> idEndereco, @RequestBody List<EnderecoDTO> dto){
		alteraEndereco.alteraEndereco(idEndereco,dto);		
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/listaEnderecos")
	public ResponseEntity<List<Endereco>> listaEnderecos(){
		return ResponseEntity.ok().body(listaEnderecos.listaEnderecos());
	}
	
	@GetMapping("/ListaPorPessoa")
	public ResponseEntity<List<Endereco>> listaEnderecoPorPessoa(@RequestParam Integer id){
		return ResponseEntity.ok().body(listaEnderecos.listaEnderecoPorPessoa(id));
	}
	@GetMapping("/encontrarPorId")
	public ResponseEntity<Endereco> encontraPorId(@RequestParam Integer id){
		return ResponseEntity.ok().body(listaEnderecos.encontraPorId(id));
	}

 }



