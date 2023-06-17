package com.api.crudspring.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.crudspring.models.Funcionario;

@Repository
public interface IFuncionarioRepository extends JpaRepository<Funcionario, UUID> {

  // boolean GetByCpf(String cpf);
}
