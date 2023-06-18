package com.api.crudspring.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.crudspring.dtos.CreateFunc_InputModel;
import com.api.crudspring.dtos.UpdateFunc_InputModel;
import com.api.crudspring.models.Funcionario;
import com.api.crudspring.services.FuncionarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/funcionario")
public class FuncionarioController {
  private final FuncionarioService funcionarioService;

  public FuncionarioController(FuncionarioService funcionarioService) {
    this.funcionarioService = funcionarioService;
  }

  @PostMapping
  @Operation(summary = "Cadastro de um novo funcionário.", description = "Cadastrar funcionários de acordo com os parametros abaixo.")
  @ApiResponse(responseCode = "201", description = "Funcionário criado com sucesso.")
  @ApiResponse(responseCode = "500", description = "Erro na criação do usuário.")
  public ResponseEntity<Object> Create(@RequestBody @Valid CreateFunc_InputModel inputModel) {

    var funcionario = funcionarioService.Create(inputModel);
    funcionarioService.save(funcionario);
    return ResponseEntity.status(HttpStatus.CREATED).body("Funcionário criado com sucesso.");
  }

  @GetMapping
  @Operation(summary = "Retorna todos os funcionários.", description = "Foi realizado uma paginação para melhor controle.")
  @ApiResponse(responseCode = "200")
  @ApiResponse(responseCode = "500", description = "Erro...")
  public ResponseEntity<Page<Funcionario>> GetAll(
      @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
    return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.getAll(pageable));
  }

  @GetMapping("/byOrder-name")
  @Operation(summary = "Retorna todos os funcionários em ordem alfabética.", description = "Lista de funcionários ordenado pelo nome cadastrado.")
  @ApiResponse(responseCode = "200")
  @ApiResponse(responseCode = "500", description = "Erro...")
  public ResponseEntity<List<Funcionario>> GetAllByOrderName() {
    return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.getAllByOrderByName());
  }

  @GetMapping("/{id}")
  @Operation(summary = "Retorna somente um funcionário buscado pelo Id.", description = "Retorna um único funcionário.")
  @ApiResponse(responseCode = "200")
  @ApiResponse(responseCode = "404", description = "Funcionário não encontrado.")
  @ApiResponse(responseCode = "500", description = "Erro...")
  public ResponseEntity<Object> GetById(@PathVariable(value = "id") UUID id) {
    Optional<Funcionario> funcionario = funcionarioService.findById(id);
    if (!funcionario.isPresent()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionário não encontrado.");
    }
    return ResponseEntity.status(HttpStatus.OK).body(funcionario.get());
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "Excluir funcionário pelo Id.", description = "Excluir definitivamente um funcionário pelo Id.")
  @ApiResponse(responseCode = "204", description = "Funcionário excluido com éxito.")
  @ApiResponse(responseCode = "404", description = "Funcionário não encontrado.")
  @ApiResponse(responseCode = "500", description = "Erro...")
  public ResponseEntity<Object> Delete(@PathVariable(value = "id") UUID id) {
    Optional<Funcionario> funcionario = funcionarioService.findById(id);
    if (!funcionario.isPresent()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionário não encontrado.");
    }
    funcionarioService.delete(funcionario.get());
    return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Funcionário excluido com sucesso.");
  }

  @PutMapping("/{id}")
  @Operation(summary = "Atualizar cadastro do funcionário pelo Id.", description = "Atualizar cadastros de Nome, CPF e Cargo.")
  @ApiResponse(responseCode = "200")
  @ApiResponse(responseCode = "404", description = "Funcionário não encontrado.")
  @ApiResponse(responseCode = "500", description = "Erro...")
  public ResponseEntity<Object> Update(@PathVariable(value = "id") UUID id,
      @RequestBody @Valid UpdateFunc_InputModel inputModel) {
    Optional<Funcionario> funcionario = funcionarioService.findById(id);
    if (!funcionario.isPresent()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionário não encontrado.");
    }
    var funcionarioUpdate = funcionarioService.Update(funcionario, inputModel);
    funcionarioService.save(funcionarioUpdate);
    return ResponseEntity.status(HttpStatus.OK)
        .body("Funcionário: " + funcionarioUpdate.getNome() + " atualizado com sucesso.");

  }
}
