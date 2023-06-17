package com.api.crudspring.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.crudspring.dtos.CreateFunc_InputModel;
import com.api.crudspring.models.Funcionario;
import com.api.crudspring.services.FuncionarioService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/funcionario")
public class FuncionarioController {
  private final FuncionarioService funcionarioService;

  public FuncionarioController(FuncionarioService funcionarioService) {
    this.funcionarioService = funcionarioService;
  }

  @PostMapping
  public ResponseEntity<Object> Create(@RequestBody @Valid CreateFunc_InputModel inputModel) {

    Funcionario funcionario = new Funcionario();
    BeanUtils.copyProperties(inputModel, funcionario);
    funcionario.setCreatedAt(LocalDateTime.now(ZoneId.of("UTC")));
    return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioService.save(funcionario));
  }

  @GetMapping
  public ResponseEntity<List<Funcionario>> GetAll() {
    return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.getAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Object> GetById(@PathVariable(value = "id") UUID id) {
    Optional<Funcionario> funcionario = funcionarioService.findById(id);
    if (!funcionario.isPresent()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionário não encontrado.");
    }
    return ResponseEntity.status(HttpStatus.OK).body(funcionario.get());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> Delete(@PathVariable(value = "id") UUID id) {
    Optional<Funcionario> funcionario = funcionarioService.findById(id);
    if (!funcionario.isPresent()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionário não encontrado.");
    }
    funcionarioService.delete(funcionario.get());
    return ResponseEntity.status(HttpStatus.OK).body("Funcionário excluido com sucesso.");
  }
}
