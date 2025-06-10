package br.com.tryrun.corridas.services;

import br.com.tryrun.corridas.dto.CorridaDto;
import br.com.tryrun.corridas.model.ECorrida;
import br.com.tryrun.corridas.model.Status;
import br.com.tryrun.corridas.repository.CorridaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CorridaService {

    @Autowired
    private  CorridaRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public Page<CorridaDto> obterCorridas(Pageable paginacao) {
        return repository
                .findAll(paginacao)
                .map(entidade -> modelMapper.map(entidade, CorridaDto.class));
    }

    public CorridaDto obterCorridaPorId(Long id) {
        ECorrida entidade = repository.findById(id).orElseThrow( () -> new EntityNotFoundException());
        return modelMapper.map(entidade, CorridaDto.class);
    }

    public CorridaDto criarCorrida(CorridaDto corridaDto) {
        ECorrida entidade = modelMapper.map(corridaDto, ECorrida.class);
        entidade.setStatus(Status.ATIVA);
        repository.save(entidade);

        return modelMapper.map(entidade, CorridaDto.class);
    }

    public CorridaDto atualizarCorrida(Long id, CorridaDto corridaDto) {
        ECorrida entidade = modelMapper.map(corridaDto, ECorrida.class);
        entidade.setId(id);
        entidade = repository.save(entidade);

        return modelMapper.map(entidade, CorridaDto.class);
    }

    public void excluirCorrida(Long id) {
        repository.deleteById(id);
    }

}
