package br.com.testtecnicoattus.testattus.Entity;

import br.com.testtecnicoattus.testattus.TiposEndereco.TipoEndereco;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "endereco")

public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "logradouro",nullable = false)
	private String logradouro;
	
	@Column(name = "cep",nullable = false)
	private Long cep;
	
	@Column(name = "numeroEndereco",nullable = false)
	private Long numero;
	
	@Column(name = "cidade",nullable = false)
	private String cidade;
	
	@Column(name = "estado",nullable = false)
	private String estado;
	
	@Column(name = "tipoEndereco",nullable = false)
	private TipoEndereco tipoEndereco;
	
	@ManyToOne
	@JoinColumn(name = "pessoa_id",nullable = true)
	private Pessoa pessoa;
	
	
}
