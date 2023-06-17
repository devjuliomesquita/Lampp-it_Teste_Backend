package com.api.crudspring.services;

import org.springframework.stereotype.Service;

import com.api.crudspring.repositories.IFuncionarioRepository;

@Service
public class FuncionarioService {
  private final IFuncionarioRepository funcionarioRepository;

  public FuncionarioService(IFuncionarioRepository funcionarioRepository) {
    this.funcionarioRepository = funcionarioRepository;
  }

}
