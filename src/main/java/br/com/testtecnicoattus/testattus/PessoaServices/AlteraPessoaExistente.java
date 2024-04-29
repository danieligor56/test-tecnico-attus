package br.com.testtecnicoattus.testattus.PessoaServices;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.testtecnicoattus.testattus.Dto.PessoaDTO;
import br.com.testtecnicoattus.testattus.Entity.Pessoa;
import br.com.testtecnicoattus.testattus.Repository.PessoaRepository;
import exception.BadRequest;

@Service
public class AlteraPessoaExistente {

	@Autowired
	PessoaRepository repository;

	@Autowired
	ModelMapper modelMapper;

	public Pessoa alteraPessoa(List<Integer> id, List<PessoaDTO> dto){
		
		for(int i = 0 ; i < id.size() && i < dto.size();i++) {
			Integer ids = id.get(i);
			PessoaDTO pessoaAlterar = dto.get(i);
			
			boolean validaId = repository.existsById(ids);
			
			if(!validaId) {
				
				throw new BadRequest("Usuário com o id:"+ids+" Não encontrado");
			}
			
			else {
				Pessoa pessoaAlterada = modelMapper.map(pessoaAlterar, Pessoa.class);
				pessoaAlterada.setId(ids);
				repository.save(pessoaAlterada);
			}
		}
		
		
	return null;
}

}
