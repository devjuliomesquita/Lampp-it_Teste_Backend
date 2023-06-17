package com.api.crudspring.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

import com.api.crudspring.models.Funcionario;
import com.api.crudspring.repositories.IFuncionarioRepository;

import jakarta.transaction.Transactional;

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

  public Optional<Funcionario> findById(UUID id) {
    return funcionarioRepository.findById(id);
  }

  public void delete(Funcionario funcionario) {
    funcionarioRepository.delete(funcionario);
  }
  // public boolean GetByCpf(String cpf) {
  // return funcionarioRepository.GetByCpf(cpf);
  // }

}
