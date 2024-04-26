package br.com.testtecnicoattus.testattus.EnderecoServices;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.testtecnicoattus.testattus.Dto.EnderecoDTO;
import br.com.testtecnicoattus.testattus.Entity.Endereco;
import br.com.testtecnicoattus.testattus.Repository.EnderecoRepository;
import exception.BadRequest;
import jakarta.validation.Valid;

@Service
public class AdicionaNovoEndereco {
	
	@Autowired
	EnderecoRepository repository;

	@Autowired
	ModelMapper modelMapper;

	public List<Endereco> adicionaNovoEndereco(@Valid List<EnderecoDTO> dto){
		for(EnderecoDTO endereco:dto) {
		Boolean vericadorEndereco = repository.existsByLogradouroAndCepAndNumeroAndCidadeAndEstado(
					endereco.getLogradouro(),
					endereco.getCep(),
					endereco.getNumero(),
					endereco.getCidade(),
					endereco.getEstado());
						
		if(vericadorEndereco) throw new BadRequest("O endereço cadastrado já existe");
			
		}
		
		for (EnderecoDTO enderecoDto : dto) {
				Endereco novoEndereco = modelMapper.map(enderecoDto, Endereco.class);
				repository.save(novoEndereco);
			}
		return null;

	}
		
		
}
