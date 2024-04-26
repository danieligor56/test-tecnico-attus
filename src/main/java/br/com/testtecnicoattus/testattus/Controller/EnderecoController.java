package br.com.testtecnicoattus.testattus.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.testtecnicoattus.testattus.Dto.EnderecoDTO;
import br.com.testtecnicoattus.testattus.EnderecoServices.AdicionaNovoEndereco;
import br.com.testtecnicoattus.testattus.Entity.Endereco;
import jakarta.validation.Valid;

@Controller
@RestController
@RequestMapping("/endereco")

public class EnderecoController {
	
	@Autowired
	AdicionaNovoEndereco novoEndereco;
	
	@PostMapping("/adicionaEndereco")	
	public ResponseEntity<Endereco> adicionaEndereco(@RequestBody @Valid List<EnderecoDTO> dto){
		novoEndereco.adicionaNovoEndereco(dto);		
		return ResponseEntity.ok().build();
	}

}
