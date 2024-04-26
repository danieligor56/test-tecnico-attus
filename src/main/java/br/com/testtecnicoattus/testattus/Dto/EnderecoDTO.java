package br.com.testtecnicoattus.testattus.Dto;

import br.com.testtecnicoattus.testattus.Entity.Pessoa;
import br.com.testtecnicoattus.testattus.TiposEndereco.TipoEndereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class EnderecoDTO {
	
	private String logradouro;
	
	private Long cep;
	
	private Long numero;
	
	private String cidade;
	
	private String estado;
	
	private TipoEndereco tipoEndereco;
	
	private Pessoa pessoa;

}
