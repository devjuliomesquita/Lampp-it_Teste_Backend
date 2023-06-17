package com.api.crudspring.services;

import org.springframework.stereotype.Service;

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

  public boolean GetByCpf(String cpf) {
    return funcionarioRepository.GetByCpf(cpf);
  }
}
