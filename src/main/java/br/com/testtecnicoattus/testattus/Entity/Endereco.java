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
	
	public Endereco(String logradouro, String cep, String numero, String cidade, String estado, TipoEndereco tipoEndereco,
			Pessoa pessoa) {

		this.logradouro = logradouro;
		this.cep = cep;
		this.numero = numero;
		this.cidade = cidade;
		this.estado = estado;
		this.tipoEndereco = tipoEndereco;
		this.pessoa = pessoa;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "logradouro",nullable = false)
	private String logradouro;
	
	@Column(name = "cep",nullable = false)
	private String cep;
	
	@Column(name = "numeroEndereco",nullable = false)
	private String numero;
	
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
