package br.com.testtecnicoattus.testattus.EnderecoServices;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.testtecnicoattus.testattus.Dto.EnderecoDTO;
import br.com.testtecnicoattus.testattus.Entity.Endereco;
import br.com.testtecnicoattus.testattus.Repository.EnderecoRepository;
import exception.BadRequest;

@Service
public class AlteraEndereco {
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	EnderecoRepository repository;
	
	public AlteraEndereco alteraEndereco(List<Integer> id,List<EnderecoDTO> enderecoDto) {
			for(EnderecoDTO endereco:enderecoDto) {
			Boolean vericadorEndereco = repository.existsByLogradouroAndCepAndNumeroAndCidadeAndEstado(
						endereco.getLogradouro(),
						endereco.getCep(),
						endereco.getNumero(),
						endereco.getCidade(),
						endereco.getEstado());
							
			if(vericadorEndereco) throw new BadRequest("O endereço cadastrado já existe");
				
			}

			for(int i = 0;i < id.size() &&  i < enderecoDto.size();i++){	
				Integer ids = id.get(i);
				EnderecoDTO enderecoAlterar = enderecoDto.get(i);
				
				if(ids != null && enderecoAlterar != null) {
				Boolean	validaId = repository.existsById(ids);
					if(!validaId) {
						throw new BadRequest("O id indicado:"+ids+". Não pertence a um endereco existente.");
					}
				}
				Endereco enderecoAlterado = modelMapper.map(enderecoAlterar, Endereco.class);
				enderecoAlterado.setId(ids);
				repository.save(enderecoAlterado);
							
			}
		
		return null;
	}

}
