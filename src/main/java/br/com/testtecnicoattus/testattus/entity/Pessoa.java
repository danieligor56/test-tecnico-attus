package br.com.testtecnicoattus.testattus.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Pessoas")

public class Pessoa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public Pessoa(String nome,String dataNascimento) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;	
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@Valid
	@Column(name = "nomeCompleto",nullable = false,unique = true)
	private String nome;
	
	@Valid
	@Column(name = "dataNascimento",nullable = false)
	private String dataNascimento;
	
	}


