package br.com.testtecnicoattus.testattus.services;

import java.util.List;
import org.apache.coyote.BadRequestException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.testtecnicoattus.testattus.Dto.PessoaDTO;
import br.com.testtecnicoattus.testattus.Repository.PessoaRepository;
import br.com.testtecnicoattus.testattus.entity.Pessoa;

@Service
public class AdicionaNovaPessoa {

	@Autowired
	PessoaRepository pessoaRepository;

	@Autowired
	ModelMapper modelMapper;

	public List<Pessoa> adicionaNovaPessoa(List<PessoaDTO> pessoasDTO) throws Exception {

		for (PessoaDTO pessoaDTO : pessoasDTO) {
			String nome = pessoaDTO.getNome();

			if (pessoaRepository.findByNome(nome) != null) {
				throw new BadRequestException("Já existe uma pessoa cadastrada com esse nome");
			}

		}
		
		for (PessoaDTO pessoaDTO : pessoasDTO) {
			var novaPessoa = modelMapper.map(pessoaDTO, Pessoa.class);
			pessoaRepository.save(novaPessoa);
		}
		
		return null;

	}
	
	

}
