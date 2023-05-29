package br.unitins.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import jakarta.ws.rs.NotFoundException;
import br.unitins.dto.PessoaDTO;
import br.unitins.dto.PessoaResponseDTO;
import br.unitins.model.Pessoa;
import br.unitins.model.Sexo;
import br.unitins.repository.PessoaRepository;

@ApplicationScoped
public class PessoaServiceImpl implements PessoaService {

    @Inject
    PessoaRepository pessoaRepository;

    @Inject
    Validator validator;

    @Override
    public List<PessoaResponseDTO> getAll() {
        List<Pessoa> list = pessoaRepository.listAll();
        return list.stream().map(PessoaResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public PessoaResponseDTO findById(Long id) {
        Pessoa pessoa = pessoaRepository.findById(id);
        if (pessoa == null)
            throw new NotFoundException("Pessoa Física não encontrada.");
        return new PessoaResponseDTO(pessoa);
    }

    @Override
    @Transactional
    public PessoaResponseDTO create(PessoaDTO pessoaDTO) throws ConstraintViolationException {
        validar(pessoaDTO);

        Pessoa entity = new Pessoa();
        entity.setNome(pessoaDTO.nome());
        entity.setCpf(pessoaDTO.cpf());
        entity.setSexo(Sexo.valueOf(pessoaDTO.sexo()));

        pessoaRepository.persist(entity);

        return new PessoaResponseDTO(entity);
    }

    @Override
    @Transactional
    public PessoaResponseDTO update(Long id, PessoaDTO pessoaDTO) throws ConstraintViolationException{
        validar(pessoaDTO);
   
        Pessoa entity = pessoaRepository.findById(id);
        entity.setNome(pessoaDTO.nome());
        entity.setCpf(pessoaDTO.cpf());
        entity.setSexo(Sexo.valueOf(pessoaDTO.sexo()));

        return new PessoaResponseDTO(entity);
    }

    private void validar(PessoaDTO pessoaDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<PessoaDTO>> violations = validator.validate(pessoaDTO);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);


    }

    @Override
    @Transactional
    public void delete(Long id) {
        pessoaRepository.deleteById(id);
    }

    @Override
    public List<PessoaResponseDTO> findByNome(String nome) {
        List<Pessoa> list = pessoaRepository.findByNome(nome);
        return list.stream().map(PessoaResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public long count() {
        return pessoaRepository.count();
    }

}
