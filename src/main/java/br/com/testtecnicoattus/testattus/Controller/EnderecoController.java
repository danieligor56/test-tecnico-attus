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
import io.swagger.v3.oas.annotations.Operation;
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
	
	@Operation(summary = "Adiciona novo endereço", description = "Adiciona um novo endereço a lista de endereços existentes")
	@PostMapping("/adicionaEndereco")	
	public ResponseEntity<Endereco> adicionaEndereco(@RequestBody @Valid List<EnderecoDTO> dto){
		novoEndereco.adicionaNovoEndereco(dto);		
		return ResponseEntity.ok().build();
	}
	@Operation(summary = "Altera endereço", description = "Recebe como parametro o Id referente ao endereço que deseja alterar"
			+ "e um DTO da classe contendo as alterações. "
			+ "Também pode ser utilizado para setar o tipo de endereços,sendo: "+"\n"
			+"0 = PRINCIPAL,"+"\n"
			+"1 = SECUNDARIO,"+"\n"
			+"2 = TRABALHO.")
	
	@PutMapping("/alteraEndereco")	
	public ResponseEntity<Endereco> alteraEndereco(@RequestParam List<Integer> idEndereco, @RequestBody List<EnderecoDTO> dto){
		alteraEndereco.alteraEndereco(idEndereco,dto);		
		return ResponseEntity.ok().build();
	}
	
	@Operation(summary = "Lista endereços", description = "Lista todos os endereços")
	@GetMapping("/listaEnderecos")
	public ResponseEntity<List<Endereco>> listaEnderecos(){
		return ResponseEntity.ok().body(listaEnderecos.listaEnderecos());
	}
	@Operation(summary = "Lista endereços por pessoa", description = "Recebe como parametro um id referente a "
			+ "uma pessoa e devolve todos os endereços pertencentes a ela")
	
	@GetMapping("/ListaPorPessoa")
	public ResponseEntity<List<Endereco>> listaEnderecoPorPessoa(@RequestParam Integer id){
		return ResponseEntity.ok().body(listaEnderecos.listaEnderecoPorPessoa(id));
	}
	@Operation(summary = "Encontrar um endereço por ID", description = "Recebe um ID do tipo Integer e devolve o endereço referente.")
	
	@GetMapping("/encontrarPorId")
	public ResponseEntity<Endereco> encontraPorId(@RequestParam Integer id){
		return ResponseEntity.ok().body(listaEnderecos.encontraPorId(id));
	}

 }



