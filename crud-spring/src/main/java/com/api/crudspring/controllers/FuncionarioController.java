package com.api.crudspring.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

}
