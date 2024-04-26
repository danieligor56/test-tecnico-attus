package br.com.testtecnicoattus.testattus.PessoaServices;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import br.com.testtecnicoattus.testattus.Dto.PessoaDTO;
import br.com.testtecnicoattus.testattus.Entity.Pessoa;
import br.com.testtecnicoattus.testattus.Repository.PessoaRepository;

@Service
public class AlteraPessoaExistente {
	
	@Autowired
	PessoaRepository repository;
	
	@Autowired
	ModelMapper modelMapper;
	
	public Pessoa alteraPessoa(List<Integer> id, List<PessoaDTO> dto) throws NotFoundException {
		
		for(Integer ids : id) {
			var validaId = repository.findById(ids);
			
			if(validaId == null) throw new NotFoundException();
		}
		
		for(PessoaDTO pessoaDTO:dto) {
			var pessoaAlterada = modelMapper.map(pessoaDTO, Pessoa.class);
			for(Integer ids:id) {
				pessoaAlterada.setId(ids);
			}
		}
		
		return null;
	}

}
