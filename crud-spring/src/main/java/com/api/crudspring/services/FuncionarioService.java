package com.api.crudspring.services;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import com.api.crudspring.dtos.CreateFunc_InputModel;
import com.api.crudspring.dtos.UpdateFunc_InputModel;
import com.api.crudspring.models.Funcionario;
import com.api.crudspring.repositories.IFuncionarioRepository;

@Service
public class FuncionarioService {
  private final IFuncionarioRepository funcionarioRepository;

  public FuncionarioService(IFuncionarioRepository funcionarioRepository) {
    this.funcionarioRepository = funcionarioRepository;
  }

  @Transactional
  public Funcionario save(Funcionario funcionario) {
    return funcionarioRepository.save(funcionario);
  }

  public Page<Funcionario> getAll(Pageable pageable) {
    return funcionarioRepository.findAll(pageable);
  }

  public List<Funcionario> getAllByOrderByName() {
    Sort sort = Sort.by("nome").ascending();
    List<Funcionario> funcionarios = funcionarioRepository.findAll(sort);
    return funcionarios;
  }

  public Optional<Funcionario> findById(UUID id) {
    return funcionarioRepository.findById(id);
  }

  public void delete(Funcionario funcionario) {
    funcionarioRepository.delete(funcionario);
  }

  public Funcionario Create(CreateFunc_InputModel inputModel) {
    Funcionario funcionario = new Funcionario();
    BeanUtils.copyProperties(inputModel, funcionario);
    funcionario.setCreatedAt(LocalDateTime.now(ZoneId.of("UTC")));
    return funcionario;
  }

  public Funcionario Update(Optional<Funcionario> funcionario, UpdateFunc_InputModel inputModel) {
    Funcionario funcionarioUpdate = new Funcionario();

    BeanUtils.copyProperties(inputModel, funcionarioUpdate);
    funcionarioUpdate.setId(funcionario.get().getId());
    funcionarioUpdate.setCreatedAt(funcionario.get().getCreatedAt());
    funcionarioUpdate.setSalario(funcionario.get().getSalario());
    return funcionarioUpdate;
  }

}
